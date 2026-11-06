package com.mycompany.peluqueriacanina.persistencia;

import com.mycompany.peluqueriacanina.logica.Duenio;
import com.mycompany.peluqueriacanina.logica.Mascota;
import com.mycompany.peluqueriacanina.persistencia.exceptions.NonexistentEntityException;
import java.util.List;

public class ControladorPersistencia {
    
    DuenioJpaController duenioJpa = new DuenioJpaController();
    MascotaJpaController mascotaJpa = new MascotaJpaController();

    public void guardar(Duenio duenio, Mascota mascota) {
        
        duenioJpa.create(duenio);
        
        mascotaJpa.create(mascota);
        
    }

    public List<Mascota> traerMascotas() {
        
        return mascotaJpa.findMascotaEntities();
                
    }

    public void borrarMascotas(int numCliente) {
        try {
            mascotaJpa.destroy(numCliente);
        } catch (NonexistentEntityException ex) {
            System.getLogger(ControladorPersistencia.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public Mascota traerMascota(int numCliente) {
        
        return mascotaJpa.findMascota(numCliente);
        
    }

    public void modificarMascota(Mascota mascota) {
        try {
            mascotaJpa.edit(mascota);
        } catch (Exception ex) {
            System.getLogger(ControladorPersistencia.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public Duenio traerDuenio(int idDuenio) {
        return duenioJpa.findDuenio(idDuenio);
    }

    public void modificarDuenio(Duenio duenio) {
        try {
            duenioJpa.edit(duenio);
        } catch (Exception ex) {
            System.getLogger(ControladorPersistencia.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
}
