package org.softuni.mobilele.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.softuni.mobilele.model.entity.UserEntity;
import org.softuni.mobilele.model.entity.UserRoleEntity;
import org.softuni.mobilele.model.enums.UserRoleEnum;
import org.softuni.mobilele.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
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
    void testUserNotFoundThrowException() {
        Assertions.assertThrows(UsernameNotFoundException.class,
                () -> serviceToTest.loadUserByUsername("username"));
    }

    @Test
    void testUserFound() {
        //Arrange
        UserEntity testUser = createTestUser();

        when(mockUserRepository.findByEmail("test@email.com"))
                .thenReturn(Optional.of(testUser));
        //Act
        UserDetails userDetails = serviceToTest.loadUserByUsername(testUser.getEmail());

        //Assert
        Assertions.assertNotNull(userDetails);
        Assertions.assertEquals(testUser.getEmail(),
                userDetails.getUsername(),
                "Username is not mapped to email.");
        Assertions.assertEquals(testUser.getPassword(),userDetails.getPassword());
        Assertions.assertEquals(2,userDetails.getAuthorities().size());
        Assertions.assertTrue(containsAuthority(userDetails,"ROLE_"+UserRoleEnum.ADMIN),
                "The user is not admin.");
        Assertions.assertTrue(containsAuthority(userDetails,"ROLE_"+UserRoleEnum.USER),
                "The user is not user.");

    }

    private boolean containsAuthority(UserDetails userDetails,String expectedAuthority){
        return userDetails
                .getAuthorities()
                .stream()
                .anyMatch(a -> expectedAuthority.equals(a.getAuthority()));
    }

    private static UserEntity createTestUser() {
        return new UserEntity()
                .setFirstName("firstName")
                .setLastName("lastName")
                .setEmail("test@email.com")
                .setPassword("topsecret")
                .setActive(false)
                .setRoles(List.of(
                        new UserRoleEntity().setRole(UserRoleEnum.ADMIN),
                        new UserRoleEntity().setRole(UserRoleEnum.USER)
                ));
    }
}
