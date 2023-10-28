package org.softuni.mobilele.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.softuni.mobilele.model.dto.ExchangeRatesDTO;
import org.softuni.mobilele.model.entity.ExchangeRateEntity;
import org.softuni.mobilele.repository.ExchangeRateRepository;
import org.softuni.mobilele.service.CurrencyService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.Optional;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    private final Logger LOGGER = LoggerFactory.getLogger(CurrencyServiceImpl.class);
    private final ExchangeRateRepository exchangeRateRepository;

    public CurrencyServiceImpl(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    @Override
    public void refreshRates(ExchangeRatesDTO exchangeRatesDTO) {
        BigDecimal BGN_TO_USD = getExchangeRate(exchangeRatesDTO,"BGN","USD").orElse(null);
        BigDecimal BGN_TO_EUR = getExchangeRate(exchangeRatesDTO,"BGN","EUR").orElse(null);

        LOGGER.info("Exchange rates received {}",exchangeRatesDTO);


        if(BGN_TO_USD != null){
            ExchangeRateEntity exchangeRateEntity =
                    new ExchangeRateEntity()
                            .setCurrency("USD")
                            .setRate(BGN_TO_USD);

            exchangeRateRepository.save(exchangeRateEntity);
        } else {
            LOGGER.error("Unable to get exchange rate for BGN to USD");
        }

        if(BGN_TO_EUR != null){
            ExchangeRateEntity exchangeRateEntity =
                    new ExchangeRateEntity()
                            .setCurrency("EUR")
                            .setRate(BGN_TO_EUR);

            exchangeRateRepository.save(exchangeRateEntity);
        } else {
            LOGGER.error("Unable to get exchange rate for BGN to EUR");
        }

        LOGGER.info("Rates Refreshed .....");
    }

    private static Optional<BigDecimal> getExchangeRate(
            ExchangeRatesDTO exchangeRatesDTO,
            String from,
            String to
    ){
        Objects.requireNonNull(from,"From currency cannot be null!");
        Objects.requireNonNull(to,"To currency cannot be null!");
        // e.g. USD -> USD
        if(Objects.equals(from,to)){
            return Optional.of(BigDecimal.ONE);
        }


        if(from.equals(exchangeRatesDTO.base())){
            //e.g. USD -> BGN
            if(exchangeRatesDTO.rates().containsKey(to)){
                return Optional.of(exchangeRatesDTO.rates().get(to));
            }
        } else if (Objects.equals(to,exchangeRatesDTO.base())) {
            //e.g. BGN -> USD
                if(exchangeRatesDTO.rates().containsKey(from)){
                    return Optional.of(
                            BigDecimal.ONE.divide(
                                    exchangeRatesDTO.rates().get(from),
                                    3,
                                    RoundingMode.DOWN
                            ));
                }
        } else if(exchangeRatesDTO.rates().containsKey(from) &&
        exchangeRatesDTO.rates().containsKey(to)){
            return Optional.of(exchangeRatesDTO.rates().get(to).divide(
                    exchangeRatesDTO.rates().get(from),
                    3,
                    RoundingMode.DOWN
            ));
        }

        return Optional.empty();
    }
}
