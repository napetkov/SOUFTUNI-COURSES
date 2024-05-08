package bg.softuni.quickfsdemo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class FinancialDataService {

    private final WebClient webClient;

    public FinancialDataService(WebClient.Builder webClientBuilder, @Value("${QUICKFS_API_KEY}") String apiKey) {
        this.webClient = webClientBuilder
                .baseUrl("https://public-api.quickfs.net/v1/data/all-data/")
                .defaultHeader("X-QFS-API-Key",apiKey)
                .build();
    }

    public Mono<String> getCompanyFinancialData(String companySymbol) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("{symbol}").build(companySymbol)) // Use path variables for flexibility
                .retrieve() // Retrieve the response
                .onStatus(status -> !status.is2xxSuccessful(), response -> {
                    // Handle non-2xx status codes with custom logic
                    return response.createException().flatMap(Mono::error);
                })
                .bodyToMono(String.class); // Convert the response body to a Mono of String (JSON)
    }
}
