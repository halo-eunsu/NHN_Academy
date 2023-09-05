package main;

import java.util.ArrayList;
import java.util.List;

public class Library {

    int total = 1;
    int count = 1;
    List<String> BookList;

    public Library(int total)
    {
        
        this.total = total;
        BookList = new ArrayList<>(total);
    }

    public void add(String string) {

        BookList.add(string);
        this.count += 1;

    }

    // public boolean find(String string) {
        
    //     for(int i = 0; i<3 ; i++)
    //     BookList.add(string);
    //     this.count += 1;

    // }

    public boolean find(String string) {
        
        for(int i = 0; i<3 ; i++)
        {
            if(BookList.get(i).equals(string))
            return true;
         }

        return false;
    }

    public void delete(String string) {
        
        for(int i = 0; i<3 ; i++)
        {
            if(BookList.get(i).equals(string))
                BookList.remove(i);
        }
    }

    public int getTotalBookCount() {
        
        return count;
        
    }
    
}
