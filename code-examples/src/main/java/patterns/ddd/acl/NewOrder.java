package patterns.ddd.acl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewOrder {
    private int orderId;
    private String firstName;
    private String lastName;
    private String itemName;
    private String vendorName;
}
