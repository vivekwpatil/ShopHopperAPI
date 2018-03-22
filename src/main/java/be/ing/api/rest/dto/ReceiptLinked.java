package be.ing.api.rest.dto;

import be.ing.api.provider.ItemEntityLinked;
import be.ing.api.provider.ShopEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
public class ReceiptLinked {

    private int receiptId;
    //private ShopEntity receiptShopInformation;
    private int shopId;
    private String receiptUserId;
    private Date receiptDate;
    private long receiptTotalAmount;
    private long receiptTotalVAT;
    private long receiptTotalDiscount;
    private String receiptPaymentInformation;
    private List<ItemEntityLinked> receiptItems;

}
