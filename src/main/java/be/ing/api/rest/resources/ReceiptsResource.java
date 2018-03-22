package be.ing.api.rest.resources;

import be.ing.api.provider.ReceiptEntity;
import be.ing.api.provider.ReceiptsDBService;
import be.ing.api.rest.dto.Receipt;
import be.ing.api.rest.dto.ReceiptsResponse;
import be.ing.api.rest.dto.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/shophopper")
public class ReceiptsResource {

    @Autowired
    private ReceiptsDBService receiptsDBService;

    @RequestMapping(value = "/receipts", method = RequestMethod.GET)
    public ReceiptsResponse getAllReceipts() {

        List receipts = receiptsDBService.getReceipts();
        List receiptNew = new ArrayList();
        for (Object r : receipts) {
            ReceiptEntity re = (ReceiptEntity) r;


            Shop shop = null;
            if (null != re.getShopEntity()) {


                shop = Shop.builder()
                        .shopName(re.getShopEntity().getShopName())
                        .shopAddress(re.getShopEntity().getShopAddress())
                        .shopPhoneNumber(re.getShopEntity().getShopPhoneNumber())
                        .shopId(re.getShopEntity().getShopId())
                        .build();

                receiptNew.add(Receipt.builder().receiptDate(re.getReceiptDate())
                                .receiptId(re.getReceiptId())
                                .receiptUserId(re.getReceiptUserId())
                                .receiptPaymentInformation(re.getReceiptPaymentInformation())
                                .shopId(re.getShopId())
                                .shopName(re.getShopEntity().getShopName())
                                .shopAddress(re.getShopEntity().getShopAddress())
                                .shopPhoneNumber(re.getShopEntity().getShopPhoneNumber())
                                .receiptTotalAmount(re.getReceiptTotalAmount())
                                .receiptTotalDiscount(re.getReceiptTotalDiscount())
                                .receiptTotalVAT(re.getReceiptTotalVAT())
                                .receiptItems(re.getItems())
                                .build()
                );



            }
            else{
                System.out.println("null entity found12");
                receiptNew.add(Receipt.builder().receiptDate(re.getReceiptDate())
                                .receiptId(re.getReceiptId())
                                .receiptUserId(re.getReceiptUserId())
                                .receiptPaymentInformation(re.getReceiptPaymentInformation())
                                .shopId(re.getShopId())
                                .shopName("shop name NA")
                                .shopAddress("shop address NA")
                                .shopPhoneNumber("shop number NA")
                                .receiptTotalAmount(re.getReceiptTotalAmount())
                                .receiptTotalDiscount(re.getReceiptTotalDiscount())
                                .receiptTotalVAT(re.getReceiptTotalVAT())
                                .receiptItems(re.getItems())
                                .build()
                );
            }



        }

       /*return ReceiptsResponse.builder().receipts(Arrays.asList(Receipt.builder().receiptTotalAmount(600).receiptShopId(123).receiptId(1234).receiptDate(new Date("08/03/2018")).receiptPaymentInformation("TV").build()
                , Receipt.builder().receiptTotalAmount(600).receiptShopId(123).receiptId(1234).receiptDate(new Date("08/03/2018")).receiptPaymentInformation("TV").build())).build();
*/

        return ReceiptsResponse.builder().receipts(receiptNew).build();
    }

    @RequestMapping(value = "/receipts/{receiptId}", method = RequestMethod.GET)
    public ReceiptsResponse getReceiptsByUserId(
            @PathVariable("receiptId") String userId
    ) {
        List receipts = receiptsDBService.getReceiptsByUserId(userId);
        List receiptNew = new ArrayList();
        for (Object r : receipts) {
            ReceiptEntity re = (ReceiptEntity) r;
            receiptNew.add(Receipt.builder().receiptDate(re.getReceiptDate())
                            .receiptId(re.getReceiptId())
                            .receiptUserId(re.getReceiptUserId())
                            .receiptPaymentInformation(re.getReceiptPaymentInformation())
                            .shopId(re.getShopId())
                            .receiptTotalAmount(re.getReceiptTotalAmount())
                            .receiptTotalDiscount(re.getReceiptTotalDiscount())
                            .receiptTotalVAT(re.getReceiptTotalVAT())
                            .receiptItems(re.getItems())
                            .build()
            );
        }
        return ReceiptsResponse.builder().receipts(receiptNew).build();


    }

    /*@RequestMapping(value = "/receipt", method = RequestMethod.POST)
    public ReceiptEntity createReceipt(
            @RequestBody @NotNull Receipt receipt
    ) {
        return (ReceiptEntity) receiptsDBService.createReceipt(receipt);



    }*/


}
