package util;

import java.util.Stack;

public class ExpressionEvaluation {

    public static Double evaluate(String input){
        if(input.contains("=")){
            input = input.replace("=", "");
        }
        Stack<Double> values = new Stack<>();
        Stack<String> operators = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == ' ') {
                continue;
            }
            else if (input.charAt(i) == '(') {
                operators.push("(");
            }
            else if (i < input.length() && Character.isDigit(input.charAt(i))) {
                double value = 0;
                while (i < input.length() && Character.isDigit(input.charAt(i))){
                    value = (value * 10) + Integer.parseInt(String.valueOf(input.charAt(i)));
                    i++;
                }
                values.push(value);
                i--;
            }
            else if(input.charAt(i) == ')'){
                while (!operators.isEmpty() && !operators.peek().equals("(")){
                    getTopValues(values, operators);
                }
                if(!operators.isEmpty()){
                    operators.pop();
                }
            }
            else {
                while (!operators.isEmpty() && getPrecedence(operators.peek()) >= getPrecedence(input.charAt(i) +"")){
                    getTopValues(values, operators);
                }
                operators.push(String.valueOf(input.charAt(i)));
            }
        }
        while (!operators.isEmpty()){
            getTopValues(values, operators);
        }
        try {
            return values.peek();
        } catch (RuntimeException exception) {
            return 0.0;
        }
    }

    private static void getTopValues(Stack<Double> values, Stack<String> operators) {
        Double val2 = values.peek();
        values.pop();
        Double val1 = values.peek();
        values.pop();
        String op = operators.peek();
        operators.pop();
        values.push(applyOperand(val1,val2, op));
    }

    private static int getPrecedence(String operator){
        if(operator.equals("+") || operator.equals("-"))
            return 1;
        if(operator.equals("*") || operator.equals("/"))
            return 2;
        return 0;
    }

    private static double applyOperand(double firstOperand, double secondOperand, String operator){
        switch (operator){
            case "+": return firstOperand + secondOperand;
            case "-": return firstOperand - secondOperand;
            case "/": return firstOperand / secondOperand;
            case "*": return firstOperand * secondOperand;
            default: return 0;
        }
    }
}
