package pro.sky.course_2_core.hw_2_11_store.model;

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

    public BasketItem getItemForBasket(int id) {
        if(!items.containsKey(id)) {
            throw new IllegalArgumentException("The product with the id=" + id
                    + " is not listed in the store catalog.");
        }
        return new BasketItem(items.get(id));
    }
}
