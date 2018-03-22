package be.ing.api.rest.dto;

import be.ing.api.provider.ItemEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

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
    private List<ItemEntity> receiptItems;

}