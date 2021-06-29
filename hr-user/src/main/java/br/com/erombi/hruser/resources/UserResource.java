package br.com.erombi.hruser.resources;

import br.com.erombi.hruser.entities.User;
import br.com.erombi.hruser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RefreshScope
@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserRepository repository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {

        User user = repository.findById(id).orElseThrow(() -> new RuntimeException("Not found !"));
        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> findById(@RequestParam String email) {

        User user = repository.findByEmail(email).orElseThrow(() -> new RuntimeException("Not found !"));
        return ResponseEntity.ok(user);
    }
}
