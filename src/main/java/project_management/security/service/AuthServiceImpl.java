package project_management.security.service;

import project_management.security.dto.SingupRequest;
import project_management.security.enums.UserRole;
import project_management.security.repository.UsuarioRepository;
import project_management.security.model.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService{

    private final UsuarioRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthServiceImpl(UsuarioRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    @Override
    public Usuario createUser(SingupRequest singupRequest) {
        Usuario user = new Usuario();

        user.setEmail(singupRequest.getEmail());
        user.setName(singupRequest.getName());
        user.setPassword(new BCryptPasswordEncoder().encode(singupRequest.getPassword()));

        if (singupRequest.getRole().equals("ADMIN")){
            user.setRole(UserRole.ADMIN);
        }else {
            user.setRole(UserRole.USER);
        }
        userRepository.save(user);

        return user;
    }
    @Override
    public Boolean hasUserWithEmail(String email) {
        return userRepository.findFirstByEmail(email).isPresent();
    }

    @Override
    public Optional<Usuario> findByEmailLogin(String email) {
        return userRepository.findByEmail(email);
    }
}
