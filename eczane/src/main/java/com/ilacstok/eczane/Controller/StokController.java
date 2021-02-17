package com.ilacstok.eczane.Controller;

import com.ilacstok.eczane.Domain.StokDO;
import com.ilacstok.eczane.Dto.StokDTO;
import com.ilacstok.eczane.Service.StokService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@RequestMapping("/api/v1")

public class StokController {
    @Autowired
    private StokService stokservice;
    @ApiOperation(value = "Creates new Stok")
    @PostMapping(path = "/stok", consumes = "application/json", produces = "application/json")
    public ResponseEntity<StokDO> createStok(@RequestBody StokDO stokDO) {
        StokDO createdStok = stokservice.createStok(stokDO);
        return new ResponseEntity<>(createdStok, HttpStatus.CREATED);
    }
    @ApiOperation(value = "Updates an existing Stok")
    @PutMapping(path = "/stok", consumes = "application/json", produces = "application/json")
    public ResponseEntity<StokDTO> updateStok(@RequestBody StokDO stokDO) {
        StokDTO updatedStok = stokservice.updateStok(stokDO);
        return new ResponseEntity<>(updatedStok, HttpStatus.CREATED);
    }
    @ApiOperation(value = "Gets Stok by id")
    @GetMapping(path = "/Stok/{StokId}")
    public ResponseEntity<StokDO> getStok(@PathVariable(value = "StokId") Long StokId) {
        StokDO stok = stokservice.getStok(StokId);
        return new ResponseEntity<>(stok, HttpStatus.OK);
    }

    @ApiOperation(value = "Gets Stok by name")
    @GetMapping(path = "/stok-by-name/{stokName}")
    public ResponseEntity<StokDO> getStok(@PathVariable(value = "stokName") String StokName) {
        StokDO stok = stokservice.getStok(StokName);
        return new ResponseEntity<>(stok, HttpStatus.OK);
    }

    @ApiOperation(value = "Gets all stok")
    @GetMapping(path = "/stok")
    public ResponseEntity<List<StokDO>> getAllStok() {
        List<StokDO> allStok = stokservice.getAllStok();
        return new ResponseEntity<>(allStok, HttpStatus.OK);
    }

    @ApiOperation(value = "Deletes Stok by id")
    @DeleteMapping(path = "/stok/{stokId}")
    public ResponseEntity<String> deleteStok(@PathVariable(value = "stokId") Long stokId) {
        stokservice.deleteStok(stokId);
        return new ResponseEntity<>("Stok with id: " + stokId + " is deleted.", HttpStatus.OK);
    }



}
