package main;



public class Library {

    int total = 1;
    int count = 1;
    String[] List;

    public Library(int total)
    {
        
        this.total = total;
        List = new String[total];
    }

    public void add(String string) {

        List[count-1] = string;
        this.count += 1;

    }

    public boolean find(String string) {
        
        for(int i = 0; i<total ; i++)
        {
            if(List[i].equals(string))
                return true;
        }

        return false;
    }

    public void delete(String string) {
        
        for(int i = 0; i<total ; i++)
        {
            if(List[i].equals(string))
                List[i] = "";
        }
    }

    public int getTotalBookCount() {
        
        return count;
        
    }
    
}
