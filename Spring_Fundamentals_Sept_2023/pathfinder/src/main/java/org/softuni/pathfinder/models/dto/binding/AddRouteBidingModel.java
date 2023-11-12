package org.softuni.pathfinder.models.dto.binding;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.softuni.pathfinder.models.User;
import org.softuni.pathfinder.models.enums.CategoryNames;
import org.softuni.pathfinder.models.enums.Level;
import org.softuni.pathfinder.validation.anotations.FileAnnotation;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class AddRouteBidingModel {
    @Size(min = 3, message = "Name length must be more than 3 characters")
    private String name;
    @Size(min = 5, message = "Description length must be more than 5 characters!")
    private String description;
    private Level level;
    @FileAnnotation(contentTypes = "text/xml")
    private MultipartFile gpxCoordinates;
    @Pattern(regexp = "https:\\/\\/www\\.youtube\\.com\\/watch\\?v=.*", message = "Invalid youtube url provided")
    private String videoUrl;
    private User author;
    private Set<CategoryNames> categories;
}
