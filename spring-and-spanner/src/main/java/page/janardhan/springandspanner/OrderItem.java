package page.janardhan.springandspanner;

import lombok.Data;
import org.springframework.cloud.gcp.data.spanner.core.mapping.*;


@Table(name="order_items")
@Data
class OrderItem {
    @PrimaryKey(keyOrder = 1)
    @Column(name="order_id")
    private String orderId;

    // use composite primary keys
    // order_id, and order_item_id

    @PrimaryKey(keyOrder = 2)
    @Column(name="order_item_id")
    private String orderItemId;

    private String description;
    private Long quantity;
}