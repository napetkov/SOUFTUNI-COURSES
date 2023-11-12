package org.softuni.pathfinder.validation.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.softuni.pathfinder.models.dto.binding.AddRouteBidingModel;
import org.softuni.pathfinder.validation.anotations.FileAnnotation;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

public class FileValidator implements ConstraintValidator<FileAnnotation, MultipartFile> {
    private List<String> contentTypes;
    private long size;

    @Override
    public void initialize(FileAnnotation constraintAnnotation) {
        this.size = constraintAnnotation.size();
        this.contentTypes = Arrays.stream(constraintAnnotation.contentTypes()).toList();

        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
        String errorMsg = getErrorMsg(file);
        if(!errorMsg.isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(errorMsg)
                    .addConstraintViolation();
        return false;
        }
        return true;
    }

    private String getErrorMsg(MultipartFile file) {
        if(file.isEmpty()){
            return "File must be provided!";
        }

        if(file.getSize() > size){
            return "Exceeded file size. Max size: " + size;
        }

        if(!contentTypes.contains(file.getContentType())){
            return "Invalid file extension. Support files: " + String.join(", ",contentTypes);
        }

        return "";
    }
}
