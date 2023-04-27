package pro.sky.java.course_2_core.hw_2_11_store.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course_2_core.hw_2_11_store.model.Basket;
import pro.sky.java.course_2_core.hw_2_11_store.model.Item;
import pro.sky.java.course_2_core.hw_2_11_store.model.Store;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreService {
    private final Basket basket;
    private final Store store;

    public StoreService(Basket basket, Store store) {
        this.basket = basket;
        this.store = store;
    }

    public void add(List<Integer> ids) {
        basket.add(ids);
    }

    public List<Item> get() {
        return store.get().stream()
                .filter(item -> basket.getIds().contains(item.getId()) )
                .collect(Collectors.toList());
    }


}
