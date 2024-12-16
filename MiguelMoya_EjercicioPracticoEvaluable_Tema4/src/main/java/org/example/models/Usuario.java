package org.example.models;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Usuario {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    @Getter
    private String correo;
    private String nombre;

    public Usuario() {

    }
    public Usuario(String correo, String nombre) {
        this.correo = correo;
        this.nombre = nombre;
    }

    @OneToMany
    private List<Comentario> comentarios=new ArrayList<>();


    /***
     * Añade un comentario a este usuario
     * @param c comentario para agregar
     */
    public   void añadirComentario(Comentario c){
        comentarios.add(c);
    }
}
