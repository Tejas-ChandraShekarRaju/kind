package com.kind.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kind.dao.DataAccess;
import com.kind.dao.UserRepository;
import com.kind.model.User;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController // This means that this class is a Controller
@RequestMapping("/demo") // This means URL's start with /demo (after Application path)
public class MainController {
  @Autowired // This means to get the bean called userRepository
         // Which is auto-generated by Spring, we will use it to handle the data
  private UserRepository userRepository;
  
  @Autowired
  private DataAccess data;

  @PostMapping(path="/add") // Map ONLY POST Requests
  public @ResponseBody String addNewUser (@RequestParam String name
      , @RequestParam int marks) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    User n = new User();
    n.setName(name);
    n.setMarks(marks);
    userRepository.save(n);
    return "Saved";
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<User> getAllUsers() {
    // This returns a JSON or XML with the users
    return userRepository.findAll();
  }
  
  @GetMapping(path="/marks")
  public @ResponseBody int getMarksByUser(@RequestParam String name) {
    // This returns a JSON or XML with the users
    return data.findUserMarks(name);
  }
  
  @PostMapping(path="/addUpdate")
  public @ResponseBody int addUpdateUserDetails(@RequestParam String user,@RequestParam int marks) {
	  return data.addUser(user,marks);
  }
  
  
}