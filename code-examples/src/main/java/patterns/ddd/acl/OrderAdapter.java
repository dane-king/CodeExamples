package patterns.ddd.acl;

import patterns.ddd.acl.legacy.LegacyOrder;

import java.util.Optional;

public class OrderAdapter{

    public static NewOrder translate(LegacyOrder legacyOrder) {
            String[] itemVendor = legacyOrder.getName().split(":");
            return (itemVendor.length != 2)
                    ? new NewOrder.NewOrderBuilder().build()
                    : new NewOrder.NewOrderBuilder()
                    .orderId(legacyOrder.getOrderId())
                    .firstName("")
                    .lastName("")
                    .itemName(itemVendor[0])
                    .vendorName(itemVendor[1])
                    .build();
    }
}
