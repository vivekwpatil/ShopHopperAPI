package be.ing.api.rest.resources;

/**
 * Created by D-YD95PD on 22/03/2018.
 */

import be.ing.api.provider.*;
import be.ing.api.rest.dto.Item;
import be.ing.api.rest.dto.ItemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/shophopper")
public class ItemsResource {

    @Autowired
    private ItemsDBService itemsDBService;

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public ItemResponse getAllReceipts() {

        List items = itemsDBService.getItems();
        List itemNew = new ArrayList();
        for (Object i : items) {
            ItemEntity ie = (ItemEntity) i;
            itemNew.add(Item.builder().itemNumber(ie.getItemNumber())
                    .itemUnitCount(ie.getItemUnitCount())
                    .itemName(ie.getItemName())
                    .itemPrice(ie.getItemPrice())
                    .itemUnitPrice(ie.getItemUnitPrice())
                    .itemCategory(ie.getItemCategory())
                    .itemDiscount(ie.getItemDiscount())
                    .itemWarantyEndDate(ie.getItemWarantyEndDate())
                    .itemTypeCode(ie.getItemTypeCode())
                    .build()
            );
        }
        return ItemResponse.builder().items(itemNew).build();
    }

    @RequestMapping(value = "/items/{receiptId}", method = RequestMethod.GET)
    public ItemResponse getReceiptsByUserId(
            @PathVariable("receiptId") int receiptId
    ) {
        List items = itemsDBService.getItemsByReceiptId(receiptId);
        List itemNew = new ArrayList();
        for (Object i : items) {
            ItemEntity ie = (ItemEntity) i;
            itemNew.add(Item.builder().itemNumber(ie.getItemNumber())
                    .itemUnitCount(ie.getItemUnitCount())
                    .itemName(ie.getItemName())
                    .itemPrice(ie.getItemPrice())
                    .itemUnitPrice(ie.getItemUnitPrice())
                    .itemCategory(ie.getItemCategory())
                    .itemDiscount(ie.getItemDiscount())
                    .itemWarantyEndDate(ie.getItemWarantyEndDate())
                    .itemTypeCode(ie.getItemTypeCode())
                    .build()
            );
        }
        return ItemResponse.builder().items(itemNew).build();


    }
}
