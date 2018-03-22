package be.ing.api.provider;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class ItemsDBService {

    @Autowired
    private ItemDAO itemDAO;


    public List<Object> getItems() {
        return StreamSupport
                .stream(itemDAO.findAll().spliterator(), false)
                .collect(Collectors.toList());

    }

    public List<Object> getItemsByReceiptId(int receiptId) {

        //TODO: Implement logic to get particular receipt based on id

        return StreamSupport
                .stream(itemDAO.findAll().spliterator(), false)
                .filter(item -> item.getReceiptId() == receiptId)
                .collect(Collectors.toList());
    }

}
