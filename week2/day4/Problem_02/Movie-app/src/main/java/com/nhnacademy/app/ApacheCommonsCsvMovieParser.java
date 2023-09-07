package com.nhnacademy.app;

import java.io.IOException;
import java.util.List;

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


}
