package pro.sky.playground;

public class This {
    This() {
        System.out.println("The most primitive constructor of This is called.");
    }

    This(int i) {
        this();
        System.out.println("The constructor \"This(int i)\" with i = " + i  + " is called.");
    }
    This(String greetedPerson) {
        this(1);
        System.out.println("This is being constructed. Hello, " + greetedPerson);
    }

    public static void main(String[] args) {
        This thisOne = new This("Sergei");
    }
}
