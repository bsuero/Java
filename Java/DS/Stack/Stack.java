public class Stack {

    //LIFO

    private int maxSize;                                //size of the stack
    private long[] stackArray;                          //container to store the list of items
    private int top;                                    //index of the last item

    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new long[maxSize];
        this.top = -1;
    }

    public void push(long j) {

        top++;
        stackArray[top] = j;
    }

    public long pop() {
        
        int old_top = top;
        top--;
        return stackArray[old_top];
    }

    public long peak() {

        return stackArray[top];
    }

    public boolean isEmpty() {

        return ( top == -1);
    }

    public boolean isFull() {
        
        return (maxSize-1 == top);
    }

    public static void main(String[] args) {
        
        

    }
}