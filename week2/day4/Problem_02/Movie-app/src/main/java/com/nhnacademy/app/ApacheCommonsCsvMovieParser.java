package com.nhnacademy.app;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

        for (CSVRecord csvRecord : parser) {
            long movieId = Long.parseLong(csvRecord.get(0));
            String title = csvRecord.get(1);
            String[] genreArray = csvRecord.get(2).split("\\|");
            Set<String> genres = new HashSet<>();
            for (String genre : genreArray) {
                genres.add(genre);
            }

            Movie movie = new Movie(movieId, title, genres);
            movies.add(movie);
            
        }

        return movies;
    }

    public InputStream getMovieFileAsStream() {
        return getClass().getClassLoader().getResourceAsStream(MOVIE_FILE_NAME);
    }
}
