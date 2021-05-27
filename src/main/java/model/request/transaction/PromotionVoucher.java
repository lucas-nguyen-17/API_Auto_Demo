package model.request.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PromotionVoucher {
    @JsonProperty("promotion_ids")
    private List<Integer> promotionIds;
    @JsonProperty("voucher_code")
    private String voucherCode;
}
