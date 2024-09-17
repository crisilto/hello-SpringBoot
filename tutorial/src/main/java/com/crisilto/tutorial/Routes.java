package com.crisilto.tutorial;

import com.crisilto.tutorial.models.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Routes {
    private final Logger logger = LoggerFactory.getLogger(Routes.class);


    @GetMapping("/hello")
    String myFirstRoute() {
        return "Hello World from Spring controller :)";
    }

    @GetMapping("/book/{id}/editorial/{editorial}")
    String readBook(@PathVariable int id, @PathVariable String editorial) {
        return "Reading the book with id "+id+" editorial: "+editorial;
    }

    @GetMapping("/book2/{id}")
    String readBook2(@PathVariable int id, @RequestParam String params) {
        //http://localhost:8080/book2/2?params=value (Replacing value with any value we want to pass as parameter)
        return "Reading the book with id: "+id+" Params: "+params;
    }

    @PostMapping("/book")
    String saveBook(@RequestBody Book book){
        //Using POST-> http://localhost:8080/book {"name":"myBook","editorial":"myEditorial"}
        logger.debug("book{} editorial{}", book.name, book.editorial);
        return "Book saved";
    }

    @GetMapping("/greet")
    public ResponseEntity<String> mySecondRouteWithStatus() {
        //Setting the status code and response body.
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY)
                .body("Learning status http in SpringBoot");
    }

    @GetMapping("/animals/{place}")
    public ResponseEntity<String> getAnimals(@PathVariable String place){
        //http://localhost:8080/animals/forest
        if(place.equals("mountain")) {
            return ResponseEntity.status(HttpStatus.OK).body("The animals in the mountain are: lions, elephants, and rhinos");
        } else if(place.equals("forest")) {
            return ResponseEntity.status(HttpStatus.OK).body("The animals in the forest are: squirrels, birds, and bears");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Place not valid");
        }
    }

    @GetMapping("/calculation/{number}")
    public int getCalculation(@PathVariable int number){
        //Simulate error
        throw new NullPointerException("Thrown when an application attempts to use null in a case where an object is required");
    }
}
