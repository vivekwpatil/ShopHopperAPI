package be.ing.api.rest.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
//@Entity
@Getter
//@Table(name = "Receipt")
public class Receipt {

    /*public Receipt(String amount, String date, String itemDescription){
        this.amount = amount;
        this.date = date;
        this.itemDescription=itemDescription;

    }*/

    //@GeneratedValue(strategy = GenerationType.AUTO)
    private long receiptId;

    private String merchant;
    private String amount;
    private String date;
    private String itemDescription;


}
