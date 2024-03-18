package com.floods.ChatDemo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import java.util.Optional;

import com.floods.ChatDemo.model.User;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test") // Use application-test.properties for test configuration
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenFindByUsername_thenReturnUser() {
        // given
        User user = new User("kurotori", "$2a$10$IvS1v6CWvNMbmzzlnaToFeeyRcxbaRjm3AWvafNnb1Z6PrUuRY.0a", "stphnfld@gmail.com", null); // Replace "encryptedPassword" with the actual password hash
        userRepository.save(user);

        // when
        Optional<User> found = userRepository.findByUsername(user.getUsername());

        // then
        assertThat(found).isPresent();
        assertThat(found.get().getUsername()).isEqualTo(user.getUsername());
    }
}
