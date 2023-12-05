package org.softuni.mobilele.service.impl;

import org.softuni.mobilele.model.entity.UserActivationCodeEntity;
import org.softuni.mobilele.model.events.UserRegisteredEvent;
import org.softuni.mobilele.repository.UserActivationCodeRepository;
import org.softuni.mobilele.repository.UserRepository;
import org.softuni.mobilele.service.EmailService;
import org.softuni.mobilele.service.UserActivationService;
import org.softuni.mobilele.service.exception.ObjectNotFoundException;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.Instant;
import java.util.Random;

@Service
public class UserActivationServiceImpl implements UserActivationService {
    private static final String ACTIVATION_CODE_SYMBOLS = "abcdefgijklmnopqrstuvwxyzABCDEFGIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int ACTIVATION_CODE_LENGTH = 20;
    private final UserRepository userRepository;
    private final UserActivationCodeRepository userActivationCodeRepository;
    private final EmailService emailService;

    public UserActivationServiceImpl(UserRepository userRepository, UserActivationCodeRepository userActivationCodeRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.userActivationCodeRepository = userActivationCodeRepository;
        this.emailService = emailService;
    }

    @Override
    @EventListener(UserRegisteredEvent.class)
    public void userRegistered(UserRegisteredEvent event) {
        String activationCode = createActivationCode(event.getUserEmail());

        emailService.sendRegistrationEmail(event.getUserEmail(), event.getUserNames(),activationCode);
    }

    @Override
    public void cleanUpObsoleteActivationLinks() {
//        TODO: Implement
//        System.out.println("NOT YET!!!");
    }

    @Override
    public String createActivationCode(String userEmail) {

        String activationCode = generateActivationCode();

        UserActivationCodeEntity userActivationCodeEntity = new UserActivationCodeEntity();
        userActivationCodeEntity.setActivationCode(activationCode)
                .setCreated(Instant.now())
                .setUser(userRepository.findByEmail(userEmail).orElseThrow(() -> new ObjectNotFoundException("User not found!")));

        userActivationCodeRepository.save(userActivationCodeEntity);

        return activationCode;
    }
    private static String generateActivationCode(){
        Random random = new SecureRandom();
        StringBuilder activationCode = new StringBuilder();

        for (int i = 0; i < ACTIVATION_CODE_LENGTH; i++) {
            int randomIndex = random.nextInt(ACTIVATION_CODE_SYMBOLS.length());
            activationCode.append(ACTIVATION_CODE_SYMBOLS.charAt(randomIndex));
        }
        return activationCode.toString();
    }

}
