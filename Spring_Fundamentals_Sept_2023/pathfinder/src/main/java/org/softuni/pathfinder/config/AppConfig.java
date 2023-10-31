package org.softuni.pathfinder.config;

import org.modelmapper.Conditions;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.softuni.pathfinder.exceptions.LoginCredentialsException;
import org.softuni.pathfinder.models.Category;
import org.softuni.pathfinder.models.Route;
import org.softuni.pathfinder.models.User;
import org.softuni.pathfinder.models.dto.binding.AddRouteBidingModel;
import org.softuni.pathfinder.models.dto.binding.UserRegisterBindingModel;
import org.softuni.pathfinder.models.dto.view.RouteCategoryViewModel;
import org.softuni.pathfinder.models.enums.CategoryNames;
import org.softuni.pathfinder.models.enums.Level;
import org.softuni.pathfinder.reposritory.UserRepository;
import org.softuni.pathfinder.service.CategoryService;
import org.softuni.pathfinder.service.RoleService;
import org.softuni.pathfinder.service.session.LoggedUser;
import org.softuni.pathfinder.util.YoutubeUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class AppConfig {

    private final LoggedUser loggedUser;
    private final UserRepository userRepository;
    private final CategoryService categoryService;
    private final RoleService roleService;

    public AppConfig(
            LoggedUser loggedUser,
            UserRepository userRepository,
            CategoryService categoryService,
            RoleService roleService) {
        this.loggedUser = loggedUser;
        this.userRepository = userRepository;
        this.categoryService = categoryService;
        this.roleService = roleService;
    }

    @Bean
    public ModelMapper modelMapper() {

        final ModelMapper modelMapper = new ModelMapper();

        //AddRouteBindingModel -> Route
        Provider<User> loggedUserProvider = req -> getLoggedUser();
        Provider<String> youtubeSubUrlProvider = req -> YoutubeUtil.getUrl((String) req.getSource());

        Converter<Set<CategoryNames>, Set<Category>> toEntitySet
                = ctx -> (ctx.getSource() == null)
                ? null
                : categoryService.findAllByNameIn(ctx.getSource());

        modelMapper
                .createTypeMap(AddRouteBidingModel.class, Route.class)
                .addMappings(mapper -> mapper
                        .using(toEntitySet)
                        .map(AddRouteBidingModel::getCategories, Route::setCategories))
                .addMappings(mapper -> mapper
                        .when(Conditions.isNull())
                        .with(loggedUserProvider)
                        .map(AddRouteBidingModel::getAuthor, Route::setAuthor))
                .addMappings(mapper -> mapper
                        .with(youtubeSubUrlProvider)
                        .map(AddRouteBidingModel::getVideoUrl, Route::setVideoUrl));

        //UserRegisterBindingModel -> User
        Provider<User> newUserProvider = req -> new User()
                .setRoles(Set.of(roleService.getRoleByName("USER")))
                .setLevel(Level.BEGINNER);

        Converter<String, String> passwordConverter
                = ctx -> (ctx.getSource() == null)
                ? null
                : passwordEncoder().encode(ctx.getSource());

        modelMapper
                .createTypeMap(UserRegisterBindingModel.class, User.class)
                .setProvider(newUserProvider)
                .addMappings(mapper -> mapper
                        .using(passwordConverter)
                        .map(UserRegisterBindingModel::getPassword, User::setPassword));

        // RouteCategoryViewModel
        modelMapper
                .createTypeMap(Route.class, RouteCategoryViewModel.class)
                .addMappings(mapper -> mapper
                        .map(Route::getName, RouteCategoryViewModel::setTitle));


        // TODO check why mapping is not working!!!
//        modelMapper
//                .createTypeMap(Route.class, RouteDetailsViewModel.class)
//                .addMappings(mapper -> mapper
//                        .map(route -> route.getAuthor().getUsername(), RouteDetailsViewModel::setAuthorName));

        return modelMapper;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private User getLoggedUser() {
        final String username = loggedUser.getUsername();
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new LoginCredentialsException("User with username: " + username + " is not present"));
    }
}
