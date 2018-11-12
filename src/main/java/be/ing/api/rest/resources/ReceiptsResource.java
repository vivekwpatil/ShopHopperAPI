package be.ing.api.rest.resources;

import be.ing.api.provider.*;
import be.ing.api.rest.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/shophopper")
public class ReceiptsResource {

    @Autowired
    private ReceiptsDBService receiptsDBService;
    @Autowired
    private ShopsDBService shopDBService;

    //get list of receipts
    @RequestMapping(value = "/receipts/test/{shopId}", method = RequestMethod.GET)
    public ReceiptsResponse getAllReceipts(@PathVariable("shopId") int shopId) {

        List receipts = receiptsDBService.getReceipts();
        ShopEntity shop = (ShopEntity) shopDBService.getShopById(shopId);
        List receiptNew = new ArrayList();
        for (Object r : receipts) {
            ReceiptEntity re = (ReceiptEntity) r;
            receiptNew.add(Receipt.builder().receiptDate(re.getReceiptDate())
                    .receiptId(re.getReceiptId())
                    .receiptShopInformation(
                            Shop.builder().shopPhoneNumber(shop.getShopPhoneNumber())
                            .shopAddress(shop.getShopAddress())
                            .shopName(shop.getShopName()).build()
                    )
                    .receiptUserId(re.getReceiptUserId())
                    .receiptPaymentInformation(re.getReceiptPaymentInformation())
                    .receiptTotalAmount(re.getReceiptTotalAmount())
                    .receiptTotalDiscount(re.getReceiptTotalDiscount())
                    .receiptTotalVAT(re.getReceiptTotalVAT())
                    .itemsHyperLink("http://localhost:8080/shophopper/items/" + re.getReceiptId())
                    .build()
            );
        }
        return ReceiptsResponse.builder().receipts(receiptNew).build();
    }

    @RequestMapping(value = "/receipts/{userId}", method = RequestMethod.GET)
    public ReceiptsResponse getReceiptsByUserId(
            @PathVariable("userId") String userId
    ) {
        List receipts = receiptsDBService.getReceiptsByUserId(userId);
        List receiptNew = new ArrayList();
        for (Object r : receipts) {
            ReceiptEntity re = (ReceiptEntity) r;
            ShopEntity shop = (ShopEntity) shopDBService.getShopById(re.getShop().getShopId());
            receiptNew.add(Receipt.builder().receiptDate(re.getReceiptDate())
                    .receiptId(re.getReceiptId())
                    .receiptShopInformation(
                            Shop.builder().shopPhoneNumber(shop.getShopPhoneNumber())
                                    .shopAddress(shop.getShopAddress())
                                    .shopName(shop.getShopName()).build()
                    )
                    .receiptUserId(re.getReceiptUserId())
                    .receiptPaymentInformation(re.getReceiptPaymentInformation())
                    .receiptTotalAmount(re.getReceiptTotalAmount())
                    .receiptTotalDiscount(re.getReceiptTotalDiscount())
                    .receiptTotalVAT(re.getReceiptTotalVAT())
                    .itemsHyperLink("http://localhost:8080/shophopper/items/" + re.getReceiptId())
                    .build()
            );
        }
        return ReceiptsResponse.builder().receipts(receiptNew).build();


    }

    @RequestMapping(value = "/receipt", method = RequestMethod.POST)
    public ReceiptEntityLinked createReceipt(
            @RequestBody @NotNull ReceiptEntityLinked receipt
    ) {
        return receiptsDBService.createReceipt(receipt);
    }

    @RequestMapping(value = "/receiptsTest", method = RequestMethod.GET)
    public ReceiptsResponse getReceiptsWithHyperLinks() {

        List receipts = receiptsDBService.getReceipts();
        List receiptNew = new ArrayList();
        for (Object r : receipts) {
            ReceiptEntity re = (ReceiptEntity) r;
            receiptNew.add(Receipt.builder().receiptDate(re.getReceiptDate())
                    .receiptId(re.getReceiptId())
                    /*.receiptShopInformation()*/
                    .receiptUserId(re.getReceiptUserId())
                    .receiptPaymentInformation(re.getReceiptPaymentInformation())
                    .receiptTotalAmount(re.getReceiptTotalAmount())
                    .receiptTotalDiscount(re.getReceiptTotalDiscount())
                    .receiptTotalVAT(re.getReceiptTotalVAT())
                    .itemsHyperLink("http://localhost:8080/shophopper/items/" + re.getReceiptId())
                    .build()
            );

        }

       /*return ReceiptsLinkedResponse.builder().receipts(Arrays.asList(ReceiptLinked.builder().receiptTotalAmount(600).receiptShopId(123).receiptId(1234).receiptDate(new Date("08/03/2018")).receiptPaymentInformation("TV").build()
                , ReceiptLinked.builder().receiptTotalAmount(600).receiptShopId(123).receiptId(1234).receiptDate(new Date("08/03/2018")).receiptPaymentInformation("TV").build())).build();
*/

        return ReceiptsResponse.builder().receipts(receiptNew).build();
    }

}
