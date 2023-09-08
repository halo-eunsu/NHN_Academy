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
        
        InputStream inputStream = getMovieFileAsStream();
        
        BufferedReader movieList = new BufferedReader(new InputStreamReader(inputStream));

        String data = "";
        String [] sList;
        long movieId;
        String title;
        String genre;
        List<String> gns= new ArrayList<>();

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
                    String[] arr = genre.split("\\|");
                    for(int i = 0; i<arr.length; i++){
                        gns.add(arr[i]);
                    }
                    Movie movie = new Movie(movieId, title, new HashSet(gns));

                    movies.add(movie);
                    gns.clear();
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