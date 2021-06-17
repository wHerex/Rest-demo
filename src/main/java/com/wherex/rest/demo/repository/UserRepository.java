package com.wherex.rest.demo.repository;

import com.wherex.rest.demo.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<History, String> {

    boolean existsByLogin(String login);

    @Modifying
    @Transactional
    @Query("UPDATE History h SET h.counter = (h.counter + 1) WHERE h.login =:login")
    void updateCounterByLogin(@Param("login")String login);
}