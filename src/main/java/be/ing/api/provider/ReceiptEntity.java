package be.ing.api.provider;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

/*
@Entity
@Table(name = "Receipt")*/
public class ReceiptEntity {

    /*public ReceiptEntity(String merchant, String amount, String date, String itemDescription){
        this.merchant = merchant;
        this.amount = amount;
        this.date = date;
        this.itemDescription=itemDescription;

    }*/

    //@GeneratedValue(strategy = GenerationType.AUTO)
    private long receiptId;

    private String merchant;
    private String amount;
    private String date;
    private String itemDescription;

    public long getReceiptId() {
        return receiptId;
    }

    public String getMerchant() {
        return merchant;
    }

    public String getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setReceiptId(long receiptId) {
        this.receiptId = receiptId;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }
}
