package pro.sky.java.course_2_core.hw_2_11_store.model;

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
        items.put(idGenerator, new Item(idGenerator++, "Ipad"));

    }

    public Collection<Item> get() {
        return items.values();
    }

    public void update(Item item) {
        if(items.containsKey(item.getId())){
                items.put(item.getId(), item);
        }
    }
}
