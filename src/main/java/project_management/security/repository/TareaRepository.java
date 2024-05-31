package project_management.security.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_management.security.model.Tarea;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
}
