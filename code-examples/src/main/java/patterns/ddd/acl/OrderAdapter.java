package patterns.ddd.acl;

import patterns.ddd.acl.legacy.LegacyFacade;
import patterns.ddd.acl.legacy.LegacyOrder;

import java.util.Optional;
import java.util.function.Function;

public class OrderAdapter{
    public static NewOrder translate(LegacyFacade legacyFacade){
        var nullOrder = new NewOrder();
        return Optional.ofNullable(legacyFacade)
                .map(translateLegacyOrder(legacyFacade, nullOrder))
                .orElse(nullOrder);
    }

    private static Function<LegacyOrder, NewOrder> translateLegacyOrder(LegacyOrder legacyOrder, NewOrder nullOrder) {
        return o -> {
            String[] itemVendor = legacyOrder.getName().split(":");
            return (itemVendor.length != 2)
                    ? nullOrder
                    : new NewOrder(legacyOrder.getOrderId(), itemVendor[0], itemVendor[1]);
        };
    }
}
