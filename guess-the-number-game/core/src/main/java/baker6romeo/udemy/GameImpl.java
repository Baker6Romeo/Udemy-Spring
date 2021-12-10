package baker6romeo.udemy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameImpl implements Game{

    //constants
    private static Logger log = LoggerFactory.getLogger(GameImpl.class);

    // fields
    private NumberGenerator numberGenerator;
    private int guessCount;
    private int number;
    private int guess;
    private int smallest;
    private int largest;
    private int remainingGuesses;
    private boolean validNumberRange;

    // == Constructor ==
    public GameImpl(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    // == public methods ==
    @Override
    public void reset() {
        smallest = 0;
        guess = 0;
        remainingGuesses = guessCount;
        largest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        log.info("The number is {}", number);
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getGuess() {
        return guess;
    }

    @Override
    public void setGuess(int guess) {
        this.guess = guess;
    }

    @Override
    public int getSmallest() {
        return smallest;
    }

    @Override
    public int getLargest() {
        return largest;
    }

    @Override
    public int getRemainingGuesses() {
        return remainingGuesses;
    }

    @Override
    public void check() {
        if (validNumberRange){
            if (guess > number){
                largest = guess - 1;
            }
            if (guess < number){
                smallest = guess + 1;
            }
        }
        remainingGuesses--;
    }

    @Override
    public boolean isValidNumberRange() {
        return validNumberRange;
    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return isGameWon() && remainingGuesses <= 0;
    }

    //private methods
    private void checkValidNumberRange(){
        validNumberRange = (guess >= smallest) && (guess <= largest);
    }
}
