package com.nhnacademy.app;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ApacheCommonsCsvMovieParser implements MovieParser {

    @Override
    public List<Movie> parse(String fileName) throws IOException {
        InputStream inputStream = getMovieFileAsStream();

        // CSVParser를 생성하고 CSV 파일 파싱
        CSVParser parser = CSVParser.parse(new InputStreamReader(inputStream, "UTF-8"), CSVFormat.EXCEL);
        List<Movie> movies = new ArrayList<>();
       
        try {
            Reader in = new FileReader("file.csv");
            Iterable<CSVRecord> records = CSVFormat.EXCEL.builder().setHeader().build().parse(in);
            for (CSVRecord record : records) {
                String lastName = record.get("Last Name");
                String firstName = record.get("First Name");

                System.out.print(lastName + " ");
                System.out.println(firstName);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return movies;
    }

    public InputStream getMovieFileAsStream() {
        return getClass().getClassLoader().getResourceAsStream(MOVIE_FILE_NAME);
    }
}
