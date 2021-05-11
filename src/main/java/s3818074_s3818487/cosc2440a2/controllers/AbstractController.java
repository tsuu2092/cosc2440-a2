package s3818074_s3818487.cosc2440a2.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import s3818074_s3818487.cosc2440a2.services.AbstractService;

import java.util.List;

public abstract class AbstractController<T, ID> {
    protected AbstractService<T, ID> service;

    public AbstractController(AbstractService<T, ID> service) {
        this.service = service;
    }

    @GetMapping
    List<T> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    T getById(@PathVariable("id") ID id) {
        return service.getById(id);
    }

    @GetMapping("/pages/{page}")
    List<T> getAllByPage(@PathVariable("page") int page) {
        return service.getAllByPage(page);
    }

    @PostMapping
    T add(@RequestBody T t) {
        return service.add(t);
    }

    @DeleteMapping("/{id}")
    HttpStatus deleteById(@PathVariable("id") ID id) {
        return service.deleteById(id);
    }


    @DeleteMapping
    HttpStatus deleteAll() {
        return service.deleteAll();
    }
}