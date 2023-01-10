package com.epam.dao;

import com.epam.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepo extends JpaRepository<Library,Integer> {

    List<Library> findByUsername(String username);
}
