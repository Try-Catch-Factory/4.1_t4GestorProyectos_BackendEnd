package project_management.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project_management.security.model.Tarea;
import project_management.security.repository.TareaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    public List<Tarea> getAllTareas() {
        return tareaRepository.findAll();
    }

    public Optional<Tarea> getTareaById(Long id) {
        return tareaRepository.findById(id);
    }

    public Tarea saveTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public void deleteTarea(Long id) {
        tareaRepository.deleteById(id);
    }

    public Tarea updateTarea(Long id, Tarea tareaDetails) {
        Tarea tarea = tareaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
        tarea.setNombre(tareaDetails.getNombre());
        tarea.setDescripcion(tareaDetails.getDescripcion());
        tarea.setEstado(tareaDetails.getEstado());
        tarea.setFechaInicio(tareaDetails.getFechaInicio());
        tarea.setFechaFinPrevista(tareaDetails.getFechaFinPrevista());
        tarea.setPrioridad(tareaDetails.getPrioridad());
        return tareaRepository.save(tarea);
    }
}
