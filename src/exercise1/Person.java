package exercise1;

public class Person {
    private String name;
    private double height;
    private Sex sex;

    public Person(String name, double height, Sex sex) {
        this.name = name;
        this.height = height;
        this.sex = sex;
    }

    // It's not good pratice to override java's methods,
    // it's better to override your own methods of the classes that you create
    // @Override
    // public String toString() {
    //     return name + ", height: " + height + "m";
    // }

    public String getNameAndHeight() {
        return name + ", height: " + height + "m";
    }

    public String getName() {
        return this.name;
    }

    public double getHeight() {
        return this.height;
    }

    public Sex getSex() {
        return this.sex;
    }
}
