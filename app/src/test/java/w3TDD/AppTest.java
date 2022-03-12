/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package w3TDD;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

enum ColorCode {NonExisting, WrongPlace, CorrectPlace};

class AppTest {
    @Test
    void checkIfGuessAllowed() {

        Wordle classUnderTest = new Wordle();

        String guess = "orhan";
        String[] allowedWords = { "orhan", "osman", "araba", "makas" };

        assertTrue(classUnderTest.allowed(guess, allowedWords));

        guess = "orman";

        assertFalse(classUnderTest.allowed(guess, allowedWords));

    }

    boolean checkEnumarationArray (ColorCode [] x, ColorCode[] y){
        boolean result = true ;

        for (int i=x.length-1;i>=0;i--){
            result = result && (x[i] == y[i]) ;
        }

        return result;
    }

    @Test
    void evaluateTheGuess() {

        Wordle classUnderTest = new Wordle();


        String guess = "orhan";
        String word = "makas";

        ColorCode evaluatedGuess[] = { 
            ColorCode.NonExisting, 
            ColorCode.NonExisting, 
            ColorCode.NonExisting,
            ColorCode.CorrectPlace, 
            ColorCode.NonExisting };

        assertTrue( checkEnumarationArray(evaluatedGuess, classUnderTest.check(guess,word)));

    }

    @Test
    void checkIfWinner() {

        Wordle classUnderTest = new Wordle();

        String guess = "makas";
        String word = "makas";

        assertTrue(classUnderTest.checkWinner(guess, word));

         guess = "orhan";
         word = "makas";

        assertFalse(classUnderTest.checkWinner(guess, word));

    }




}

