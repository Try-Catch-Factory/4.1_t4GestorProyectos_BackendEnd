package project_management.security.repository;

import project_management.security.enums.UserRole;
import project_management.security.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findFirstByEmail(String email);
    Usuario findByRole(UserRole userRole);
    Optional<Usuario> findByEmail(String email);
}