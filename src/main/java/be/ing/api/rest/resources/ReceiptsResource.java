package be.ing.api.rest.resources;

import be.ing.api.provider.ReceiptsDBService;
import be.ing.api.rest.dto.Receipt;
import be.ing.api.rest.dto.ReceiptsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/shophopper")
public class ReceiptsResource {

    @Autowired
    ReceiptsDBService receiptsDBService;

    @RequestMapping(value = "/receipts", method = RequestMethod.GET)
    public ReceiptsResponse getAllReceipts() {

        List receipts =  receiptsDBService.getReceipts();
        for(Object r : receipts){
            Receipt re =( Receipt) r;
            System.out.println(""+re.getItemDescription());

        }
        return ReceiptsResponse.builder().receipts(Arrays.asList(Receipt.builder().amount("600").merchant("Mediamart").receiptId(Long.valueOf("1234")).date("08/03/2018").itemDescription("TV").build(),
                Receipt.builder().amount("800").merchant("Fnac").receiptId(Long.valueOf("5678")).date("08/03/2019").itemDescription("Ipad").build())).build();
    }

    @RequestMapping(value = "/receipts/{receiptId}", method = RequestMethod.GET)
    public Receipt getAllReceipts(
            @PathVariable("receiptId") String receiptId
    ) {
        System.out.println("receiptid received is ::" + receiptId);

        return receiptsDBService.getReceipt(receiptId);
    }

    @RequestMapping(value = "/receipt", method = RequestMethod.POST)
    public void createReceipt(
            @NotNull Receipt receipt
    ) {
        receiptsDBService.createReceipt(receipt);


    }


}
