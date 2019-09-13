package hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Service {

    private static int idCount = 0;
    private Map<Integer ,DataObject> records = new HashMap<>();


    public ResponseEntity recordData(DataObject o){
        o.setId(++idCount);
        records.put(o.getId(),o);
        System.out.println(o.getName());
        return new ResponseEntity(HttpStatus.OK);
    }

    public Map<Integer, DataObject> getData(){
        return records;
    }

    public Map<Integer, DataObject> deleteData(int id){
        records.remove(id);
        return records;
    }

    public Map<Integer, DataObject> updateData(DataObject o){
        records.put(o.getId(), o);
        return records;
    }
}
