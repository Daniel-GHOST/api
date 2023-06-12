/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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



@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class controller {

    @Autowired
    private RepositoryAlumno repositoryEmpleado;

    @GetMapping("/msg")
    public String holamundo(){
        return "Hola mundo";
    }
    
    @GetMapping("/{id}")
    public Alumno obtenerEmpleado(@PathVariable("id") long id) {
        Optional<Alumno> optionalEmpleado = repositoryEmpleado.findById(id);
        if (optionalEmpleado.isPresent()) {
            Alumno empleado = optionalEmpleado.get();
            return empleado;
        } else {
            return null;
        }
    }

    @GetMapping
    public List<Alumno> obtenerTodosLosEmpleados() {
        List<Alumno> empleados = (List<Alumno>) repositoryEmpleado.findAll();

        return empleados;
    }

    @PostMapping
    public Alumno crearEmpleado(@RequestBody DTOAlumno empleadoDTO) {
        Alumno empleado = new Alumno();
        empleado.setNombre(empleadoDTO.getNombre());
        empleado.setDireccion(empleadoDTO.getDireccion());
        empleado.setTelefono(empleadoDTO.getTelefono());

        Alumno empleadoNuevo = repositoryEmpleado.save(empleado);

        return empleadoNuevo;
    }

    @PutMapping("/{id}")
    public Alumno actualizarEmpleado(@PathVariable("id") Long id, @RequestBody DTOAlumno empleadoDTO) {
        Optional<Alumno> optionalEmpleado = repositoryEmpleado.findById(id);
        if (optionalEmpleado.isPresent()) {
            Alumno empleado = optionalEmpleado.get();
            empleado.setNombre(empleadoDTO.getNombre());
            empleado.setDireccion(empleadoDTO.getDireccion());
            empleado.setTelefono(empleadoDTO.getTelefono());

            Alumno empleadoActualizado = repositoryEmpleado.save(empleado);

            return empleadoActualizado;
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void eliminarEmpleado(@PathVariable("id") Long id) {
        repositoryEmpleado.deleteById(id);
    }
    
}
