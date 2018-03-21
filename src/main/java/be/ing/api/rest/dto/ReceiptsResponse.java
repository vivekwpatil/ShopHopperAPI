package be.ing.api.rest.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ReceiptsResponse {

    private List<Receipt> receipts;
}
