package hello;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.omg.CORBA.OBJECT_NOT_EXIST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class GreetingController {

@Autowired
    private Service service;

    @PostMapping("/todo")
    public ResponseEntity<Object> recordData(@RequestBody DataObject o){

         service.recordData(o);
         return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/todo")
    public ResponseEntity<Object> getdata() {
        return new ResponseEntity<>(service.getData(),HttpStatus.OK);
    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity<Object> deleteData(@PathVariable("id") int id){
        return new ResponseEntity<>(service.deleteData(id),HttpStatus.OK);
    }

    @PutMapping("/todo")
    public Map<Integer, DataObject> updateData(@RequestBody DataObject o){
        return service.updateData(o);
    }

}