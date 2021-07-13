package com.john.todonovo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.john.todonovo.domain.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

	@Query("Select t FROM Todo t where t.finalizado = false order by t.dataParaFinalizar")
	List<Todo> findAllOpen();

	@Query("Select t from Todo t where t.finalizado = true order by t.dataParaFinalizar")
	List<Todo> findAllClose();
	

}
