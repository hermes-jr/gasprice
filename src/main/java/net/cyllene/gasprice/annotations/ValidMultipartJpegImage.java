package net.cyllene.gasprice.annotations;

import net.cyllene.gasprice.service.MultipartJpegImageValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MultipartJpegImageValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMultipartJpegImage {
    String message() default "jpeg image must be provided";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}