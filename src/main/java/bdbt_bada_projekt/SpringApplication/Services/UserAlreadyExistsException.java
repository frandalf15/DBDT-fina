package bdbt_bada_projekt.SpringApplication.Services;

public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
