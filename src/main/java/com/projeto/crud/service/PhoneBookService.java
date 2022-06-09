package com.projeto.crud.service;

import com.projeto.crud.model.PhoneBook;
import com.projeto.crud.repositories.PhoneBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneBookService {

    // injeÃ§Ã£o de dependencia
    @Autowired
    private PhoneBookRepository phoneBookRepository;

    //constructor
    public PhoneBookService(PhoneBookRepository phoneBookRepository) {
        this.phoneBookRepository = phoneBookRepository;
    }

    // metodos
    //mÃ©todo listar todos os dados
    public Iterable<PhoneBook> getPhoneBooks() {
        return phoneBookRepository.findAll();
    }

    // criar dados na tabela
    public PhoneBook create(PhoneBook phoneBook) {
        return phoneBookRepository.save(phoneBook);
    }

    // deletar por ID
    public PhoneBook delete(Long id){
        PhoneBook phoneBook2 = phoneBookRepository.findById(id).orElseThrow(() -> {
            return new RuntimeException("cadastro nÃ£o existe com esse id: " + id);
        });
        phoneBookRepository.delete(phoneBook2);
        return phoneBook2;
    }

    //buscar o item por ID
    public PhoneBook getPhone(Long id){
        return phoneBookRepository.findById(id).orElseThrow(() -> {
            return new RuntimeException("cadastro nÃ£o existe com esse id: " + id);
        });
    }
    public PhoneBook update(Long id, PhoneBook phoneBook1) {
        //buscar um item do banco de dados para alterar
        PhoneBook phoneBook2 = phoneBookRepository.findById(id).orElseThrow(() -> {
            return new RuntimeException("cadastro nÃ£o existe com esse id: " + id);
        });

        // comando de alteraÃ§Ã£o de dados para sobescrever o PhoneBook para phoneBook2
        phoneBook2.setName(phoneBook1.getName());
        phoneBook2.setAddress(phoneBook1.getAddress());
        phoneBook2.setPhone(phoneBook1.getPhone());
        phoneBook2.setEmail(phoneBook1.getEmail());
        phoneBook2.setComments(phoneBook1.getComments());
        phoneBook2.setOperators(phoneBook1.getOperators());
        return phoneBookRepository.save(phoneBook2); //salvar os dados alterados no banco
    }

}

