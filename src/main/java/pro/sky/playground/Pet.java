package pro.sky.playground;

public abstract class Pet {
    private int age;
    private String name;

    protected Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "class=" + getClass() +
                "{package=" + getClass().getPackageName() +
                ", class=" + getClass().getSimpleName() +
                "}, age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public void print() {
        System.out.println(this);
    }
}

class Cat extends Pet {
    public Cat(String name, int age) {
        super(name, age);
    }

    //EVEN without @Override-annotation this method will be called
    // from the reference referred to this object as a Pet!:)
    public void print() {
        System.out.println("Cat " + super.toString());
    }
}
