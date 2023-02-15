package com.example.dinnertime.repository;

import com.example.dinnertime.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users,Long> {

    Users findById(long id);

    Users findByUsername(String username);

}

