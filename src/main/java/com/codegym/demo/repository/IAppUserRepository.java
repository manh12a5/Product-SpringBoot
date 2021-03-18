package com.codegym.demo.repository;

import com.codegym.demo.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findAppUserByName(String name);

}
