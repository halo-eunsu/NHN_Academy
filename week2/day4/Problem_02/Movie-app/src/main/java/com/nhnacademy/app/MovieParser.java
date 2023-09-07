package com.nhnacademy.app;

import java.io.IOException;
import java.util.List;

public interface MovieParser {
  
  String MOVIE_FILE_NAME= "movies.csv";
  List<Movie> parse(String fileName) throws IOException;

  default InputStream getMovieFileAsStream(){
    return getClass().getClassLoader().getResourceAsStream(MOVIE_FILE_NAME);
  }
}