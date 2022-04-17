package com.cg.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
import com.cg.demo.dao.PostNotFoundException;
import com.cg.demo.entities.Post;
import com.cg.demo.service.PostServiceI;

@RestController
@RequestMapping(value="post")

//Connecting ... to Angular 
@CrossOrigin("http://localhost:4200")

public class PostController {
	@Autowired
    private PostServiceI service;
	
	
	@PostMapping(path="/create")
	public ResponseEntity<Boolean> CreatePost(@RequestBody Post p) {
		service.CreatePost(p);
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		System.out.println("response entity=" + responseEntity);
		return responseEntity;
	}
	
//	@GetMapping(path="/getdetails/{ }")
//	public ResponseEntity<Post> findPostById(@PathVariable("postId") long postId) {
//		Post p=service.findPostById(postId);
//		if (p == null) {
//            throw new PostNotFoundException("post not found for id=" + postId);
//        }
//		return new ResponseEntity<Post>(p,new HttpHeaders(),HttpStatus.OK);
//	}
	
	@GetMapping(path="/getAll")
	public  ResponseEntity<List<Post>> findAll(){
		List<Post> list=service.findAllPosts();
		
		return new ResponseEntity<List<Post>>(list,new HttpHeaders(),HttpStatus.OK);
	}
	
	@PutMapping(path="/update")
	public ResponseEntity<Post> updateEmployee(@RequestBody Post p){
		p=service.updatePost(p);
		return new ResponseEntity<Post>(p,new HttpHeaders(),HttpStatus.OK);
	}
	
	@DeleteMapping(path="/delete/{postId}")
	public String deletePost(@PathVariable("postId") Long postId) {
		service.deletePost(postId);
		return "Deleted";
	}
}
