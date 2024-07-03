package com.gof.gof.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gof.gof.model.Cliente;
import com.gof.gof.model.ClienteRepository;
import com.gof.gof.model.Endereco;
import com.gof.gof.model.EnderecoRepository;
import com.gof.gof.services.ClienteService;
import com.gof.gof.services.ViaCepService;


@Service
class ClienteServiceImpl implements ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Cliente buscarPorId(Long id) {
        // TODO Auto-generated method stub
        Optional <Cliente> cliente = clienteRepository.findById(id);

        return cliente.get();
    }
    
    @Override
    public void inserir(Cliente cliente) {
        // TODO Auto-generated method stub
        String cep = cliente.getEndereco().getCep();
        System.out.println(cep);
        Endereco endereco  = enderecoRepository.findById(cep).orElseGet(() -> {

           Endereco novoEndereco =  viaCepService.consultarCep(cep);
           enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });

        cliente.setEndereco(endereco);

        clienteRepository.save(cliente);
        
        
    }

    @Override
    public Iterable<Cliente> buscarTodos() {
        
        return clienteRepository.findAll();
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        // TODO Auto-generated method stub

        Optional <Cliente> clienteBd = clienteRepository.findById(id);
        
        
        if (clienteBd.isPresent()) {
            
                String cep = cliente.getEndereco().getCep();
                Endereco endereco  = enderecoRepository.findById(cep).orElseGet(() -> {

                Endereco novoEndereco =  viaCepService.consultarCep(cep);
                enderecoRepository.save(novoEndereco);
                    return novoEndereco;
                });

                cliente.setEndereco(endereco);

                clienteRepository.save(cliente);
        
        }

    }

    @Override
    public void deletar(Long id) {
        // TODO Auto-generated method st

        clienteRepository.deleteById(id);
        
    }
}