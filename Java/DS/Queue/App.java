/**
 * App
 */
public class App {

    public static void main(String[] args) {
        Queue myQueue = new Queue(5);

        myQueue.insert(12);
        myQueue.insert(13);
        myQueue.insert(154);
        myQueue.insert(1);
        myQueue.insert(14);
        myQueue.insert(1555);
        myQueue.insert(1555);
        myQueue.insert(1555);
        myQueue.view();
    }
}