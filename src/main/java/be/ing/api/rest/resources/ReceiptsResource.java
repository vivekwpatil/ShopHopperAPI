package be.ing.api.rest.resources;

import be.ing.api.provider.ItemDBService;
import be.ing.api.provider.ReceiptEntity;
import be.ing.api.provider.ReceiptsDBService;
import be.ing.api.rest.dto.Receipt;
import be.ing.api.rest.dto.ReceiptsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
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

    @RequestMapping(value = "/receipts", method = RequestMethod.GET)
    public ReceiptsResponse getAllReceipts() {

        List receipts = receiptsDBService.getReceipts();
        List receiptNew = new ArrayList();
        for (Object r : receipts) {
            ReceiptEntity re = (ReceiptEntity) r;
            receiptNew.add(Receipt.builder().receiptDate(re.getReceiptDate())
                            .receiptId(re.getReceiptId())
                            .receiptUserId(re.getReceiptUserId())
                            .receiptPaymentInformation(re.getReceiptPaymentInformation())
                            .receiptShopId(re.getReceiptShopId())
                            .receiptTotalAmount(re.getReceiptTotalAmount())
                            .receiptTotalDiscount(re.getReceiptTotalDiscount())
                            .receiptTotalVAT(re.getReceiptTotalVAT())
                            .receiptItems(re.getItems())
                            .build()
            );

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
                    .receiptShopId(re.getReceiptShopId())
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
