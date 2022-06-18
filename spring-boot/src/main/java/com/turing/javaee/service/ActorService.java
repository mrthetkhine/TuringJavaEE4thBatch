package com.turing.javaee.service;
import java.util.List;
import java.util.Optional;

import com.turing.javaee.model.Actor;

public interface ActorService {
	List<Actor> getAllActor();
	Optional<Actor> getActorById(Long actorId);
	Actor saveActor(Actor actor);
	void deleteActorById(Long actorId);
}
