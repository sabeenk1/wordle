import java.util.Arrays;
import java.util.Scanner;

public class wordle extends words
{

    public static void main(String[] args)
    {

        Scanner input= new Scanner(System.in);
        //intro
        System.out.println();
        System.out.println("Welcome to Wordle!");
        System.out.println();
        System.out.println("Rules:");
        System.out.println("• Enter a five letter word in LOWERCASE letters.");
        System.out.println("• The console will return the word with a few alterations:");
        System.out.println("✧ Capital letter = The letter is in the correct spot.");
        System.out.println("✧ Lowercase letter = The letter is in the incorrect spot.");
        System.out.println("✧ Hashtag = The letter is not in the word.");
        System.out.println("• You will have 6 attempts to guess the correct word. Have fun!");
        System.out.println();
        System.out.println("Enter your guess:");

        //pick random word from words list for player to guess
        int random= (int) (Math.random()*fiveLetterWords.length);
        String randomWord= fiveLetterWords[random];

        // 6-guess loop
        for(int i=1; i<=6; i++){
            String guess=input.nextLine();

            //guess invalid if not 5 letters
            boolean invalidGuess = guess.length()!=5;

            while(invalidGuess){
                if(guess.length()!=5) {
                    System.out.println("Please enter a word with 5 letters:");
                    guess = input.nextLine();
                }
                else{
                    invalidGuess = false;
                    break;
                }
            }

            //correct guess
            if(guess.equals(randomWord)){
                System.out.println();
                System.out.println("Great job! The word was " + guess + " :)");
                System.exit(0);
            }

            //incorrect guess
            else{
                String newStr= "     ";

                //compare letter-by-letter & return updated string
                for(int j=0; j<guess.length(); j++){
                    String letter= guess.substring(j, j+1);
                    String randomWordLetter= randomWord.substring(j, j+1);
                    if (randomWord.contains(letter)&& randomWordLetter.equals(letter)){
                        newStr+=letter.toUpperCase();
                    }
                    else if(randomWord.contains(letter)){
                        int count1=0;
                        int count2=0;
                        for(int q=0; q<randomWord.length(); q++){
                            if(randomWord.substring(q, q+1).equals(letter)){
                                if(!guess.substring(q, q + 1).equals(letter)){
                                    count1++;
                                }

                            }
                        }

                        for(int p=0; p<j; p++){
                            if(guess.substring(p,p+1).equals(letter)){
                                if(!randomWord.substring(p, p + 1).equals(letter)){
                                    count2++;
                                }

                            }
                        }

                        if(count2<count1){
                            newStr+=letter;
                        }

                        if(count2>=count1){
                            newStr+="#";
                        }

                    }
                    else{

                        newStr+="#";
                    }
                }
                System.out.println(newStr);
            }

            //guess limit reached
            if(i==6 && !guess.equals(randomWord)){
                System.out.println("Better luck next time! The correct word was " + randomWord);
            }

        }

    }

}
