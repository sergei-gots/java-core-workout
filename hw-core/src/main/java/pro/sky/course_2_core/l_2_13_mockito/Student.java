package pro.sky.course_2_core.l_2_13_mockito;

public class Student {
    enum Sex {
        MALE,
        FEMALE
    }
    private int id;
    private String name;
    private int age;
    private Sex sex;

    public Student(String name, Sex sex) {
        this.name = name;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
