package pl.coderunner.championsposa.exceptions;

public class WrongPassword extends RuntimeException{
    public WrongPassword(String message) {
        super(message);
    }
}
