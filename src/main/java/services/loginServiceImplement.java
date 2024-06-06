package services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

//AQUI IMPLEMENTAMOS LA INTERFACE QUE HICIMOS
public class loginServiceImplement implements LoginService {
    @Override
    public Optional<String>getUserName(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if(username != null) {
            return Optional.of(username);
        }
        return Optional.empty();
    }
}
