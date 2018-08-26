public class App {

    public static void main(String[] args) {
        
        Stack theStack = new Stack(10);
        theStack.push(20);
        theStack.push(400);
        theStack.push(230);
        theStack.push(203);

        while(!theStack.isEmpty()) {

            long value = theStack.pop();
            System.out.println(value);
            
        }
        System.out.println(reverseString("lifo"));

    }

    public static String reverseString(String str) {
        int stackSize = str.length();                           // get the max stack size

        StackChar theStack = new StackChar(stackSize);

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);                    //getting a char for the input string
            theStack.push(ch);
        }

        String result = "";
        while(!theStack.isEmpty()) {
            char ch = theStack.pop();
            result = result + ch;
        }
        return result;
    }
}