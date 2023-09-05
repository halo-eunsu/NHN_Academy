package test;

import main.Dice;
import main.DiceCalculator;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;

public class DIceJunitTest {

    private final String OUT_OF_RANGE_MESSAGE = "1 미만 6 초과 주사위는 생성할 수 없습니다. ";

    Dice first = new Dice(6);
    Dice second = new Dice(2);
        


    @Test
    @DisplayName("addDice 성공")
    void addDice(){

        assertEquals(DiceCalculator.addDice(first, second), 8);
    }
    
    @Test
    @DisplayName("addDice 성공")
    void subDice(){
        
        assertEquals(DiceCalculator.addDice(first, second), 4);
    }

    @Test
    @DisplayName("음수 값의 주사위를 생성할 수 없을 때, IllegalArgumentException을 던짐")
    void negativeDice_throwIllegalArgumentException(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Dice(-1));

        
        assertEquals(exception.getMessage(), OUT_OF_RANGE_MESSAGE);
    }

    @AfterAll

    void done() {
        System.out.println("done");
    }

}
