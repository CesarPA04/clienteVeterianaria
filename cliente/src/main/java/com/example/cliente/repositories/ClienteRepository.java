package com.example.cliente.repositories;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.cliente.models.ClienteModel;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteModel, Long>{
    public Optional<ArrayList<ClienteModel>> findClienteModelByPhone(String phone);
    public Optional<ArrayList<ClienteModel>> findClienteModelByOwnername(String ownername);
}