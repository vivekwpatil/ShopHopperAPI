package be.ing.api.provider;


import be.ing.api.rest.dto.Receipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class ReceiptsDBService {

    @Autowired
    private ReceiptDAO receiptDAO;

    public List<Object> getReceipts() {
        Iterable<Receipt> iterable
                = Arrays.asList(Receipt.builder().amount("600").merchant("Mediamart").receiptId(Long.valueOf("1234")).date("08/03/2018").itemDescription("TV").build()
                , Receipt.builder().amount("600").merchant("Mediamart").receiptId(Long.valueOf("1234")).date("08/03/2018").itemDescription("TV").build());

        List<Object> receipts = StreamSupport
                .stream(iterable.spliterator(), false)
                .collect(Collectors.toList());

        Iterable<TestEntity> tests = receiptDAO.findAll();

        return receipts;

    }

    public Receipt getReceipt(String receiptId) {

        return Receipt.builder().amount("600").merchant("Mediamart").receiptId(Long.valueOf("1234")).date("08/03/2018").itemDescription("TV").build();

    }


    public String createReceipt(Receipt receipt) {

        ReceiptEntity receiptEntity = new ReceiptEntity();
        receiptEntity.setAmount(receipt.getAmount());
        receiptEntity.setDate(receipt.getDate());

        return "Receipt created";

    }

}
