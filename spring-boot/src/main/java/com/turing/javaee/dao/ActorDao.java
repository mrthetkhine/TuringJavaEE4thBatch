package com.turing.javaee.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.turing.javaee.model.Actor;
import com.turing.javaee.model.Gender;
import com.turing.javaee.model.Movie;

@Repository
public interface ActorDao extends CrudRepository<Actor, Long>{
	@Modifying
	@Query(value="DELETE FROM Actor a WHERE a.id =:id")
	void deleteById(@Param("id")Long id);
	
	@Modifying(flushAutomatically = true,clearAutomatically = true)
	@Query(value="UPDATE Actor a SET a.gender=:gender WHERE a.id =:id")
	void updateActorGenderById(@Param("id")Long id,@Param("gender")Gender gender);
}
