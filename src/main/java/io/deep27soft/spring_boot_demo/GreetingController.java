package io.deep27soft.spring_boot_demo;

import io.deep27soft.spring_boot_demo.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";

    private final AtomicLong counter;
    private final Set<Greeting> greetings;

    GreetingController() {
        counter = new AtomicLong();
        greetings = new HashSet<>();
    }

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, name));
        greetings.add(greeting);
        return greeting;
    }

    @PostMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "id") long id) {
        return greetings.stream()
                .filter(g -> g.getId() == id).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No greeting with id " + id + "!"));
    }
}
