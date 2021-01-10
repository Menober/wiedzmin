package com.heroku.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OptionRepository extends CrudRepository<Option, String> {

    List<Option> findAll();

    Optional<Option> findByOwner(String owner);
}
