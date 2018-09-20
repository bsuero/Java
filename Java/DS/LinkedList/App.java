/**
 * App
 */
public class App {

    public static void main(String[] args) {
        
        Node nodeA = new Node();
        nodeA.data = 4;

        Node nodeB = new Node();
        nodeB.data = 3;

        Node nodeC = new Node();
        nodeC.data = 6;

        Node nodeD = new Node();
        nodeB.data = 7;

        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;

        System.out.println(listLength(nodeB));
    }

    public static int listLength(Node anode) {
        int numberOfNodes = 0;
        Node currentNode = anode;

        while(currentNode != null) {
            numberOfNodes++;
            currentNode = currentNode.next;
        }

        return numberOfNodes;
    }
}