package project_management.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project_management.security.model.Tarea;
import project_management.security.service.TareaService;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @GetMapping
    public List<Tarea> getAllTareas() {
        return tareaService.getAllTareas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarea> getTareaById(@PathVariable Long id) {
        Tarea tarea = tareaService.getTareaById(id).orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
        return ResponseEntity.ok(tarea);
    }

    @PostMapping
    public Tarea createTarea(@RequestBody Tarea tarea) {
        return tareaService.saveTarea(tarea);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarea> updateTarea(@PathVariable Long id, @RequestBody Tarea tareaDetails) {
        Tarea updatedTarea = tareaService.updateTarea(id, tareaDetails);
        return ResponseEntity.ok(updatedTarea);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTarea(@PathVariable Long id) {
        tareaService.deleteTarea(id);
        return ResponseEntity.noContent().build();
    }
}
