package pl.coderunner.championsposa.service;

import org.springframework.stereotype.Service;
import pl.coderunner.championsposa.domain.Register;
import pl.coderunner.championsposa.repository.CategoryOfAgeRepository;
import pl.coderunner.championsposa.repository.CompetitionRepository;
import pl.coderunner.championsposa.repository.RegisterRepository;
import pl.coderunner.championsposa.repository.UserRepository;
import pl.coderunner.championsposa.service.dto.RegisterDto;

import java.util.UUID;
@Service
public class RegisterService {
    private final RegisterRepository registerRepository;
    private final CompetitionRepository competitionRepository;
    private final CategoryOfAgeRepository categoryOfAgeRepository;
    private final UserRepository userRepository;

    public RegisterService(RegisterRepository registerRepository, CompetitionRepository competitionRepository, CategoryOfAgeRepository categoryOfAgeRepository, UserRepository userRepository) {
        this.registerRepository = registerRepository;
        this.competitionRepository = competitionRepository;
        this.categoryOfAgeRepository = categoryOfAgeRepository;
        this.userRepository = userRepository;
    }

    public Register saveRegister(RegisterDto registerDto){
        String key= UUID.randomUUID().toString();
        Register register=new Register();
        register.setUser(userRepository.findById(registerDto.getUserId()));
        for (int i = 0; i < registerDto.getCompetitionID(); i++) {
            register.setCompetitions(competitionRepository.findById(i));
        }
        for (int i = 0; i < registerDto.getCategoryOfAgeId(); i++) {
            register.setCategoriesOfAge(categoryOfAgeRepository.findById(i));
        }
        register.setKey(key);
        register.setIsPay(false);
        registerRepository.save(register);
        return register;

    }

}
