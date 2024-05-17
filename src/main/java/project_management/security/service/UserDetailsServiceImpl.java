package project_management.security.service;

import project_management.security.model.Usuario;
import project_management.security.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioService;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioService
                .findByEmail(email)
                .orElseThrow(() -> new  UsernameNotFoundException("El usuario no existe" + email));

        return User.withUsername(email)
                .password(usuario.getPassword())
                .roles(usuario.getRole().name())
                .build();
    }
}
