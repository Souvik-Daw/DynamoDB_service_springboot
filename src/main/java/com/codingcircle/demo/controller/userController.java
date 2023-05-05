package com.codingcircle.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.codingcircle.demo.dao.userDao;
import com.codingcircle.demo.entity.user;

import java.util.List;

@RestController
@RequestMapping("/login")
public class userController {

	@Autowired
    private userDao userDao;

	//save the data
    @PostMapping
    public user save(@RequestBody user person){
        return userDao.save(person);
    }

    //get data by id
    @GetMapping("get/{id}")
    public user findById(@PathVariable(value = "id") String id){
        return userDao.findById(id);
    }

    //get all data
    @GetMapping
    public List<user> findAll(){
        return userDao.findAll();
    }

    //update data by id
    @GetMapping("update/{id}")
    public String update(@PathVariable(value = "id") String id,
    @RequestBody user person){
        return userDao.update(id, person);
    }

    //delete data by id 
    @GetMapping("delete/{id}")
    public String delete(@PathVariable(value = "id") String id){
        return userDao.delete(id);
    }
	
}
