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
@RequestMapping("/materias")
public class MateriaController {

    @Autowired
    private materiaRepository MateriaRepository;

    @GetMapping
    public List<Materia> obtenerMaterias() {
        return MateriaRepository.findAll();
    }

    @PostMapping
    public Materia crearMateria(@RequestBody Materia materia) {
        return MateriaRepository.save(materia);
    }

    @GetMapping("/{id}")
    public Materia obtenerMateriaPorId(@PathVariable Long id) {
        return MateriaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de materia inválido: " + id));
    }

    @PutMapping("/{id}")
    public Materia actualizarMateria(@PathVariable Long id, @RequestBody Materia materiaActualizada) {
        return MateriaRepository.findById(id)
                .map(materia -> {
                    materia.setNombre(materiaActualizada.getNombre());
                    materia.setCreditos(materiaActualizada.getCreditos());
                    // Actualizar otros campos según sea necesario
                    return MateriaRepository.save(materia);
                })
                .orElseThrow(() -> new IllegalArgumentException("ID de materia inválido: " + id));
    }

    @DeleteMapping("/{id}")
    public void eliminarMateria(@PathVariable Long id) {
        MateriaRepository.deleteById(id);
    }

}
