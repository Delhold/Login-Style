package services;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

//OBTENER LOS DATOS DEL USUARIO
public interface LoginService {
    Optional<String> getUserName(HttpServletRequest request);
}
