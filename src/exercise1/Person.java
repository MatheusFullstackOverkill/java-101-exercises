package exercise1;

public class Person {
    public String name;
    public double height;
    public Sex sex;

    public Person(String name, double height, Sex sex) {
        this.name = name;
        this.height = height;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return name + ", height: " + height + "m";
    }
}
