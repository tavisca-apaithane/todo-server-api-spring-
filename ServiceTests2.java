import com.fasterxml.jackson.databind.ObjectMapper;
import hello.Application;
import hello.DataObject;
import hello.GreetingController;
import hello.Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = Application.class)
@RunWith(SpringRunner.class)
@WebMvcTest
public class ServiceTests2 {


    @Autowired
    MockMvc mockMvc;

    @MockBean
    GreetingController greetingController;
    @MockBean
    Service service;
//    @Before
//    public void setup(){
//        Service service = new Service();
//        mockMvc = MockMvcBuilders.standaloneSetup(service).build();
//    }



    @Test
    public void getMethodCheck()throws Exception{

        String expected = "{ '1': { 'name': 'abhishek', 'city': 'nashik', 'id': 1 }}";

        Map<Integer,DataObject> dummy = new HashMap<Integer, DataObject>(){
            {
                put(1,new DataObject("abhishek","nashik",1));
            }
        };
        //service = mock(Service.class);
        when(greetingController.getdata()).thenReturn(new ResponseEntity<>(dummy,HttpStatus.OK));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/todo").accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(content().json(expected));
    }

    @Test
    public void emptyRecordsCheck()throws Exception{

        String expected = "{}";

        Map<Integer,DataObject> dummy = new HashMap<Integer, DataObject>();
        //service = mock(Service.class);
        when(greetingController.getdata()).thenReturn(new ResponseEntity<>(dummy,HttpStatus.OK));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/todo").accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(content().json(expected));
    }

    @Test
    public void deleteMethodCheck()throws Exception{

        String expected = "{ '1': { 'name': 'abhishek', 'city': 'nashik', 'id': 1 }}";
        Map<Integer,DataObject> dummy = new HashMap<Integer, DataObject>(){
            {
                put(1,new DataObject("abhishek","nashik",1));
            }
        };
        //service = mock(Service.class);
        when(greetingController.deleteData(2)).thenReturn(new ResponseEntity<>(dummy, HttpStatus.OK));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/todo/2").accept(MediaType.APPLICATION_JSON);
        MvcResult result=mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        JSONAssert.assertEquals(expected,response.getContentAsString(),false);
    }

    @Test
    public void postMethodCheck()throws Exception {
        when(greetingController.recordData(new DataObject("abhishek","nashik",1)))
                .thenReturn(new ResponseEntity<>(HttpStatus.OK));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/todo").accept(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(new DataObject("nilesh","nagpur", 2))).
                        contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().isOk());
    }



}
