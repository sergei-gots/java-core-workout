package pro.sky.course_2_core.hw_2_11_store.service;

import org.springframework.stereotype.Service;
import pro.sky.course_2_core.hw_2_11_store.model.Basket;
import pro.sky.course_2_core.hw_2_11_store.model.BasketItem;
import pro.sky.course_2_core.hw_2_11_store.model.Store;

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
        basket.addIds(ids);
    }

    public List<BasketItem> get() {
        return basket.getItems().values().stream().sorted().collect(Collectors.toList());
    }


    public void remove(List<Integer> ids) {
        basket.remove(ids);
    }
}
