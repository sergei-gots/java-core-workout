package pro.sky.java.course_2_core.hw_2_11_store.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course_2_core.hw_2_11_store.model.Item;
import pro.sky.java.course_2_core.hw_2_11_store.service.StoreService;

import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("/order")
public class StoreController {

    private final StoreService service;

    public StoreController(StoreService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public void add(@RequestParam List<Integer> ids) {
        System.out.println("ids = " + ids);
        service.add(ids);
    }

    @GetMapping("/get")
    public List<Item> get() {
        return service.get();
    }

}
