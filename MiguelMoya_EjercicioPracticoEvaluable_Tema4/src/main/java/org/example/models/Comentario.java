package org.example.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Comentario {
    @Id
    private Long id;

    @Getter
    @Setter
    private String comentario;
    private int valoracion;

    @Override
    public String toString() {
        return "Comentario{" +
                "comentario='" + comentario + '\'' +
                ", valoracion=" + valoracion +
                '}';
    }
}
