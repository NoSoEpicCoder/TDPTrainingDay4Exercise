import java.util.ArrayList;
import java.util.Stack;

//This project simulates the process of calculating a cubic equation using a reverse polish notation method,
//and implementing a stack to store our calculations
public class DataTypes {
    public static void main(String[] args) {

        Stack stack = populateStack("2x^3+3x^2+4x+5", 2);

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    public static Stack populateStack(String equation, int xValue) {
        Stack stack = new Stack();
        ArrayList<String> operators = new ArrayList<>();

        for (int i = 0; i < equation.length(); i++) {
            //If the character equals x replace with the value of x and add a multiply sign
            if (Character.toString(equation.charAt(i)).equals("x")) {
                stack.push(xValue);
                operators.add("*");
                //Adding the numbers to the stack
            } else if (Character.isDigit(equation.charAt(i))) {
                stack.push(equation.charAt(i));
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
                stack.push(equation.charAt(i));
            }
        }
        return stack;
    }

    public static ArrayList<String> orderOperators(ArrayList<String> operators) {
        ArrayList<String> sortedOperators = new ArrayList<>();

        if(operators.contains("^")) sortedOperators.add("^");
        if(operators.contains("*")) sortedOperators.add("*");
        if(operators.contains("/")) sortedOperators.add("/");
        if(operators.contains("+")) sortedOperators.add("+");
        if(operators.contains("-")) sortedOperators.add("-");

        return sortedOperators;
    }

    public static int calculate(Stack stack){
        int result = 0;
        ArrayList numArray = new ArrayList();
        Object temp = stack.pop();

        if(Character.isDigit((Character) temp)){
            numArray.add(temp);
        } else if(Character.toString((Character) stack.pop()).equals("^")){
            //Math.pow((int)numArray.get(numArray.lastIndexOf(numArray), ))
        }
        return result;
    }
}
