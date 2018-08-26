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
    }
}