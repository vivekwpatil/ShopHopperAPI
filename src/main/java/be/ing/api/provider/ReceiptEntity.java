package be.ing.api.provider;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "Receipt")
public class ReceiptEntity {

    @Id
    @Column(name = "receipt_id")
    private int receiptId;

    @Column(name = "receipt_user_id")
    private String receiptUserId;

    @Column(name = "receipt_shop_id")
    private int receiptShopId;

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

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    public void setReceiptUserId(String receiptUserId) {
        this.receiptUserId = receiptUserId;
    }

    public void setReceiptShopId(int receiptShopId) {
        this.receiptShopId = receiptShopId;
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
}
