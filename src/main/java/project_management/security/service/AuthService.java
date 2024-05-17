package project_management.security.service;

import project_management.security.dto.SingupRequest;
import project_management.security.model.Usuario;
import java.util.Optional;

public interface AuthService {

    Usuario createUser(SingupRequest singupRequest);
    Boolean hasUserWithEmail(String email);

    Optional<Usuario> findByEmailLogin(String email);
}
