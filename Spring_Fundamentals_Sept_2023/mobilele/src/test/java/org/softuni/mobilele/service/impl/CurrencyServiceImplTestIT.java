package org.softuni.mobilele.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.softuni.mobilele.model.dto.ExchangeRatesDTO;
import org.softuni.mobilele.model.entity.ExchangeRateEntity;
import org.softuni.mobilele.repository.ExchangeRateRepository;
import org.softuni.mobilele.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CurrencyServiceImplTestIT {
    @Autowired
    private CurrencyService currencyServiceToTest;

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    @BeforeEach
    void setUp() {
        exchangeRateRepository.deleteAll();
    }

    @BeforeEach
    void tearDown() {
        exchangeRateRepository.deleteAll();
    }

    @ParameterizedTest(name = "Conversion BGN/USD exchangeRate {0} , expected {1}")
    @MethodSource("test_Data_BGN_TO_USD")
    void test_BGN_TO_USD(Double exchangeRate, Double expectedValue) {
        ExchangeRatesDTO exchangeRatesDTO = new ExchangeRatesDTO("USD",
                Map.of("BGN", BigDecimal.valueOf(exchangeRate)));

        currencyServiceToTest.refreshRates(exchangeRatesDTO);

        Optional<ExchangeRateEntity> exchangeRateUSD_BGN = exchangeRateRepository.findById("USD");

        assertTrue(exchangeRateUSD_BGN.isPresent());
        assertEquals(
                BigDecimal.valueOf(expectedValue).setScale(2, RoundingMode.DOWN),
                exchangeRateUSD_BGN.map(ExchangeRateEntity::getRate)
                        .orElse(null));

    }

    @ParameterizedTest(name = "Conversion BGN/EUR exchangeRateBGN {0},exchangeRateEUR {1} , expected {2}")
    @MethodSource("test_Data_BGN_TO_EUR")
    void test_BGN_TO_EUR(
            Double exchangeRateBGN,
            Double exchangeRateEUR,
            Double expectedValue) {
        ExchangeRatesDTO exchangeRatesDTO = new ExchangeRatesDTO("USD",
                Map.of("BGN", BigDecimal.valueOf(exchangeRateBGN),
                        "EUR", BigDecimal.valueOf(exchangeRateEUR)));

        currencyServiceToTest.refreshRates(exchangeRatesDTO);

        Optional<ExchangeRateEntity> exchangeRateUSD_BGN = exchangeRateRepository.findById("EUR");

        assertTrue(exchangeRateUSD_BGN.isPresent());
        assertEquals(
                BigDecimal.valueOf(expectedValue).setScale(2, RoundingMode.DOWN),
                exchangeRateUSD_BGN.map(ExchangeRateEntity::getRate)
                        .orElse(null));

    }

    private static Stream<Arguments> test_Data_BGN_TO_EUR() {
        return Stream.of(
                Arguments.of(1.840515, 0.937668, 0.51),
                Arguments.of(1.777515, 0.544454, 0.31),
                Arguments.of(1.0, 1.0, 1.0)
        );
    }

    private static Stream<Arguments> test_Data_BGN_TO_USD() {
        return Stream.of(
                Arguments.of(1.840515, 0.54),
                Arguments.of(1.752345, 0.57),
                Arguments.of(1.333333, 0.75),
                Arguments.of(1.0, 1.0)
        );
    }
}
