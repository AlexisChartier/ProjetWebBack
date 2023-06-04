package com.api.back.apiwebproject.service;

import com.api.back.apiwebproject.exception.MagasinNotFoundException;
import com.api.back.apiwebproject.model.Magasin;
import com.api.back.apiwebproject.repo.MagasinRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MagasinService {

    private final MagasinRepo magasinRepo;

    @Autowired
    public MagasinService(MagasinRepo magasinRepo) {
        this.magasinRepo = magasinRepo;
    }

    public Magasin addMagasin(Magasin magasin){
        return magasinRepo.save(magasin);
    }

    public List<Magasin> findAllMagasin(){
        return magasinRepo.findAll();
    }

    public Magasin findMagasinById(Long id){
        return magasinRepo.findById(id).orElseThrow(() -> new MagasinNotFoundException("Magasin d'id " + id + " n'a pas été trouvé"));
    }

    public Magasin updateMagasin(Magasin magasin){
        return magasinRepo.save(magasin);
    }

    public void deleteMagasinById(Long id) throws MagasinNotFoundException{
        try{
            magasinRepo.deleteById(id);
        }
        catch (MagasinNotFoundException magasinNotFoundException){
            throw new MagasinNotFoundException("Magasin d'id " + id + " n'existe pas et ne peut être supprimé");
        }
    }

    public List<Magasin> getAll() {
        return magasinRepo.findAll();
    }
}
