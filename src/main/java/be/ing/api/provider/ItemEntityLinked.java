package be.ing.api.provider;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "item")
public class ItemEntityLinked {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int itemId;

    @ManyToOne
    @JoinColumn(name="receipt_id", nullable = false)
    @JsonBackReference
    private ReceiptEntityLinked receipt;

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
    private String itemTypeCode;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public ReceiptEntityLinked getReceipt() {
        return receipt;
    }

    public void setReceipt(ReceiptEntityLinked receipt) {
        this.receipt = receipt;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public int getItemUnitCount() {
        return itemUnitCount;
    }

    public void setItemUnitCount(int itemUnitCount) {
        this.itemUnitCount = itemUnitCount;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemUnitPrice() {
        return itemUnitPrice;
    }

    public void setItemUnitPrice(int itemUnitPrice) {
        this.itemUnitPrice = itemUnitPrice;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public int getItemDiscount() {
        return itemDiscount;
    }

    public void setItemDiscount(int itemDiscount) {
        this.itemDiscount = itemDiscount;
    }

    public Date getItemWarantyEndDate() {
        return itemWarantyEndDate;
    }

    public void setItemWarantyEndDate(Date itemWarantyEndDate) {
        this.itemWarantyEndDate = itemWarantyEndDate;
    }

    public String getItemTypeCode() {
        return itemTypeCode;
    }

    public void setItemTypeCode(String itemTypeCode) {
        this.itemTypeCode = itemTypeCode;
    }
}
