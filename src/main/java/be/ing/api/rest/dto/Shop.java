package be.ing.api.rest.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Shop {
    private String shopName;
    private String shopAddress;
    private String shopPhoneNumber;
}
