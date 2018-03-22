package be.ing.api.rest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


/**
 * Created by D-YD95PD on 22/03/2018.
 */

@Builder
@Getter
@Setter
public class Item {
    private int itemNumber;
    private int itemUnitCount;
    private String itemName;
    private int itemPrice;
    private int itemUnitPrice;
    private String itemCategory;
    private int itemDiscount;
    private Date itemWarantyEndDate;
    private String itemTypeCode;
    private Receipt receipt;

}
