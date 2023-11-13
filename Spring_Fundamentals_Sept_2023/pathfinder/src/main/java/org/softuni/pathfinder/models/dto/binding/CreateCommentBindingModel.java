package org.softuni.pathfinder.models.dto.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateCommentBindingModel {
    private long id;
    private long routeId;
    private String textContent;
}
