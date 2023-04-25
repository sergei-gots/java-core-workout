package pro.sky.java.course_2_core.hw_2_11_store.model;

public class Item {
    private int id;
    private String title;

    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Item(int id, String title) {

        this.id = id;
        this.title = title;
    }
}
