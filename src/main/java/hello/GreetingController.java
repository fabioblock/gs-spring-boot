package hello;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.ArrayList;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

@RestController

public class GreetingController {

private static final String template = "Hello, %s!";

private final AtomicLong counter = new AtomicLong();

private Greeting greetingObj = new Greeting(0, "dummy");

// Section: GET requests -----------------------------

@RequestMapping("/greeting/db")

public ResponseEntity<ArrayList<String>> getNames() {

return new ResponseEntity<>(greetingObj.getNames(), HttpStatus.OK);

}

@RequestMapping("/greeting")

public ResponseEntity<Greeting> greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

return new ResponseEntity<>(new Greeting(counter.incrementAndGet(), String.format(template, name)),

HttpStatus.OK);

}

// Section: POST requests ----------------------------

// This RequestMapping says to map addName() method to any POST request on /greeting

@RequestMapping(value = "/greeting", method = POST)

public ResponseEntity<?> addName(@RequestBody String name) {

greetingObj.addName(name);

// Because there is no validation, we can return that the request succeeded.

return new ResponseEntity<>(HttpStatus.OK);

}

}
