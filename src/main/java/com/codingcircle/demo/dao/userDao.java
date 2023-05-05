package com.codingcircle.demo.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.codingcircle.demo.entity.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class userDao {
	
	@Autowired
    private DynamoDBMapper dynamoDBMapper;

    public user save(user person){
        dynamoDBMapper.save(person);
        return person;
    }

    public user findById(String id){
       return dynamoDBMapper.load(user.class, id);
    }

    public List<user> findAll(){
        return dynamoDBMapper.scan(user.class, new DynamoDBScanExpression());
    }

    public String update(String id, user person){
        dynamoDBMapper.save(person,
                new DynamoDBSaveExpression()
        .withExpectedEntry("id",
                new ExpectedAttributeValue(
                        new AttributeValue().withS(id)
                )));
        return id;
    }

    public String delete(String id){
    	user person = dynamoDBMapper.load(user.class, id);
        dynamoDBMapper.delete(person);
        return "Person deleted successfully:: "+id;
    }

}
