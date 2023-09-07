package com.nhnacademy.app;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BasicMovieParser implements MovieParser {

  @Override
  public List<Movie> parse(String fileName) throws IOException {
    return null;
  }


  public InputStream getMovieFileAsStream(){
    return getClass().getClassLoader().getResourceAsStream(MOVIE_FILE_NAME);  
  }
  

}