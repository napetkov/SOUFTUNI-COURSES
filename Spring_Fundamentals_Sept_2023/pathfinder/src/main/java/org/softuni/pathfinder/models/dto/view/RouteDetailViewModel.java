package org.softuni.pathfinder.models.dto.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.softuni.pathfinder.models.enums.Level;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class RouteDetailViewModel {
    private Long id;
    private String description;
    private String videoUrl;
    private String name;
    private Level level;
    private String authorName;

//    TODO: pass coordinates

}
