package hello;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.xml.crypto.Data;
@EntityScan
public class DataObject {
    private String name;
    private String city;
    private  int id=0;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DataObject(String name, String city){
        this.name = name;
        this.city = city;
    }
    public DataObject (String name, String city, int id){
        this.name = name;
        this.city = city;
        this.id = id;
    }
    public DataObject(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }



}