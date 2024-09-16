package com.crisilto.tutorial;

import com.crisilto.tutorial.models.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
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
        return "Reading the book with id: "+id+" Params: "+params;
    }

    @PostMapping("/book")
    String saveBook(@RequestBody Book book){
        logger.debug("book{} editorial{}", book.name, book.editorial);
        return "Book saved";
    }

    @GetMapping("/greet")
    @ResponseStatus(value = HttpStatus.MOVED_PERMANENTLY, reason="Moved to v2 API")
    String mySecondRouteWithStatus() {
        return "Learning status http in SpringBoot";
    }

}
