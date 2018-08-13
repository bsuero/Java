
public class Counter {
        
    private int count = 0;
    private String nameOfTheInstance = null;

    public Counter(String str) {
        this.nameOfTheInstance = str;
    }

    public void increment() {
        count++;
    }

    public int getCurrentValue() {
        return count;
    }

    public String toString() {
        return nameOfTheInstance + " : " + count;
    }
}