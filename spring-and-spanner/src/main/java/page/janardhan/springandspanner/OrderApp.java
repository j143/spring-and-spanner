package page.janardhan.springandspanner;

import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@SpringBootApplication
public class OrderApp {
    public static void main(String[] args) {
        SpringApplication.run(OrderApp.class, args);
    }
}

@RestController
class OrderController {
    private final OrderRepository orderRepository;

    OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/api/orders/{id}")
    public Order getOrder(@PathVariable String id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, id + " not found"));

    }

    @PostMapping("/api/orders")
    public String createOrder(@RequestBody Order order) {
        // Spanner does not auto Generate IDs
        // Let's use UUID on new orders
        order.setId(UUID.randomUUID().toString());
        order.setTimestamp(LocalDateTime.now());
        
        return "1";
    }

    
}


