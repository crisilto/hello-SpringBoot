package com.crisilto.userapp.users;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Integer> {
    //Método de búsqueda con paginación.
    Page<AppUser> findAll(Pageable pageable);
}
