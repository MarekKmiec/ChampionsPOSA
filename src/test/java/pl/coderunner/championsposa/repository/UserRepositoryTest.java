package pl.coderunner.championsposa.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import pl.coderunner.championsposa.domain.User;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.annotation.DirtiesContext.MethodMode.AFTER_METHOD;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DirtiesContext(methodMode = AFTER_METHOD)
    void shouldSaveUser(){
        //given
        User user=new User();
        user.setUsername("adam@wp.pl");
        user.setPassword("Tajne666!");

        //when
        User saveUser=userRepository.save(user);

        //then
        assertThat(saveUser.getId()).isNotNull();
    }

}