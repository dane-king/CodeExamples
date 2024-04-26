package patterns.ddd.acl;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class NewOrder {
    @Builder.Default
    private int orderId = -1;
    private String firstName;
    private String lastName;
    private String itemName;
    private String vendorName;


}
