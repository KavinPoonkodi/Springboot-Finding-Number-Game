package com.example.Findingnumbergame;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Repository extends JpaRepository<Firsthelper , Long>{
   
//	@Query("select email from springpro.firsthelper")
//public	List<Firsthelper> findByAll();
//	
}
