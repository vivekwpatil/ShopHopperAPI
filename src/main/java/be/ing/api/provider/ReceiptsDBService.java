package be.ing.api.provider;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class ReceiptsDBService {

    @Autowired
    private ReceiptDAOLinked receiptDAOLinked;
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


    public ReceiptEntityLinked createReceipt(ReceiptEntityLinked receipt) {
        ReceiptEntityLinked savedArticle = receiptDAOLinked.save(receipt);
        return savedArticle;

        //implement logic to insert receipt in DB

    }

}
