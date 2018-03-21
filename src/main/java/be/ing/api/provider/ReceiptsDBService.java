package be.ing.api.provider;


import be.ing.api.rest.dto.Receipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class ReceiptsDBService {

    @Autowired
    private ReceiptDAO receiptDAO;

    public List<Object> getReceipts() {
        Iterable<Receipt> iterable
                = Arrays.asList(Receipt.builder().receiptTotalAmount(600).receiptShopId(123).receiptId(1234).receiptDate(new Date("08/03/2018")).receiptPaymentInformation("TV").build()
                , Receipt.builder().receiptTotalAmount(600).receiptShopId(123).receiptId(1234).receiptDate(new Date("08/03/2018")).receiptPaymentInformation("TV").build());

        List<Object> receipts = StreamSupport
                .stream(receiptDAO.findAll().spliterator(), false)
                .collect(Collectors.toList());

        Iterable<ReceiptEntity> tests = receiptDAO.findAll();

        return receipts;

    }

    public Receipt getReceipt(String receiptId) {

        //TODO: Implement logic to get particular receipt based on id

        return Receipt.builder().receiptTotalAmount(600).receiptShopId(123).receiptId(1234).receiptDate(new Date("08/03/2018")).receiptPaymentInformation("TV").build();

    }


    public String createReceipt(Receipt receipt) {

        ReceiptEntity receiptEntity = new ReceiptEntity();

        //implement logic to insert receipt in DB

        return "Receipt created";

    }

}
