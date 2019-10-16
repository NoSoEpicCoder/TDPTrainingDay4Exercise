import java.util.ArrayList;
import java.util.Stack;

//This project simulates the process of calculating a cubic equation using a reverse polish notation method,
//and implementing a stack to store our calculations
public class DataTypes {
    public static void main(String[] args) {
        Stack<String> stack = populateStack("2x^3+3x^2+4x+5", 2);
        System.out.println(stack);
        calculate(stack);
    }

    public static Stack<String> populateStack(String equation, int xValue) {
        Stack<String> stack = new Stack<>();
        ArrayList<String> operators = new ArrayList<>();

        for (int i = 0; i < equation.length(); i++) {
            //If the character equals x replace with the value of x and add a multiply sign
            if (Character.toString(equation.charAt(i)).equals("x")) {
                stack.push(xValue + "");
                operators.add("*");
                //Adding the numbers to the stack
            } else if (Character.isDigit(equation.charAt(i))) {
                stack.push(equation.charAt(i) + "");
                //If character equals power, divide or multiply add it to the operators array
            } else if (Character.toString(equation.charAt(i)).equals("^") || Character.toString(equation.charAt(i)).equals("/") || Character.toString(equation.charAt(i)).equals("*")) {
                operators.add(Character.toString(equation.charAt(i)));
                //If character is adding or subtracting add the operators first and then add the sign
            } else if (Character.toString(equation.charAt(i)).matches("[+\\-]")) {
                operators = orderOperators(operators);
                for (int j = 0; j < operators.size(); j++) {
                    stack.push(operators.get(j));
                }
                operators.clear();
                operators.add(Character.toString(equation.charAt(i)));
            }
        }
        //Making sure we have all the operators added to the stack
        for (String operator : operators) {
            if (operator != null) {
                stack.push(operator);
            }
        }
        return stack;
    }

    public static ArrayList<String> orderOperators(ArrayList<String> operators) {
        ArrayList<String> sortedOperators = new ArrayList<>();

        if (operators.contains("^")) sortedOperators.add("^");
        if (operators.contains("*")) sortedOperators.add("*");
        if (operators.contains("/")) sortedOperators.add("/");
        if (operators.contains("+")) sortedOperators.add("+");
        if (operators.contains("-")) sortedOperators.add("-");

        return sortedOperators;
    }

    public static Stack<String> calculate(Stack<String> stack) {
        Stack<String> equationStack = new Stack<>();
        Stack<String> reversedStack = new Stack<>();

        while (!stack.isEmpty()) {
            reversedStack.push(stack.pop());
        }

        while (!reversedStack.isEmpty()) {
            if (reversedStack.peek().equals("^")) {
                reversedStack.pop();
                double base = Integer.parseInt(equationStack.pop() + "");
                double power = Integer.parseInt(equationStack.pop() + "");
                equationStack.push((int)Math.pow(power, base) + "");
            } else if (reversedStack.peek().equals("*")) {
                reversedStack.pop();
                equationStack.push(Integer.parseInt(equationStack.pop()) * Integer.parseInt(equationStack.pop()) + "");
            } else if (reversedStack.peek().equals("/")) {
                reversedStack.pop();
                equationStack.push(Integer.parseInt(equationStack.pop()) / Integer.parseInt(equationStack.pop()) + "");
            } else if (reversedStack.peek().equals("+")) {
                reversedStack.pop();
                equationStack.push(Integer.parseInt(equationStack.pop()) + Integer.parseInt(equationStack.pop()) + "");
            } else if (reversedStack.peek().equals("-")) {
                reversedStack.pop();
                equationStack.push(Integer.parseInt(equationStack.pop()) - Integer.parseInt(equationStack.pop()) + "");
            } else {
                equationStack.push(reversedStack.pop());
            }
            //Showing how the equations is being executed
            System.out.println(equationStack);
        }
        return equationStack;
    }
}
