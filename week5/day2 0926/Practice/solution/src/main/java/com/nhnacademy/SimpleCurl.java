package com.nhnacademy;

import java.net.Socket;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class SimpleCurl {
    Options options;


    public SimpleCurl() {
        options = new Options();


        options.addOption("v", false, "verbose, 요청, 응답 헤더를 출력한다.");
        options.addOption(
                Option.builder("H").hasArg().argName("line").desc("임의의 헤더를 서버로 설정한다. ").build());
        options.addOption(Option.builder("d").hasArg().argName("dara")
                .desc("POST, UT 등에 데이터를 전송한다.").build());
        options.addOption(Option.builder("X").hasArg().argName("command")
                .desc("사용할 method를 지정ㅎ나다. 지정되지 않은 경우, 기본값은 GET").build());
        options.addOption(Option.builder(("L")).desc("서버의 응답이 30x 계열이면 다음 응답을 따라 간다. ").build());
        options.addOption(Option.builder("F").hasArgs().argName("name=content").valueSeparator('=')
                .desc(" multipart/form-data를 구성하여 전송한다. content 부분에 @filename을 사용할 수 있다.").build());
        options.addOption("h",false,"사용법을 출력한다.");
    }

    public CommandLine setOption(String[] args) throws ParseException {
        CommandLineParser parser = new DefaultParser();
        return parser.parse(options, args);
    }

    public void showHelp() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.setOptionComparator(null);
        formatter.printHelp("scurl", options);
    }

    public void run(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s %s %s", method, url, version));

        Socket socket = new Socket(host, port);
        socket.getOutputStream().write(....);

    }

    public static void main(String[] args) {
        SimpleCurl scurl = new SimpleCurl();

        try {
            CommandLine commandLine = scurl.setOption(args);

            if (commandLine.hasOption("h")) {
                scurl.showHelp();
            }

        } catch (Exception e) {
            scurl.showHelp();
        }

    }

}


