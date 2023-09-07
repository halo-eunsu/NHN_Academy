package com.nhnacademy.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class BasicMovieParser implements MovieParser {
    
    @Override
    public List<Movie> parse(String fileName) throws IOException {
        
        
        
        BufferedReader movieList = new BufferedReader(new FileReader("src/main/resources/movies.csv"));

        String data = "";
        String [] sList;
        long movieId;
        String title;
        String genre;

        List<Movie> movies = new ArrayList<>();
        try{
            while((data = movieList.readLine()) != null){
                
                if(data.equals("movieId,title,genres")){
                    }
                else{
                    sList = data.split(",");
                    movieId = Long.parseLong(sList[0]);
                    title = sList[1];
                    genre = sList[2];
                    Movie movie = new Movie(movieId, title, genre);

                    movies.add(movie);
                }
                }
            }
        
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return movies;
    }
    
    
    public InputStream getMovieFileAsStream(){
    return getClass().getClassLoader().getResourceAsStream(MOVIE_FILE_NAME);  
    }











  

}