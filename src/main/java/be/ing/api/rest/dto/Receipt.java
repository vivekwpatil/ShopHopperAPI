package be.ing.api.rest.dto;

import be.ing.api.provider.ShopEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by D-YD95PD on 22/03/2018.
 */

@Builder
@Getter
@Setter
public class Receipt {
    private int receiptId;
    private Shop receiptShopInformation;
    private String receiptUserId;
    private Date receiptDate;
    private long receiptTotalAmount;
    private long receiptTotalVAT;
    private long receiptTotalDiscount;
    private String receiptPaymentInformation;
    private String itemsHyperLink;
}
