package pro.sky.java.course_2_core.hw_2_11_store.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class Store {
    private final Map<Integer, Item> items;
    private int idGenerator = 1;


    public Store() {
        this.items = new HashMap<>();
        items.put(idGenerator, new Item(idGenerator++, "Book"));
        items.put(idGenerator, new Item(idGenerator++, "Laptop"));
        items.put(idGenerator, new Item(idGenerator++, "Tablet"));

    }

    public Collection<Item> get() {
        return items.values();
    }

    public void add(Item item) {
        items.put(item.getId(), item);
    }
    public void update(Item item) {
        items.replace(item.getId(), item);
    }

    public Item remove(int id) {
        return items.remove(id);
    }
}
