package page.janardhan.springandspanner;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import org.springframework.cloud.gcp.data.spanner.core.mapping.*;

@Table(name="orders")
@Data
public class Order {
    @PrimaryKey
    @Column(name="order_id")
    private String id;

    private String description;

    @Column(name="creation_timestamp")
    private LocalDateTime timestamp;

    // to create one to many relationship with order items
    @Interleaved
    private List<OrderItem> items;

}
