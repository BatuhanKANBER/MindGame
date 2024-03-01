public class Card {
    private char aChar;
    private boolean guess;

    public Card(char aChar){
        this.aChar = aChar;
    }

    public boolean isGuess() {
        return guess;
    }

    public char getaChar() {
        return aChar;
    }

    public void setaChar(char aChar) {
        this.aChar = aChar;
    }

    public void setGuess(boolean guess) {
        this.guess = guess;
    }
}
