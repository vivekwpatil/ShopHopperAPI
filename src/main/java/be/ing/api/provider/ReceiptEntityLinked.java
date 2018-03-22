package be.ing.api.provider;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "receipt")
public class ReceiptEntityLinked {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "receipt_id")
    private int receiptId;

    @Column(name = "receipt_user_id")
    private String receiptUserId;

    @Column(name = "receipt_date")
    private Date receiptDate = new Date();

    @Column(name = "shop_id")
    private int shopId;

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
    private List<ItemEntityLinked> items;

    ReceiptEntityLinked(){

    }

    ReceiptEntityLinked(ReceiptEntityLinked receiptEntity){
        /*this.receiptDate = receiptEntity.getReceiptDate();
        this.receiptPaymentInformation = receiptEntity.getReceiptPaymentInformation();
        this.receiptShopId = receiptEntity.getReceiptShopId();
        this.receiptTotalAmount = receiptEntity.receiptTotalAmount;
        this.receiptTotalDiscount = receiptEntity.receiptTotalDiscount;
        this.receiptTotalVAT = receiptEntity.receiptTotalVAT;
        this.receiptUserId = receiptEntity.receiptUserId;
        this.items = receiptEntity.getItems();*/
    }

    public List<ItemEntityLinked> getItems() {
        return items;
    }

    public void setItems(List<ItemEntityLinked> items) {
        this.items = items;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    public void setReceiptUserId(String receiptUserId) {
        this.receiptUserId = receiptUserId;
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

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }
}
