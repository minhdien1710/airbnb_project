package com.controller;

import com.model.Home;
import com.model.User;
import com.security.service.FileService;
import com.security.service.HomeService;
import com.security.service.UserPrincipal;
import com.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/auth/api/homes")
public class HomeController {
    private UserPrincipal getCurrentUser() {
        return (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
    @Autowired
    public HomeService homeService;
    @Autowired
    public FileService fileService;
    @Autowired
    public UserService userService;

    @GetMapping
    public ResponseEntity<?> listHome() {
        List<Home> homes = (List<Home>) homeService.findAll();
        if (homes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(homes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getHome(@PathVariable Long id) {
        Optional<Home> home = homeService.findById(id);
        if (home.isPresent()) {
            return new ResponseEntity<>(home, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<?> createHome(@Valid @RequestBody Home home){
        Long id = getCurrentUser().getId();
        Optional<User> user = userService.findById(id);
        home.setUser(user.get());
        homeService.save(home);
        return new ResponseEntity<>(home,HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<?> updateHome(@PathVariable Long id, @RequestBody Home home){
        Optional<Home> selectedHome = homeService.findById(id);
        if(!selectedHome.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        selectedHome.get().setName(home.getName());
        homeService.save(selectedHome.get());
        return new ResponseEntity<>(selectedHome, HttpStatus.CREATED);
    }

}
