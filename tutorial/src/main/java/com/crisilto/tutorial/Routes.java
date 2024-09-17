package com.crisilto.tutorial;

import com.crisilto.tutorial.models.Book;
import com.crisilto.tutorial.models.Product;
import com.crisilto.tutorial.models.UserData;
import com.crisilto.tutorial.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class Routes {
    private final Logger logger = LoggerFactory.getLogger(Routes.class);
    private OrderService orderService = new OrderService();

    @GetMapping("/hello")
    String myFirstRoute() {
        return "Hello World from Spring controller :)";
    }

    @GetMapping("/book/{id}/editorial/{editorial}")
    String readBook(@PathVariable int id, @PathVariable String editorial) {
        return "Reading the book with id " + id + " editorial: " + editorial;
    }

    @GetMapping("/book2/{id}")
    String readBook2(@PathVariable int id, @RequestParam String params) {
        //http://localhost:8080/book2/2?params=value (Replacing value with any value we want to pass as parameter)
        return "Reading the book with id: " + id + " Params: " + params;
    }

    @PostMapping("/book")
    String saveBook(@RequestBody Book book) {
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
    public ResponseEntity<String> getAnimals(@PathVariable String place) {
        //http://localhost:8080/animals/forest
        if (place.equals("mountain")) {
            return ResponseEntity.status(HttpStatus.OK).body("The animals in the mountain are: lions, elephants, and rhinos");
        } else if (place.equals("forest")) {
            return ResponseEntity.status(HttpStatus.OK).body("The animals in the forest are: squirrels, birds, and bears");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Place not valid");
        }
    }

    @GetMapping("/calculation/{number}")
    public int getCalculation(@PathVariable int number) {
        //Simulate error
        throw new NullPointerException("Thrown when an application attempts to use null in a case where an object is required");
    }

    //Tedious way.
    @GetMapping("/userData")
    public ResponseEntity<String> getData() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body("{\"name\":\"mary\"}");
    }

    //Easier way.
    @GetMapping("/userData/v2")
    public Map<String, Map<String, Object>> getUserDataV2() {
        return Map.of("user", Map.of("name", "mary", "age", 26));
    }

    //Best way.
    @GetMapping("/userData/v3")
    public UserData getUserDataV3() {
        return new UserData("mary", 26, "spain");
    }

    @PostMapping("/order")
    public String createOrder(@RequestBody List<Product> products) {
        //
        orderService.saveOrder(products);
        return "Poducts saved successfully.";
    }
}