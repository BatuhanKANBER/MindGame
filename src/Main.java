import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Card[][] cards = new Card[4][4];
        getCards(cards);

        int firstRow, firstColumn, secondRow, secondColumn;
        int score = 0;
        int count = 0;

        boolean end = false;
        do {
            do {
                System.out.print("İlk Harf Satır: ");
                firstRow = input.nextInt();
            }while (firstRow > 3);

            do {
                System.out.print("İlk Harf Sütun: ");
                firstColumn = input.nextInt();
            }while (firstColumn > 3);

            cards[firstRow][firstColumn].setGuess(true);
            gameBoard(cards);
            System.out.println("----------------");

            do {
                System.out.print("İkinci Harf Satır: ");
                secondRow = input.nextInt();
            }while (secondRow > 3);

            do {
                System.out.print("İkinci Harf Sütun: ");
                secondColumn = input.nextInt();
            }while (secondColumn > 3);

            cards[secondRow][secondColumn].setGuess(true);
            gameBoard(cards);
            System.out.println("----------------");

            if (cards[firstRow][firstColumn].getaChar() == cards[secondRow][secondColumn].getaChar()){
                cards[firstRow][firstColumn].setGuess(true);
                cards[secondRow][secondColumn].setGuess(true);
                gameBoard(cards);
                System.out.println("----------------");
                score+=5;
                count++;
            }else{
                cards[firstRow][firstColumn].setGuess(false);
                cards[secondRow][secondColumn].setGuess(false);
                gameBoard(cards);
                score-=3;
                System.out.println("----------------");
            }

            if (count == 8)
                end = true;
        }while (!end);

        gameBoard(cards);
        System.out.println("Tebrikler Başarıyla Tamamladınız.");
        System.out.println("Skorunuz: " + score);
    }
    public static void getCards(Card[][] cards){
        cards[0][0] = new Card('E');
        cards[0][1] = new Card('A');
        cards[0][2] = new Card('B');
        cards[0][3] = new Card('F');
        cards[1][0] = new Card('G');
        cards[1][1] = new Card('A');
        cards[1][2] = new Card('D');
        cards[1][3] = new Card('H');
        cards[2][0] = new Card('F');
        cards[2][1] = new Card('C');
        cards[2][2] = new Card('D');
        cards[2][3] = new Card('H');
        cards[3][0] = new Card('E');
        cards[3][1] = new Card('G');
        cards[3][2] = new Card('B');
        cards[3][3] = new Card('C');
    }
    public static void gameBoard(Card[][] cards){
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                if (cards[i][j].isGuess()){
                    System.out.print("|" + cards[i][j].getaChar() + "| ");
                }else {
                    System.out.print("|-| ");
                }
            }
            System.out.println("");
        }
    }
}