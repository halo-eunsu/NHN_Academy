package main;

public class DiceCalculator {

    public static double addDice(Dice first, Dice second) {
    
        return first.getNumber() + second.getNumber();
    }

    public static double mulDice(Dice first, Dice second) {
        
        return first.getNumber() * second.getNumber();
    }

    public static double divDice(Dice first, Dice second) {
       
        return first.getNumber() / second.getNumber();
    }

    public static double subDice(Dice first, Dice second) {
       
       return first.getNumber() - second.getNumber();
    }

    public static boolean isOdd(Dice dice) {
        if(dice.getNumber()%2 != 0)
            return true;
        
        return false;
    }

    public static boolean isEven(Dice dice) {
        if(dice.getNumber()%2 == 0)
            return true;
        
        return false;
    }
    
}
