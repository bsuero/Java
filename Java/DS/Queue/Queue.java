/**
 * Queue
 */
public class Queue {

    private int maxSize;            //initializes the set number of slots
    private long[] queueArray;      //slots to main the data
    private int front;              //pointing the index position for the element in the front of the line
    private int rear;               //going to be the index position for the element at the back of the line
    private int nItems;             //counter to maintain the number of items in our queue

    public Queue(int size) {
        this.maxSize = size;
        this.queueArray = new long[size];
        front = 0;                              //index position of the first slot
        rear = -1;                              //there is not item in the array yet.
        nItems = 0;                             //dont have element in the array yet
    }

    public void insert(long j) {

        if(rear == maxSize - 1) {
            rear = -1;
        }

        rear++;
        queueArray[rear] = j;
        nItems++;
    }

    public void view() {
        System.out.print("[ ");
        for(int i = 0; i < queueArray.length; i++) {
            System.out.print(queueArray[i] + " ");
        }
        System.out.print(" ]");
    }

    public long remove() {                                  //remove item from the front of the queue
        long temp = queueArray[front];
        front++;
        if(front == maxSize) {                  
            front = 0;
        }
        nItems--;
        return temp;

    }

    public long peekFront() {
        return queueArray[front];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean iSFull() {
        return (nItems == maxSize);
    }

}