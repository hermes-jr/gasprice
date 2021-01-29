package net.cyllene.gasprice.service;

import net.cyllene.gasprice.annotations.ValidMultipartJpegImage;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MultipartJpegImageValidator implements ConstraintValidator<ValidMultipartJpegImage, MultipartFile> {
    @Override
    public void initialize(ValidMultipartJpegImage constraintAnnotation) {
    }

    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
        return "image/jpeg".equals(file.getContentType()) && !file.isEmpty();
    }
}
