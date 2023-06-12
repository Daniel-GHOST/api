/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Examen1Daniel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author peter
 */


@Entity
@Table(name = "grupos")
public class Grupo {

    @Id
    @Column(name="id")
    private String id;

   
    @JoinColumn(name = "cvemateria")
    private Long cvemateria;

    
    @JoinColumn(name = "cvealumno")
    private Long cvealumno;
    
    @Column(name="nombreGrupo")
    private String nombreGrupo;
    
    
    public Grupo(String id, Long cvemateria, Long cvealumno, String nombreGrupo) {
        this.id = id;
        this.cvemateria = cvemateria;
        this.cvealumno = cvealumno;
        this.nombreGrupo = nombreGrupo;
    }
    
    public Grupo(){}

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public Long getMateria() {
        return cvemateria;
    }

    public void setMateria(Long cvemateria) {
        this.cvemateria = cvemateria;
    }

    public Long getAlumno() {
        return cvealumno;
    }

    public void setAlumno(Long cvealumno) {
        this.cvealumno = cvealumno;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    
}
