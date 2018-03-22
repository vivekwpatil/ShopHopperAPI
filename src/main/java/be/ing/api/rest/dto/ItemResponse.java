package be.ing.api.rest.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * Created by D-YD95PD on 22/03/2018.
 */
@Getter
@Builder
public class ItemResponse {

    private List<Item> items;
}
