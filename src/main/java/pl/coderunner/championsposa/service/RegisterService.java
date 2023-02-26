package pl.coderunner.championsposa.service;

import org.springframework.stereotype.Service;
import pl.coderunner.championsposa.domain.Register;
import pl.coderunner.championsposa.repository.CategoryOfAgeRepository;
import pl.coderunner.championsposa.repository.CompetitionRepository;
import pl.coderunner.championsposa.repository.RegisterRepository;
import pl.coderunner.championsposa.repository.UserRepository;
import pl.coderunner.championsposa.service.dto.RegisterDto;

import java.util.List;
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

    public Register saveRegister(List<RegisterDto> registerDto) {
        String key = UUID.randomUUID().toString();
        Register register = new Register();
        for (RegisterDto regdto : registerDto) {
            register.setUser(userRepository.findById(regdto.getUserId()));
            register.setCompetition(competitionRepository.findById(regdto.getCompetitionID()));
            register.setCategoryOfAge(categoryOfAgeRepository.findById(regdto.getCategoryOfAgeId()));
        }
        register.setRegisterKey(key);
        register.setIsPay(false);
        registerRepository.save(register);

//        Register register = new Register();
//        register.setUser(userRepository.findById(registerDto.getUserId()));
//        register.setCompetition(competitionRepository.findById(registerDto.getCompetitionID()));
//        register.setCategoryOfAge(categoryOfAgeRepository.findById(registerDto.getCategoryOfAgeId()));
//        register.setKey(key);
//        register.setIsPay(false);
//        registerRepository.save(register);
        return register;

    }

    public Register activeRegister(String registerKey){
        Register register= registerRepository.findByRegisterKey(registerKey);
        register.setIsPay(true);
        register.setRegisterKey(null);
        return register;

    }

}
