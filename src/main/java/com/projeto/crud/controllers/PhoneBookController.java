package com.projeto.crud.controllers;

import com.projeto.crud.model.PhoneBook;
import com.projeto.crud.service.PhoneBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4400")
@RestController
@RequestMapping("/sistemas")
public class PhoneBookController {


    // injeção de dependencia
    @Autowired
    private final PhoneBookService phoneBookService;

    // construtor
    public PhoneBookController(PhoneBookService phoneBookService) {
        this.phoneBookService = phoneBookService;

    }

    // Esses metodos chamam as informações da classe PhoneBookService
    @GetMapping("/phones")
    public ResponseEntity<Iterable<PhoneBook>> getPhoneBooks(){
        return ResponseEntity.ok(phoneBookService.getPhoneBooks());
    }

    @PostMapping("/phones")
    public ResponseEntity<PhoneBook> create(@RequestBody @Valid PhoneBook phoneBook){
        return ResponseEntity.status(HttpStatus.CREATED).body(phoneBookService.create(phoneBook));
    }

    @DeleteMapping("/phones/{id}")
    public ResponseEntity<PhoneBook> delete(@PathVariable Long id) {
        return ResponseEntity.ok(phoneBookService.delete(id));
    }

    @GetMapping("/phones/{id}")
    public ResponseEntity<PhoneBook> getPhoneBook(@PathVariable Long id) {
        return ResponseEntity.ok(phoneBookService.getPhone(id));
    }

    @PutMapping("/phones/{id}")
    public ResponseEntity<PhoneBook> update(@PathVariable Long id, @RequestBody @Valid PhoneBook phoneBook) {
        return ResponseEntity.ok(phoneBookService.update(id, phoneBook));
    }

}



