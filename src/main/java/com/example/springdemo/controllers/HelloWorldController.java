package com.example.springdemo.controllers;

import com.example.springdemo.dto.DemoRequest;
import com.example.springdemo.dto.GenericResponse;
import com.example.springdemo.model.Demo;
import com.example.springdemo.repository.DemoRepository;
import com.example.springdemo.service.DemoService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.Errors;

import java.util.List;

@RestController
@RequestMapping("/newApp")
public class HelloWorldController {
    @Autowired
    private DemoRepository demoRepository;

    @Autowired
    private DemoService demoService;
    @GetMapping("hello")
    public ResponseEntity<List<Demo>> helloWorld(){
        return demoService.helloWorld();
    }


    @PostMapping("hello")
    public ResponseEntity<Demo> helloWorldPost(@RequestBody Demo request){
        return demoService.helloWorldPost(request);
    }

    @PutMapping("hello")
    public ResponseEntity<GenericResponse> helloWorldUpdate(@RequestBody @Valid DemoRequest request, Errors errors){
        GenericResponse response =null;
        if (errors.hasFieldErrors()){
            FieldError fieldError = errors.getFieldError();
            response = new GenericResponse(fieldError.getDefaultMessage(), "Failed");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

        }
        response = new GenericResponse("Successfully updated", "Success");
        Demo demo = new Demo();
        //demo.setId(1L);
        demo.setName(request.name());
        //demo.setPhone("12345678");

        demoRepository.save(demo);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

@DeleteMapping("hello/{id}")
    public ResponseEntity<?> helloWorldDelete(@PathVariable long id){
        return demoService.helloWorldDelete(id);
    }
}




