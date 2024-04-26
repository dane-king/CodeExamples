package patterns.ddd.acl.legacy;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class LegacyOrder {

    @Builder.Default
    private int orderId = -1;

    //contains Name of Item + : + Vendor
    private String name;

}
