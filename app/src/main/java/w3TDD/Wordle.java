package w3TDD;

import java.util.Arrays;
import java.util.function.BooleanSupplier;

enum ColorCode {
    NonExisting, WrongPlace, CorrectPlace
};

public class Wordle {

    public Boolean allowed(String guess, String[] allowedWords) {
        return Arrays.stream(allowedWords).anyMatch(guess::equals) ;
    }

    public ColorCode[] check(String guess, String word) {

        ColorCode[] result = new ColorCode [5] ;

        for (int index=word.length()-1; index>=0; index--){
            result[index] = ColorCode.NonExisting;
            if (word.contains(""+guess.charAt(index))) 
                if (word.charAt(index) == guess.charAt(index)) result [index] = ColorCode.CorrectPlace;
                else result[index] = ColorCode.WrongPlace; 
        }

        return result;
    }

    public void main(String[] args)  {

        ColorCode [] code = check ("orhan", "makas") ;

        int i = 5 ; 

        while (i-->0) {

            System.out.println(code[i]);
        }



    }

    public Boolean checkWinner(String guess, String word) {
        return guess == word;
    }

}
