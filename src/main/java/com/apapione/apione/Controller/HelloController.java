package com.apapione.apione.Controller;

import com.apapione.apione.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
//import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class HelloController {

    // Receive GET requests like this
    //
    //@GetMapping("/hi/{name}/{age}/{profession}")
    @GetMapping("/hi") //ADD_TO_URL ?name=INSERT_NAME&age=INSERT_AGE&profession=INSERT_PROFESSION
    public String sayHello(
            @RequestParam String name,      //@PathVariable String name,
            @RequestParam int age,          //@PathVariable int age,
            @RequestParam String profession //@PathVariable String profession
    ){
        return "Hi " + name + " Your age is: " + age + " And profession: "+profession;
    }

    // Receive POST requests like this
    //
    @PostMapping("/client")
    public void newClient(@RequestBody Client cli){
        System.out.println("Client data: "+ cli.getName() + " Surname: "+ cli.getSurname());
    }

    // Do a response to a GET request
    //
    @GetMapping("/client/list")
    @ResponseBody
    public List<Client> getClients(){
        List<Client> clientList = new ArrayList<Client>();
        clientList.add(new Client(1L, "Pepe", "Pinerola"));
        clientList.add(new Client(2L, "Pedro", "Polo"));
        clientList.add(new Client(3L, "Ero", "Esteban"));

        return clientList;
    }
    // or you can use
    @GetMapping("/responseTest")
    ResponseEntity<String> respond(){
        return new ResponseEntity<>("This is a message from a Response Entity", HttpStatus.OK);
    }
}
