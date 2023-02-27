package patterns.ddd.acl.legacy;


import lombok.Data;

@Data
public class LegacyOrder {
    private int orderId;

    //contains Name of Item + : + Vendor
    private String name;

}
