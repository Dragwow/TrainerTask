package com.yumimi.controller;

import com.yumimi.db.request.UserRequest;
import com.yumimi.db.response.ResponseContainer;
import com.yumimi.db.response.UserResponse;
import com.yumimi.facade.UserFacade;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private final UserFacade userFacade;

    @PostMapping
    public ResponseEntity<ResponseContainer<UserResponse>> create(
        @RequestBody
        UserRequest request) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(new ResponseContainer<>(userFacade.createUser(request)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseContainer<UserResponse>> update(
        @PathVariable
        Long id,
        @RequestBody
        UserRequest request) {
        return ResponseEntity
            .ok(new ResponseContainer<>(userFacade.updateUser(id, request)));
    }

    @DeleteMapping("/{id}")
    public void update(
        @PathVariable
        Long id) {
        userFacade.deleteUser(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseContainer<UserResponse>> getUser(
        @PathVariable
        Long id){
        return ResponseEntity.ok(new ResponseContainer<>(userFacade.getUserById(id)));
    }

    @GetMapping
    public List<UserResponse> getAll(){
        return userFacade.getAllUsers();
    }

}
