package pro.sky.java.course_2_core.hw_2_11_store.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course_2_core.hw_2_11_store.model.Basket;

@Service
public class StoreService {
    private final Basket basket;

    public StoreService(Basket basket) {
        this.basket = basket;
    }


}
