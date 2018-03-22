package be.ing.api.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by D-YD95PD on 22/03/2018.
 */@Component
public class ShopsDBService {

    @Autowired
    private ReceiptDAOLinked receiptDAOLinked;
    @Autowired
    private ShopDAO shopDAO;

    public Object getShopById(int id) {
        return StreamSupport
                .stream(shopDAO.findAll().spliterator(), false)
                .filter(shop -> shop.getShopId() == id)
                .collect(Collectors.toList()).get(0);

    }
}
