package org.softuni.pathfinder.service.impl;

import org.modelmapper.ModelMapper;
import org.softuni.pathfinder.exceptions.RouteNotFoundException;
import org.softuni.pathfinder.exceptions.UserNotFoundException;
import org.softuni.pathfinder.models.Comment;
import org.softuni.pathfinder.models.Route;
import org.softuni.pathfinder.models.User;
import org.softuni.pathfinder.models.dto.binding.CreateCommentBindingModel;
import org.softuni.pathfinder.reposritory.CommentRepository;
import org.softuni.pathfinder.reposritory.RouteRepository;
import org.softuni.pathfinder.reposritory.UserRepository;
import org.softuni.pathfinder.service.CommentService;
import org.softuni.pathfinder.service.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final RouteRepository routeRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;

    public CommentServiceImpl(CommentRepository commentRepository, RouteRepository routeRepository, UserRepository userRepository, ModelMapper modelMapper, LoggedUser loggedUser) {
        this.commentRepository = commentRepository;
        this.routeRepository = routeRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
    }

    @Override
    public void create(CreateCommentBindingModel createCommentBindingModel) {
        Optional<Route> optionalRoute = routeRepository.findById(createCommentBindingModel.getRouteId());

        if (optionalRoute.isEmpty()) {
            throw new RouteNotFoundException("Route not found!");
        }

        Optional<User> optionalUser = userRepository.findByUsername(loggedUser.getUsername());
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("User with username: " + loggedUser.getUsername() + " is not found!");
        }
        User user = optionalUser.get();

        Route route = optionalRoute.get();

        Comment comment = modelMapper.map(createCommentBindingModel, Comment.class);
        comment.setRoute(route);
        comment.setCreated(LocalDateTime.now());
        comment.setAuthor(user);
        comment.setApproved(true);


        commentRepository.save(comment);
    }
}
