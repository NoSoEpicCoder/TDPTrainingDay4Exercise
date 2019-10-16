import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataTypesTest {
    @org.junit.jupiter.api.Test
    void populateStack() {
        //Test equation 1
        Stack<String> stack1 = DataTypes.populateStack("2x^3+3x^2+4x+5", 2);
        Stack<String> stack1Expected = new Stack<>();
        stack1Expected.push("2");
        stack1Expected.push("2");
        stack1Expected.push("3");
        stack1Expected.push("^");
        stack1Expected.push("*");
        stack1Expected.push("3");
        stack1Expected.push("2");
        stack1Expected.push("2");
        stack1Expected.push("^");
        stack1Expected.push("*");
        stack1Expected.push("+");
        stack1Expected.push("4");
        stack1Expected.push("2");
        stack1Expected.push("*");
        stack1Expected.push("+");
        stack1Expected.push("5");
        stack1Expected.push("+");
        assertEquals(stack1Expected, stack1);

        //Test equation 2
        Stack<String> stack2 = DataTypes.populateStack("2x^3+4x+1", 3);
        Stack<String> stack2Expected = new Stack<>();
        stack2Expected.push("2");
        stack2Expected.push("3");
        stack2Expected.push("3");
        stack2Expected.push("^");
        stack2Expected.push("*");
        stack2Expected.push("4");
        stack2Expected.push("3");
        stack2Expected.push("*");
        stack2Expected.push("+");
        stack2Expected.push("1");
        stack2Expected.push("+");
        assertEquals(stack2Expected, stack2);

        //Test equation 3
        Stack<String> stack3 = DataTypes.populateStack("4x^3+x^2+4x+8", 5);
        Stack<String> stack3Expected = new Stack<>();
        stack3Expected.push("4");
        stack3Expected.push("5");
        stack3Expected.push("3");
        stack3Expected.push("^");
        stack3Expected.push("*");
        stack3Expected.push("5");
        stack3Expected.push("2");
        stack3Expected.push("^");
        stack3Expected.push("+");
        stack3Expected.push("4");
        stack3Expected.push("5");
        stack3Expected.push("*");
        stack3Expected.push("+");
        stack3Expected.push("8");
        stack3Expected.push("+");
        assertEquals(stack3Expected, stack3);
        //Failed because I am inserting a multiply sign after hitting a x variable
    }

    @org.junit.jupiter.api.Test
    void calculate() {
        //Test calculation 1
        Stack<String> stack1 = DataTypes.populateStack("2x^3+3x^2+4x+5", 2);
        Stack<String> stack1Expected = new Stack<>();
        stack1Expected.push("41");
        assertEquals(stack1Expected, DataTypes.calculate(stack1));

        //Test calculation 1
        Stack<String> stack2 = DataTypes.populateStack("2x^3+4x+1", 3);
        Stack<String> stack2Expected = new Stack<>();
        stack2Expected.push("67");
        assertEquals(stack2Expected, DataTypes.calculate(stack2));

        //Test calculation 1
        Stack<String> stack3 = DataTypes.populateStack("4x^3+x^2+4x+8", 5);
        Stack<String> stack3Expected = new Stack<>();
        stack3Expected.push("553");
        assertEquals(stack3Expected, DataTypes.calculate(stack3));
        //Failed because the stack isn't properly populated
    }
}