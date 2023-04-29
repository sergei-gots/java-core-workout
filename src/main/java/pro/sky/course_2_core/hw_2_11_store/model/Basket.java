package pro.sky.course_2_core.hw_2_11_store.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Component
@SessionScope
public class Basket {
    private final Store store;
    private final Map<Integer, BasketItem> items = new HashMap<>();

    public Basket(List<Integer> ids, Store store) {
        this.store = store;
        ids.forEach(id -> items.put(id, this.store.getItemForBasket(id)));
    }

    public Map<Integer, BasketItem> getItems() {
        return Map.copyOf(items);
    }

    public void addIds(List<Integer> ids) {
        ids.forEach(this::applyAdd);
    }

    private void applyAdd(Integer id) {
        if (items.containsKey(id)) {
            items.get(id).increaseCount();
        } else {
            items.put(id, store.getItemForBasket(id));
        }
    }

    public void remove(List<Integer> ids) {
        ids.forEach(this::applyRemove);
    }

    private void applyRemove(Integer id) {
        if (!items.containsKey(id)) {
            return;
        }
        if (items.get(id).decreaseCount() == 0) {
            items.remove(id);
        }
    }

}



