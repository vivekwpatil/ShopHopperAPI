package be.ing.api.provider;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "item")
public class ItemEntity {

    @Id
    @Column(name = "item_id")
    private int itemId;

    @Column(name = "receipt_id")
    private int receiptId;

    @Column(name = "item_number")
    private int itemNumber;

    @Column(name = "item_unit_count")
    private int itemUnitCount;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_price")
    private int itemPrice;

    @Column(name = "item_unit_price")
    private int itemUnitPrice;

    @Column(name = "item_category")
    private String itemCategory;

    @Column(name = "item_discount")
    private int itemDiscount;

    @Column(name = "item_waranty_end_date")
    private Date itemWarantyEndDate;

    @Column(name = "item_type_code")
    private int itemTypeCode;
}
