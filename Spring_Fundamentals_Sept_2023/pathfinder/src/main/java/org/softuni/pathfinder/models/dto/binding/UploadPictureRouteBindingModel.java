package org.softuni.pathfinder.models.dto.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.softuni.pathfinder.validation.anotations.FileAnnotation;
import org.springframework.web.multipart.MultipartFile;
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class UploadPictureRouteBindingModel {
    private long id;
    @FileAnnotation(contentTypes = {"image/png", "image/jpeg"})
    private MultipartFile picture;
}
