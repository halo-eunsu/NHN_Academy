package com.nhnacademy.app;

import java.io.IOException;
import java.util.List;
import org.apache.commons.csv.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ApacheCommonsCsvMovieParser implements MovieParser {

  private Object csvData;
@Override
  public List<Movie> parse(String fileName) throws IOException {

    return null;
  }


    CSVParser parser = CSVParser.parse(csvData, CSVFormat.EXCEL);
    for (CSVRecord csvRecord : parser) {
        ...
    }
    @Override

    
    public InputStream getMovieFileAsStream() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMovieFileAsStream'");
    }


}
