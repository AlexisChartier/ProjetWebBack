package com.api.back.apiwebproject.controller;

import com.api.back.apiwebproject.model.Client;
import com.api.back.apiwebproject.model.Magasin;
import com.api.back.apiwebproject.service.MagasinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/magasins")
public class MagasinController {
    private final MagasinService magasinService;

    @Autowired
    public MagasinController(MagasinService magasinService) {
        this.magasinService = magasinService;
    }

    @CrossOrigin
    @PostMapping("/post")
    public ResponseEntity<Magasin> addMagasin(@RequestBody Magasin magasin) {
        return new ResponseEntity<>(magasinService.addMagasin(magasin), HttpStatus.CREATED);
    }
    @CrossOrigin
    @GetMapping("/get/{id}")
    public ResponseEntity<Magasin> getMagasin(@PathVariable Long id) {
        Magasin magasin = magasinService.findMagasinById(id);
        return magasin != null ? new ResponseEntity<>(magasin, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @CrossOrigin
    @GetMapping("/get/all")
    public ResponseEntity<List<Magasin>> getAllMagasin(){
        List<Magasin> magasins = magasinService.getAll();
        return magasins != null ? new ResponseEntity<>(magasins, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @CrossOrigin
    @PutMapping("/update")
    public ResponseEntity<Magasin> updateMagasin(@RequestBody Magasin magasin) {
        return new ResponseEntity<>(magasinService.updateMagasin(magasin), HttpStatus.OK);
    }
    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMagasin(@PathVariable Long id) {
        magasinService.deleteMagasinById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
