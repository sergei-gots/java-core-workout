package pro.sky.java.course_2_core.hw_2_11_store.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@Component
@SessionScope
public class Basket {
    private List<Integer> ids;

    public Basket(List<Integer> ids) {
        this.ids = ids;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void add(List<Integer> ids) {
        this.ids.addAll(ids);
    }
}
