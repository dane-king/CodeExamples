package patterns.ddd.acl;

import java.util.List;
import java.util.stream.Collectors;

public class AntiCorruptionService {
    private OrderService facade;

    public AntiCorruptionService(OrderService facade) {
        this.facade = facade;
    }

    public List<NewOrder> displayOrders(){
        return facade.getOrders().stream().map(OrderAdapter::translate).collect(Collectors.toList());
    }
}
