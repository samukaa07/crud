package com.projeto.crud.repositories;

import com.projeto.crud.model.PhoneBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneBookRepository extends CrudRepository<PhoneBook, Long> {

}
