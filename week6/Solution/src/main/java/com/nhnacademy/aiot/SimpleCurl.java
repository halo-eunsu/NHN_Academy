package com.nhnacademy.aiot;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleCurl {
    static String[] supportedSchemes = { "http" };
    static String newLine = "\r\n";
    static final String SCHEME_DELIMITOR = ":";
    static final String START_OF_AUTHORITY = "//";
    static final String DOMAIN_DELIMITOR = "/";
    static final String DOMAIN_PORT_DELIMITOR = ":";
    static final String START_OF_PATH = "/";
    static final String START_OF_QUERY = "?";
    static final String PARAMETER_DELIMITOR = "#";
    static final String REGEX_SCHEME = "\\w+";
    static final String REGEX_DOMAIN = "[^/]+";
    static final String REGEX_PORT = "\\d{1,5}+";
    static final String REGEX_PATH = "\\/[^?]+";
    static final String REGEX_QUERY = "[^=]+=[^=&]+";
    static final Pattern schemePattern = Pattern.compile(REGEX_SCHEME);
    static final Pattern domainPattern = Pattern.compile(REGEX_DOMAIN);
    static final Pattern portPattern = Pattern.compile(REGEX_PORT);
    static final Pattern authorityPattern = Pattern.compile(REGEX_DOMAIN + "(:" + REGEX_PORT + ")?");
    static final Pattern pathPattern = Pattern.compile(REGEX_PATH);
    static final Pattern queriesPattern = Pattern.compile(REGEX_QUERY + "(&" + REGEX_QUERY + ")*"); // [^=]+=[^=&]+(&[^=]+=[^=&]+)*
    static final Pattern queryPattern = Pattern.compile(REGEX_QUERY);

    String scheme = "http";
    String domain = "";
    boolean verbose = false;
    String method = "GET";
    String host = "";
    int port = 80;
    String path = "/";
    List<String> headers = new LinkedList<>();
    List<String> multipart = new LinkedList<>();
    String data;
    Logger logger;
    Map<String, String> queryMap = new HashMap<>();

    public SimpleCurl() {
        logger = LogManager.getLogger(this.getClass().getSimpleName());
    }

    public void setScheme(String scheme) {
        if (!isSupportedScheme(scheme)) {
            throw new InvalidURLException();
        }

        this.scheme = scheme;
    }

    public boolean isSupportedScheme(String scheme) {
        return Arrays.stream(supportedSchemes).anyMatch(scheme::equalsIgnoreCase);
    }

    public void setMethod(String method) throws InvalidMethodException {
        if (!(method.equalsIgnoreCase("GET") || method.equalsIgnoreCase("PUT") || method.equalsIgnoreCase("POST"))) {
            throw new InvalidMethodException(method);
        }

        this.method = method;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
    }

    public void setAuthority(String authority) {
        Matcher portMatcher = portPattern.matcher(authority);
        if (portMatcher.find()) {
            setPort(Integer.parseInt(authority.substring(portMatcher.start() + 1, portMatcher.end())));
            setHost(authority.substring(0, portMatcher.start()));
        } else {
            setHost(authority);
        }
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void addHeader(String header) {
        headers.add(header);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        System.out.println("Path : " + path);
        this.path = path;
    }

    public void addQuery(String query) {
        String[] fields = query.split("=");
        if (fields.length == 2) {
            queryMap.put(fields[0].toLowerCase(), fields[1]);
            logger.trace("Query : {} - {}", fields[0], fields[1]);
        }
    }

    public void setData(String data) {
        this.data = data;
    }

    public void addMultipart(String name, String content) {
        if (content.matches("@(.*)")) {
            addMultipartFile(name, content.substring(1));
        } else {
            StringBuilder builder = new StringBuilder();

            builder.append(String.format("Content-Disposition: form-data; name=%s%s", name, newLine));
            builder.append(newLine);
            builder.append(content);

            multipart.add(builder.toString());
        }
    }

    public void addMultipartFile(String name, String filename) {
        try (FileReader reader = new FileReader(filename)) {
            StringBuilder builder = new StringBuilder();

            builder.append(
                    String.format("Content-Disposition: form-data; name=%s; filename=%s%s", name, filename, newLine));
            builder.append(newLine);

            char[] buffer = new char[10000];
            int length;

            while ((length = reader.read(buffer)) > 0) {
                builder.append(buffer, 0, length);
            }

            multipart.add(builder.toString());
        } catch (IOException ignore) {
            //
        }
    }

    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    public void setUrl(String url) {
        int searchPosition = 0;

        int endOfScheme = url.indexOf(SCHEME_DELIMITOR, searchPosition);
        if (endOfScheme <= 0) {
            throw new InvalidURLException();
        }

        String substring = url.substring(searchPosition, endOfScheme);
        Matcher schemeMatcher = schemePattern.matcher(substring);
        if (!schemeMatcher.find()) {
            throw new InvalidURLException();
        }
        setScheme(substring);
        searchPosition = endOfScheme;

        int startOfAuthority = url.indexOf(START_OF_AUTHORITY, searchPosition);
        if (startOfAuthority > 0) {
            searchPosition += START_OF_AUTHORITY.length();

            Matcher authorityMatcher = authorityPattern.matcher(url.substring(searchPosition));
            if (authorityMatcher.find()) {
                setAuthority(url.substring(searchPosition + authorityMatcher.start(),
                        searchPosition + authorityMatcher.end()));
                searchPosition += authorityMatcher.end();
            }
        }

        int startOfPath = url.indexOf(START_OF_PATH, searchPosition);
        if (startOfPath > 0) {
            Matcher pathMatcher = pathPattern.matcher(url.substring(searchPosition));
            if (!pathMatcher.find()) {
                throw new InvalidURLException();
            }

            setPath(url.substring(searchPosition + pathMatcher.start(), searchPosition + pathMatcher.end()));
            searchPosition += pathMatcher.end();
        }

        int startOfQuery = url.indexOf(START_OF_QUERY, searchPosition);
        if (startOfQuery > 0) {
            Matcher queriesMatcher = queriesPattern.matcher(url.substring(searchPosition));
            if (!queriesMatcher.matches()) {
                throw new InvalidURLException();
            }

            String queryString = url.substring(searchPosition + queriesMatcher.start() + 1,
                    searchPosition + queriesMatcher.end());
            Matcher queryMatcher = queryPattern.matcher(queryString);
            while (!queryMatcher.find()) {
                addQuery(queryString.substring(queryMatcher.start(), queryMatcher.end()));
            }
            searchPosition += queriesMatcher.end() + 1;
        }
    }

    public Response receiveResponse(BufferedInputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line = reader.readLine();
        if (line == null) {
            throw new InvalidResponseException();
        }
        if (verbose) {
            System.out.println("> " + line);
        }

        String[] responseHeader = line.split("\\s");
        if (responseHeader.length != 3) {
            throw new InvalidResponseException();
        }

        Response response = new Response(responseHeader[0], Integer.parseInt(responseHeader[1]), responseHeader[2]);

        while ((line = reader.readLine()) != null) {
            if (verbose) {
                System.out.println("< " + line);
            }

            if (line.length() == 0) {
                break;
            }

            int delimiterIndex = line.indexOf(':', 0);
            if (delimiterIndex < 0) {
                throw new InvalidResponseException();
            }

            response.addHeader(line.substring(0, delimiterIndex).trim(), line.substring(delimiterIndex + 1).trim());
        }

        if (response.hasHeader("Content-Length")) {
            int length = Integer.parseInt(response.getHeader("Content-Length"));
            char[] buffer = new char[length];

            reader.read(buffer, 0, length);

            response.addBody(new String(buffer, 0, length));
        }

        return response;
    }

    public void sendRequest(BufferedOutputStream socketOut) throws IOException {
        Request request = new Request(method, getPath());
        request.setHost(host, port);
        for (String header : headers) {
            request.addHeader(header);
        }

        if (data != null) {
            request.setData(data);
        } else if (!multipart.isEmpty()) {
            String boundary = "----ABCDEF";
            request.addHeader(String.format("Content-Type: multipart/form-data; boundary=%s", boundary));

            StringBuilder builder = new StringBuilder();
            for (String parts : multipart) {
                builder.append(String.format("--%s%s", boundary, newLine));
                builder.append(parts).append("\n");
            }
            builder.append(String.format("--%s--%s", boundary, newLine));

            request.setData(builder.toString());
        }

        if (verbose) {
            String[] lines = request.getLines();
            for (String line : lines) {
                System.out.println("> " + line);
            }
        }

        socketOut.write(request.toString().getBytes());
        socketOut.flush();
    }

    public void apply() {
        try (Socket socket = new Socket(getHost(), getPort());
                BufferedInputStream socketIn = new BufferedInputStream(socket.getInputStream());
                BufferedOutputStream socketOut = new BufferedOutputStream(socket.getOutputStream())) {

            while (true) {
                sendRequest(socketOut);
                Response response = receiveResponse(socketIn);
                if (response.getStatus() / 100 != 3) {
                    if (response.getStatus() / 100 == 2) {
                        System.out.println(response.getBody());
                    }
                    break;
                }

                if (!response.hasHeader("location")) {
                    break;
                }

                setPath(response.getHeader("location"));
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        SimpleCurl scurl = new SimpleCurl();
        Options options = new Options();

        try {
            options.addOption(Option.builder("v")
                    .desc("verbose, 요청, 응답 헤더를 출력한다.").build());
            options.addOption(Option.builder("H").hasArg().argName("line")
                    .desc("임의의 헤더를 서버로 전송한다.").build());
            options.addOption(Option.builder("d").hasArg().argName("data")
                    .desc("POST, PUT 등에 데이터를 전송한다.").build());
            options.addOption(Option.builder("X").hasArg().argName("command")
                    .desc("사용할 method를 지정한다. 지정되지 않은 경우, 기본값은 GET").build());
            options.addOption(Option.builder("L")
                    .desc("서버의 응답이 30x 계열이면 다음 응답을 따라 간다.").build());
            options.addOption(Option.builder("F").hasArg().argName("name=content")
                    .desc("multipart/form-data를 구성하여 전송한다. content 부분에 @filename을 사용할 수 있다.").build());
            options.addOption("h", false, "사용법을 출력한다.");

            CommandLineParser parser = new DefaultParser();
            CommandLine commandLine = parser.parse(options, args);
            if (commandLine.hasOption("h")) {
                throw new HelpException();
            }

            if (commandLine.hasOption("v")) {
                scurl.setVerbose(commandLine.hasOption("v"));
            }

            if (commandLine.hasOption("X")) {
                scurl.setMethod(commandLine.getOptionValue("X"));
            }

            if (commandLine.hasOption("H")) {
                for (String header : commandLine.getOptionValues("H")) {
                    scurl.addHeader(header);
                }
            }

            if (commandLine.hasOption("d")) {
                scurl.setData(commandLine.getOptionValue("d"));
            }

            if (commandLine.hasOption("F")) {
                String[] fields = commandLine.getOptionValue("F").split("=");

                scurl.addMultipart(fields[0], fields[1]);
                scurl.setMethod("POST");
            }

            if (commandLine.getArgs().length != 1) {
                throw new ParseException("하나의 URL만 처리가능 합니다.");
            }

            scurl.setUrl(commandLine.getArgs()[0]);

            scurl.apply();

        } catch (InvalidMethodException e) {
            System.err.println(e.getMessage());
        } catch (InvalidURLException e) {
            System.err.println("<scheme>://host[:<port>][<path>][?<query>]");
        } catch (ParseException | HelpException ignore) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.setOptionComparator(null);
            formatter.printHelp("scurl [Options] URL", options);
        }
    }
}
