package org.example;


import org.example.models.Comentario;
import org.example.models.Usuario;
import org.example.services.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Service s = new Service(ObjectDBUtil.getEntityManagerFactory());
        Scanner sc=new Scanner(System.in);

        System.out.println("¿Que quieres hacer? Escribe un numero\n" +
                "-Crear un nuevo usuario (1)\n" +
                "-Listar los mejores Comentarios (2)\n" +
                "-Añadir comentario a la plataforma (3)" +
                "Eliminar Usuario (4)");
        Usuario user=null;
        switch (sc.nextInt()){
            case 1:
                sc.nextLine();
                System.out.println("Escribe el correo del usuario");
                String correo=sc.nextLine();
                System.out.println("Escribe el nombre del usuario");
                String nombre=sc.nextLine();
                user= new Usuario(correo,nombre);
                s.save(user);
                break;

            case 2:
                System.out.println("Escribe la valroacion:");
                List<Comentario> comentarios=new ArrayList<>();
                comentarios=s.getMejoresComentarios(sc.nextInt());
                System.out.println(comentarios);
                break;
            case 3:
                sc.nextLine();
                System.out.println("Escribe un comentario:");
                String comentario=sc.nextLine();
                Comentario c=new Comentario();
                s.save(c);
                c.setComentario(comentario);

                System.out.println("Que usuario comentara este comentario, escfribe su correo");
                user=s.getUsuario(sc.nextLine());
                user.añadirComentario(c);

                //Aqui deberiamos actualzar el usuario, no me da tiempo
                break;
            case 4:
                sc.nextLine();
                System.out.println("Escribe el correo del usuario que deses eliminar:");
                String co=sc.nextLine();
                user=s.getUsuario(co);
                s.delete(user);
                System.out.println("Usuario eliminado correctamente");

                break;

            default:
                System.out.println("No has introducido un numero del 1 al 4");

        }

        sc.close();
    }
}
