package card.api.client;

import card.api.client.model.CashbackDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cashback-client",
        url = "https://localhost:8090/cashback-api/V1.0/")
public interface CashbackClient {
    @GetMapping("cashbacks/{iban}")
    CashbackDto getCashbackByIban(@PathVariable String iban);
}
