package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladorPersistencia;
import java.util.List;

public class ControladorLogica {
    
    ControladorPersistencia controlPersis = new ControladorPersistencia();

    public void guardar(String nombre, String raza, String color, String nombreDuenio, String celDuenio, String observaciones, String alergico, String atEspecial) {
        
        Duenio duenio = new Duenio();
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(celDuenio);
        
        Mascota mascota = new Mascota();
        mascota.setNombre(nombre);
        mascota.setRaza(raza);
        mascota.setColor(color);
        mascota.setObservaciones(observaciones);
        mascota.setAlergico(alergico);
        mascota.setAtencionEspecial(atEspecial);
        mascota.setDuenio(duenio);
        
        controlPersis.guardar(duenio, mascota);
    }

    public List<Mascota> traerMascotas() {
        
        return controlPersis.traerMascotas();
        
    }

    public void borrarMascota(int numCliente) {
        
        controlPersis.borrarMascotas(numCliente);
        
    }      

    public Mascota traerMascota(int numCliente) {
        
        return controlPersis.traerMascota(numCliente);
        
    }

    public void modificarMascota(Mascota mascota, String nombre, String raza, String color, String observaciones, String alergico, String atEspecial, String nombreDuenio, String celDuenio) {
        
        mascota.setNombre(nombre);
        mascota.setRaza(raza);
        mascota.setColor(color);
        mascota.setObservaciones(observaciones);
        mascota.setAlergico(alergico);
        mascota.setAtencionEspecial(atEspecial);
        
        //modifico mascota
        controlPersis.modificarMascota(mascota);
        
        //seteo nuevos valores del duenio
        Duenio duenio = this.buscarDuenio(mascota.getDuenio().getIdDuenio());
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(celDuenio);
        
        //llamar al modificar Duenio
        this.modificarDuenio(duenio);
        
    }

    private Duenio buscarDuenio(int idDuenio) {
        return controlPersis.traerDuenio(idDuenio);
    }

    private void modificarDuenio(Duenio duenio) {
        controlPersis.modificarDuenio(duenio);
    }
}
