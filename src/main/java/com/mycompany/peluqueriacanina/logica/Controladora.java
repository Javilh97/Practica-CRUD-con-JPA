
package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;

public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMasco, String raza, String color, 
            String observaciones, String alergico, String atenEsp, 
            String nombreDuenio, String celDuenio) {
        
        //Creamos dueño y asignamos sus valores
        Duenio duenio = new Duenio();
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(celDuenio);
         
        //Creamos mascota y asignamos sus calores
        Mascota mascota = new Mascota();
        mascota.setNombreMascota(nombreMasco);
        mascota.setRaza(raza);
        mascota.setColor(color);
        mascota.setObservaciones(observaciones);
        mascota.setAlergico(alergico);
        mascota.setAtencionEspecial(atenEsp);
        mascota.setUnDuenio(duenio);
        
        controlPersis.guardar(duenio, mascota);
    }
    
}
