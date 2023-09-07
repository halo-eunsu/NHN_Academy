package com.nhnacademy.app;

import java.util.HashSet;
import java.util.Set;

public class Movie {
  private final long movieId;
  private final String title;
  private final Set<String> genres = new HashSet<>();


public Movie(long movieId, String title, String genres)
  {
    
        this.movieId= movieId;
        this.title = title;
        this.genres.add(genres);
  }


    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", title='" + title + '\'' +
                ", genres=" + genres +
                '}';
    }

}