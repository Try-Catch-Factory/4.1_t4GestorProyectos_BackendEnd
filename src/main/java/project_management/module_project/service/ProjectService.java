package project_management.module_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project_management.module_project.model.Project;
import project_management.module_project.repository.ProjectRepository;

@Service
public class ProjectService {
    @Autowired(required=true)
    private ProjectRepository projectRepository;

    public List<Project> findAllProjects(){
        return projectRepository.findAll();
    }

    public Optional<Project> findProjectById(int id){
        return projectRepository.findById((long) id);
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(int id, Project projectDetails) {
        Optional<Project> optionalProject = projectRepository.findById((long) id);

        if (optionalProject.isPresent()) {
            Project existingProject = optionalProject.get();
            existingProject.setName(projectDetails.getName());
            existingProject.setDescription(projectDetails.getDescription());
            existingProject.setStatus(projectDetails.getStatus());
            return projectRepository.save(existingProject);
        }else {
            throw new RuntimeException("Project not found with id "+ id);
        }
    }

    public String deleteProject(int id) {
        projectRepository.deleteById((long) id);
        return ("Proyecto Borrado " + id);
    }


}
