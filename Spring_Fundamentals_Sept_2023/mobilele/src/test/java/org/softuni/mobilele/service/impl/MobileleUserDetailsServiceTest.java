package org.softuni.mobilele.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.softuni.mobilele.model.entity.UserEntity;
import org.softuni.mobilele.repository.UserRepository;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MobileleUserDetailsServiceTest {

    private MobileleUserDetailsService serviceToTest;
    @Mock
    private UserRepository mockUserRepository;

    @BeforeEach
    void setUp() {
        serviceToTest = new MobileleUserDetailsService(
                mockUserRepository
        );
    }

    @Test
    void testMock() {
        UserEntity userOpt = new UserEntity().setFirstName("Pesho");

        when(mockUserRepository.findByEmail("test@example.com"))
                .thenReturn(Optional.of(userOpt));


        Optional<UserEntity> userOptional = mockUserRepository.findByEmail("test@example.com");
        UserEntity userEntity = userOptional.get();

        Assertions.assertEquals("Pesho",userEntity.getFirstName());
    }

}
