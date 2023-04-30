package pro.sky.course_2_core.hw_2_11_store.model;

import org.jetbrains.annotations.NotNull;

public class BasketItem extends Item implements Comparable {
    private int count;


    public BasketItem(Item item) {
        super(item.getId(), item.getTitle());
        count = 1;
    }

    public int getCount() {
        return count;
    }

    public void increaseCount() {
        ++count;
    }

    public int decreaseCount() {
        return --count;
    }

    @Override
    public int compareTo(@NotNull Object o) {

        int myId = getId();
        int theirId = ((BasketItem) o).getId();
        if (myId > theirId) {
            return 1;
        } else if (myId < theirId){
            return -1;
        }
        return 0;
    }
}
