import java.util.Scanner;

import static util.ExpressionEvaluation.evaluate;

public class Calculator {

    public static void main(String[] args) {
        while (true){
            System.out.println("Input your mathematical expression, or exit the program by inserting '0'");
            Scanner expressionScanner = new Scanner(System.in);
            if(expressionScanner.hasNext()){
                String inputLine = expressionScanner.nextLine();
                if(inputLine.trim().equals("0")){
                    break;
                }
                System.out.println("Answer: " + evaluate(inputLine.trim()));
            }
        }
    }
}
