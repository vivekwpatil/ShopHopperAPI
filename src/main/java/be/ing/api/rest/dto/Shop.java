package be.ing.api.rest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class Shop {

    private int shopId;

    private String shopName;

    private String shopAddress;

    private String shopPhoneNumber;

}
