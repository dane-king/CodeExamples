package patterns.ddd.acl;

import patterns.ddd.acl.legacy.OrderService;

import java.util.List;
import java.util.stream.Collectors;

public class AntiCorruptionService {
    private OrderService orderService;

    public AntiCorruptionService(OrderService orderService) {
        this.orderService = orderService;
    }

    public List<NewOrder> displayOrders(){
        return orderService.getOrders().stream().map(OrderAdapter::translate).collect(Collectors.toList());
    }
}
