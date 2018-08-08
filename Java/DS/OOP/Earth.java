/**
 * Earth
 */
public class Earth {

    public static void main(String[] args) {
        
        Human joe = new Human("joe", 22, "brown", 76);
        Human maria = new Human("maria", 21, "green", 62);
        Human tom = new Human("tom", 30, "pato", 55);


        joe.speak();
        maria.eat();
    }
}