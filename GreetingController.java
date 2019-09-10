package hello;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    private static int idCount = 0;
    private Map<Integer ,DataObject> records = new HashMap<>();

    @PostMapping("/todo")
    public ResponseEntity<Object> recordData(@RequestBody DataObject o){
        o.setId(++idCount);
        records.put(o.getId(),o);
        System.out.println(o.getName());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/todo")
    public Map<Integer, DataObject> getdata(){
        return records;
    }



    @DeleteMapping("/todo")
    public Map<Integer,DataObject> deleteData(@RequestBody DataObject o){
        System.out.println(o.getName());
        records.remove(o.getId());
        return records;
    }

    @PutMapping("/todo")
    public Map<Integer,DataObject> updateData(@RequestBody DataObject o){
        records.put(o.getId(), o);
        return records;
    }

}