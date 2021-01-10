package com.heroku.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OptionRepository extends JpaRepository<Option, String> {

    List<Option> findAll();

    Optional<Option> findByOwner(String owner);
}
