
package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;

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

    public List<Mascota> traerMascotas() {
        return controlPersis.traerMascotas();
    }

    public void borrarMascotas(int numCliente) {
        controlPersis.borrarMascota(numCliente);
    }

    public Mascota traerMascota(int numCliente) {
        return controlPersis.traerMascota(numCliente);
    }

    public void modificarMascota(Mascota masco, String nombreMasco, String raza,
            String color, String observaciones, String alergico, String atenEsp,
            String nombreDuenio, String celDuenio) {
        
        masco.setNombreMascota(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAlergico(alergico);
        masco.setAtencionEspecial(atenEsp);
        
        //modifico mascota
        controlPersis.modificarMascota(masco);
        //seteo los nuevos valores para el dueño
        Duenio duenio = this.buscarDuenio(masco.getUnDuenio().getId_duenio());
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(celDuenio);
        //llamara  modificar dueño
        this.modificarDuenio(duenio);
        
        
    }

    private Duenio buscarDuenio(int id_duenio) {
        return controlPersis.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio duenio) {
        controlPersis.modificarDuenio(duenio);
    }
    
}
