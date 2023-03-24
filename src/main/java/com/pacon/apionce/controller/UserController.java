package com.pacon.apionce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pacon.apionce.dto.UserRequest;
import com.pacon.apionce.entity.User;
import com.pacon.apionce.exception.UserNotFoundException;
import com.pacon.apionce.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UserController {
	
	@Autowired
    private UserService service;

    @PostMapping("/crear")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest){
        return new ResponseEntity<>(service.saveUser(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("/registros")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(service.getALlUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) throws UserNotFoundException {
        return ResponseEntity.ok(service.getUser(id));
    }
    
	@PutMapping(value="actualizar/{id}")
	public ResponseEntity<User> updateUser(@RequestBody @Valid UserRequest userRequest, @PathVariable int id){
		return new ResponseEntity<>(service.updateUser(userRequest, id), HttpStatus.CREATED);
	}
	
	@DeleteMapping(value="borrar/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable int id){
		return new ResponseEntity<>(service.deleteUser(id), HttpStatus.CREATED);
	}

}
