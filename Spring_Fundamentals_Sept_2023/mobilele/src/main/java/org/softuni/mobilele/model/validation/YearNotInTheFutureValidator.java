package org.softuni.mobilele.model.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.Year;

public class YearNotInTheFutureValidator implements ConstraintValidator<YearNotInTheFuture, Number> {
    @Override
    public boolean isValid(Number value, ConstraintValidatorContext context) {
        int currentYear = Year.now().getValue();

        if (value == null) {
            return true;
        } else {
            return value.intValue() < currentYear;
        }
    }
}
