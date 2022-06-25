package com.turing.javaee.controller.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turing.javaee.controller.BookController;

import com.turing.javaee.model.Actor;

import com.turing.javaee.service.ActorService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/actors")
@Tag(description = "Actor API", name = "Actor")
public class ActorController {
	
	
	@Autowired
	ActorService actorService;
	
	@Operation(summary = "Get all actor", 
            description = "Fetch the list of actor from database")
	 @ApiResponses(value = { 
	            @ApiResponse(responseCode = "200", 
	                    description = "When sucess it return the list of movie"),
	            @ApiResponse(responseCode = "400", 
	                    description = "Return bad request if parameter is invalid", 
	                    content = { @Content(examples = { @ExampleObject(value = "[]") }) }),
	            @ApiResponse(responseCode = "404", 
	                    description = "Return 404 if there is no resource", 
	                    content = { @Content(examples = { @ExampleObject(value = "") }) }) }) 
	@GetMapping
	List<Actor> getAllActor()
	{
		log.info("get all actor rest api");
		return   this.actorService.getAllActor();
	}
	
	@GetMapping("/{actorId}")
	ResponseEntity<Actor> getActor(@PathVariable Long actorId)
	{
		log.info("get a actor rest api");
		Optional<Actor> actorResult = this.actorService.getActorById(actorId);
		if(actorResult.isPresent())
		{
			return ResponseEntity.ok(actorResult.get());
		}
		else
		{
			return  ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	ResponseEntity<Actor> saveActor(@RequestBody @Valid Actor actor)
	{
		log.info("Actor " +actor);
		Actor newActor = this.actorService.saveActor(actor);
		return  ResponseEntity.status(201).body(newActor);
	}
	
	@PutMapping("/{actorId}")
	ResponseEntity<Actor> updateActor(@PathVariable Long actorId,@RequestBody @Valid Actor actor)
	{
		log.info("Actor " +actor);
		
		if( this.actorService.getActorById(actorId).isPresent())
		{
			actor.setId(actorId);
			Actor newActor = this.actorService.saveActor(actor);
			return  ResponseEntity.ok(newActor);
		}
		else
		{
			return  ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{actorId}")
	ResponseEntity<Actor> deleteActore(@PathVariable Long actorId)
	{
		log.info("delete a actor rest api");
		Optional<Actor> actorResult = this.actorService.getActorById(actorId);
		if(actorResult.isPresent())
		{
			this.actorService.deleteActorById(actorId);
			return ResponseEntity.ok(actorResult.get());
		}
		else
		{
			return  ResponseEntity.notFound().build();
		}
	}
	@PutMapping("/{actorId}/{gender}")
	ResponseEntity<Actor> updateGender(@PathVariable Long actorId,@PathVariable String gender)
	{
		log.info("Update Actor gender " );
		
		if( this.actorService.getActorById(actorId).isPresent())
		{
			
			Optional<Actor> newActor = this.actorService.updateActorGender(actorId, gender);
			return  ResponseEntity.ok(newActor.get());
		}
		else
		{
			return  ResponseEntity.notFound().build();
		}
	}
	
}

