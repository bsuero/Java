/**
 * Animal
 */
public class Animal {

    String name;
    int age;
    int pounds;
    String kind;
    
    public Animal(String name, int age, int pound, String kind) {
        this.name = name;
        this.age = age;
        this.pounds = pound;
        this.kind = kind;
    }

    public void eat() {
        System.out.println("Eating ...");
    }

    public void sleep() {
        System.out.println("Sleeping...");
    }

    public void info() {
        System.out.println("my name is " + name);
        System.out.println("I am a " + kind);
        System.out.println("I am " + age + " years old");
        System.out.println("I am " + pounds + "pounds");
        System.out.println("please adopt me");
    }
}