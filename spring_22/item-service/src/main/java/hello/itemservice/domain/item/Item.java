package hello.itemservice.domain.item;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter // @Data는 도메인에서는 에러의 위험이 있음
public class Item {
    private Long id;
    private String itemName;
    private Integer price; // 가격과 수량이 null일 수도 있다는 가정
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
