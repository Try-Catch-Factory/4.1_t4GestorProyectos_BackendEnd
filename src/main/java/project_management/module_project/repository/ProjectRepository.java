package project_management.module_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project_management.module_project.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
