package org.uv.Examen1Daniel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/grupos")
public class GrupoController {
    
    @Autowired
    private grupoRepository GrupoRepository;
    
    @GetMapping
    public List<Grupo> obtenerGrupos() {
        return GrupoRepository.findAll();
    }
    
    @PostMapping
    public Grupo crearGrupo(@RequestBody Grupo grupo) {
        String id = grupo.getId();
        Long materia = grupo.getMateria();
        Long alumno = grupo.getAlumno();
        String grupoNombre = grupo.getNombreGrupo();

        // Asignar los objetos Materia y Alumno al nuevo grupo

        Grupo grup = new Grupo(id,materia,alumno,grupoNombre);
        return GrupoRepository.save(grup);
    }
    
    @GetMapping("/{id}")
    public Grupo obtenerGrupoPorId(@PathVariable Long id) {
        return GrupoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de grupo inválido: " + id));
    }
    
    @PutMapping("/{id}")
    public Grupo actualizarGrupo(@PathVariable Long id, @RequestBody Grupo grupoActualizado) {
        return GrupoRepository.findById(id)
                .map(grupo -> {
                    grupo.setNombreGrupo(grupoActualizado.getNombreGrupo());
                    // Actualizar otros campos según sea necesario
                    return GrupoRepository.save(grupo);
                })
                .orElseThrow(() -> new IllegalArgumentException("ID de grupo inválido: " + id));
    }
    
    @DeleteMapping("/{id}")
    public void eliminarGrupo(@PathVariable Long id) {
        GrupoRepository.deleteById(id);
    }

    // Métodos para obtener, actualizar y eliminar un grupo por su ID
}
