package com.example.cliente.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cliente.models.ClienteModel;
import com.example.cliente.repositories.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository repository;

    //CRUD

    public ClienteModel saveCliente(ClienteModel cliente){
        if(repository.findClienteModelByPhone(cliente.getPhone()).toString().equals("Optional[[]]")){
            return repository.save(cliente);
        }else{
            ClienteModel clienteError = new ClienteModel();
                clienteError.setId(-1L);
            return clienteError;
        }
    }

    public ArrayList<ClienteModel> getAllClientes(){
        return (ArrayList<ClienteModel>) repository.findAll();
    }

    public Optional<ClienteModel> findClienteById(Long id){
        return repository.findById(id);
    }

    public Optional<ArrayList<ClienteModel>> findClienteByOwnername(String ownername){
        return repository.findClienteModelByOwnername(ownername);
    }

    public ClienteModel editCliente(ClienteModel cliente){
        return repository.save(cliente);

    }

    public String deleteClienteById(Long id){
        if(findClienteById(id).isPresent()){
            repository.deleteById(id);
            return "cliente eliminado correctamente";
        }else{
            return "cliente con el id="+ id+ "no encontrado";
        }
    }

    public Optional<ArrayList<ClienteModel>> findClienteByPhone(String phone){
        return repository.findClienteModelByPhone(phone);
    }
}
