package com.turing.javaee.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.turing.javaee.dao.ActorDao;
import com.turing.javaee.model.Actor;
import com.turing.javaee.model.Gender;
import com.turing.javaee.service.ActorService;

@Service
public class ActorServiceImpl implements ActorService{

	@Autowired
	ActorDao actorDao;
	
	@Override
	public List<Actor> getAllActor() {
		return (List<Actor>)this.actorDao.findAll();
	}

	@Override
	public Optional<Actor> getActorById(Long actorId) {
		return actorDao.findById(actorId);
	}

	@Override
	public Actor saveActor(Actor actor) {
		return actorDao.save(actor);
	}

	@Override
	public void deleteActorById(Long actorId) {
		//actorDao.deleteById(actorId);
		actorDao.deleteById(actorId);
		
	}
	@Transactional
	@Override
	public Optional<Actor> updateActorGender(Long actorId,String gender)
	{
		this.actorDao.updateActorGenderById(actorId, Gender.valueOf(gender));
		return this.actorDao.findById(actorId);
	}

}
