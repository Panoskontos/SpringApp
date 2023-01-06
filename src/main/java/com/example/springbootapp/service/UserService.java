package com.example.springbootapp.service;

import com.example.springbootapp.model.User;
import com.example.springbootapp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
//    CRUD
    public User addUser(User user){
        return userRepo.save(user);
    }
    public List<User> getUsers(){
        System.out.println(userRepo);
        return userRepo.findAll();
    }

    public User updateUser(User user){
        return userRepo.save(user);
    }
    public void delUser(Long id){
        userRepo.deleteById(id);
    }
    public Optional<User> findUserById(Long id){
        return userRepo.findById(id);
    }

    public  User updateUserName(Long id, String name){
        User u1 = userRepo.getReferenceById(id);
        u1.setName(name);
        return userRepo.save(u1);
    }

}
