package com.example.cliente.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cliente.models.ClienteModel;
import com.example.cliente.services.ClienteService;


@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    ClienteService service;

    @PostMapping()
    public ClienteModel saveCliente(@RequestBody ClienteModel cliente){
        return service.saveCliente(cliente);
    }

    @PutMapping()
    public ClienteModel editCliente(@RequestBody ClienteModel cliente){
        return service.editCliente(cliente);
    }

    @GetMapping()
    public ArrayList<ClienteModel> getAllClientes(){
        return service.getAllClientes();
    }

    @GetMapping("/findClienteById/{cliente}")
    public Optional<ClienteModel> findClienteById(@PathVariable Long id){
        return service.findClienteById(id);
    }

    @GetMapping("/findClienteByOwnername/{ownername}")
    public Optional<ArrayList<ClienteModel>> findClienteByOwnername(@PathVariable String ownername){
        return service.findClienteByOwnername(ownername);
    }

    @GetMapping("/findClienteByPhone/{phone}")
    public Optional<ArrayList<ClienteModel>> findClienteByPhone(@PathVariable String phone){
        return service.findClienteByPhone(phone);
    }

    @DeleteMapping("/delete-cliente-by-id")
    public String deleteClienteById(@RequestParam("id") Long id){
        return service.deleteClienteById(id);
    }
    

}
