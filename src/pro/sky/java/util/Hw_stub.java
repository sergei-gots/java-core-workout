package pro.sky.java.util;
import pro.sky.java.util.Homework;

public class Hw_stub implements Homework {
    public static void main(String[] args)  {
        Homework hw = new Hw_stub();
        hw.homework();
    }

    @Override
    public void homework() {
        System.out.println("Homework <N.M> \"<Title>\"");



        System.out.println();
    }

}
