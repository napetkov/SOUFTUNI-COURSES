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
public class UserProfileViewModel {
    private String fullName;
    private String username;
    private Level level;
    private int age;

}
