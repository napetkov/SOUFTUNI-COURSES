package bg.softuni.quickfsdemo.controller;

import bg.softuni.quickfsdemo.service.FinancialDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FinancialDataController {
    private final FinancialDataService financialDataService;

    public FinancialDataController(FinancialDataService financialDataService) {
        this.financialDataService = financialDataService;
    }

    @GetMapping("/company/{symbol}/financial-data")
    public Mono<ResponseEntity<String>> getCompanyFinancialData(@PathVariable("symbol") String symbol) {
        return financialDataService.getCompanyFinancialData(symbol)
                .map(data -> {
                    // Here, you could parse and manipulate the JSON data as needed
                    // For simplicity, let's just return the raw data
                    return ResponseEntity.ok(data);
                });
    }
}
