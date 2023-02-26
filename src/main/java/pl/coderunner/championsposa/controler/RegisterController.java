package pl.coderunner.championsposa.controler;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderunner.championsposa.domain.Register;
import pl.coderunner.championsposa.service.RegisterService;
import pl.coderunner.championsposa.service.dto.RegisterDto;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RegisterController {
    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }
    @PostMapping("/register")
    public Register saveRegister(@RequestBody List<RegisterDto> registerDto){
        Register newRegister;
        newRegister=registerService.saveRegister(registerDto);
        return newRegister;
    }
}
