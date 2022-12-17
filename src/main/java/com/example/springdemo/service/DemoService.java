package com.example.springdemo.service;

import com.example.springdemo.model.Demo;
import com.example.springdemo.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {
@Autowired
private DemoRepository demoRepository;

    //getting all by using findAll() method of CrudRepository
    public ResponseEntity<List<Demo>> helloWorld(){
        List<Demo> demoList = demoRepository.findAll();
        return ResponseEntity.status(200).body(demoList);
    }



    //post
    public ResponseEntity<Demo> helloWorldPost( Demo request){
        Demo demo = new Demo();
        demo.setId(request.getId());
        demo.setName(request.getName());
        demo.setPhone(request.getPhone());
        demoRepository.save(demo);
        return ResponseEntity.status(201).body(demo);
    }


    //update
    public ResponseEntity<Demo> helloWorldUpdate( Demo request) {
        Demo demo = new Demo();
        demo.setId(request.getId());
        demo.setName(request.getName());
        demo.setPhone(request.getPhone());
        if (demoRepository.findById(request.getId()) != null) {
            demoRepository.save(demo);
        }

        return ResponseEntity.status(201).body(demo);
    }

    //delete

    public ResponseEntity<?> helloWorldDelete( long id){
        Demo demo = new Demo();
    if (demoRepository.findById(id) !=null){
        demoRepository.deleteById(id);

    }
    return new ResponseEntity<>(null, null, 200);
    }
}
