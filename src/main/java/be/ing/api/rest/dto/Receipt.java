package be.ing.api.rest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Builder
@Getter
@Setter
public class Receipt {

    private int receiptId;
    private String receiptUserId;
    private int receiptShopId;
    private Date receiptDate;
    private long receiptTotalAmount;
    private long receiptTotalVAT;
    private long receiptTotalDiscount;
    private String receiptPaymentInformation;

}
