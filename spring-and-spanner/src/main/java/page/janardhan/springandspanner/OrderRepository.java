package page.janardhan.labs;

import org.springframework.cloud.gcp.data.spanner.repository.*;
import org.springframework.stereotype.*;

// This interface extends <code>SpannerRepository<Order, String></code>
// where <code>Order</code> is the domain class and <code>String</code>
// is the Primary key type. Spring Data will automatically provide CRUD
// access through this interface.

@Repository
public interface OrderRepository extends SpannerRepository<Order, String> {
    
}
