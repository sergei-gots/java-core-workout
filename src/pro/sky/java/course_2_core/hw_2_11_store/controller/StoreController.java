package pro.sky.java.course_2_core.hw_2_11_store.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class StoreController {
    @GetMapping("/add")
    public void add(List<Integer> ids) {

    }

    @GetMapping("/get")
    public List<Integer> get() {
        return null;
    }

}
