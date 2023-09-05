package main;
public class Dice {

    int number;

    public Dice(int number){

        if(number < 1 || number > 6)
            throw new IllegalArgumentException("1 미만 6 초과 주사위는 생성할 수 없습니다. ");
        this.number = number;


    }



    public int getNumber() {
        return number;
    }
    


}
