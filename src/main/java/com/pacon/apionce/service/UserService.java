package com.pacon.apionce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pacon.apionce.dto.UserRequest;
import com.pacon.apionce.entity.User;
import com.pacon.apionce.exception.UserNotFoundException;
import com.pacon.apionce.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
    public User getUser(int id) throws UserNotFoundException {
        User user = repository.findByUserId(id);
        if(user!=null){
            return user;
        }else{
            throw new UserNotFoundException("Usuario no encontrado con el id: " + id);
        }
    }
    
    public List<User> getALlUsers() {
        return repository.findAll();
    }
	
	public User saveUser(UserRequest userRequest) {
        User user = User.
                build(0, userRequest.getName(), userRequest.getEmail(),
                        userRequest.getMobile(), userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
        return repository.save(user);
    }
	
	public User updateUser(UserRequest userRequest, int id){
		User user = repository.findByUserId(id);
		User user_req = User.
                build(user.getUserId(), userRequest.getName(), userRequest.getEmail(),
                        userRequest.getMobile(), userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
        return repository.save(user_req);
	}
	
	public User deleteUser(int id){
		
		System.out.print("Usuario borrado con exito!");
		
        return repository.deleteById(id);
	}

}
