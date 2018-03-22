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
        return StreamSupport
                .stream(receiptDAO.findAll().spliterator(), false)
                .collect(Collectors.toList());

    }

    public List<Object> getReceiptsByUserId(String userId) {

        //TODO: Implement logic to get particular receipt based on id

        return StreamSupport
                .stream(receiptDAO.findAll().spliterator(), false)
                .filter(receipt -> receipt.getReceiptUserId().equals(userId))
                .collect(Collectors.toList());

    }


    /*public Object createReceipt(Receipt receipt) {

        ReceiptEntity receiptEntity = new ReceiptEntity(receipt);

        //implement logic to insert receipt in DB

        return "Receipt created";

    }*/

}
