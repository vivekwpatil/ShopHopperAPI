package be.ing.api.provider;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "Receipt")
public class ReceiptEntity {

    @Id
    @Column(name = "receipt_id")
    private int receiptId;

    @Column(name = "receipt_user_id")
    private String receiptUserId;

    @Column(name = "shop_id")
    private int shopId;

    @Column(name = "receipt_date")
    private Date receiptDate;

    @Column(name = "receipt_total_amount")
    private int receiptTotalAmount;

    @Column(name = "receipt_total_VAT")
    private int receiptTotalVAT;

    @Column(name = "receipt_total_discount")
    private int receiptTotalDiscount;

    @Column(name = "receipt_payment_information")
    private String receiptPaymentInformation;

    @OneToMany(mappedBy="receipt")
    @JsonManagedReference
    private List<ItemEntity> items;

    @OneToOne(mappedBy="receipt")
    @JsonManagedReference
    private ShopEntity shopEntity;


    public List<ItemEntity> getItems() {
        return items;
    }

    public void setItems(List<ItemEntity> items) {
        this.items = items;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    public void setReceiptUserId(String receiptUserId) {
        this.receiptUserId = receiptUserId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public void setReceiptTotalAmount(int receiptTotalAmount) {
        this.receiptTotalAmount = receiptTotalAmount;
    }

    public void setReceiptTotalVAT(int receiptTotalVAT) {
        this.receiptTotalVAT = receiptTotalVAT;
    }

    public void setReceiptTotalDiscount(int receiptTotalDiscount) {
        this.receiptTotalDiscount = receiptTotalDiscount;
    }

    public void setReceiptPaymentInformation(String receiptPaymentInformation) {
        this.receiptPaymentInformation = receiptPaymentInformation;
    }

    public int getReceiptId() {
        return receiptId;
    }

    public String getReceiptUserId() {
        return receiptUserId;
    }

    public int getShopId() {
        return shopId;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public int getReceiptTotalAmount() {
        return receiptTotalAmount;
    }

    public int getReceiptTotalVAT() {
        return receiptTotalVAT;
    }

    public int getReceiptTotalDiscount() {
        return receiptTotalDiscount;
    }

    public String getReceiptPaymentInformation() {
        return receiptPaymentInformation;
    }

    public ShopEntity getShopEntity() {
        return shopEntity;
    }

    public void setShopEntity(ShopEntity shopEntity) {
        this.shopEntity = shopEntity;
    }
}
