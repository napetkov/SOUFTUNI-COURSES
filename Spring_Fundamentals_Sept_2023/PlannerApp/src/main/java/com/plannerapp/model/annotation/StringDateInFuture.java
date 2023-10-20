package com.plannerapp.model.annotation;

import com.plannerapp.vallidation.StringDateInFutureValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StringDateInFutureValidator.class)
public @interface StringDateInFuture {
    String message() default "Date is not in future";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
