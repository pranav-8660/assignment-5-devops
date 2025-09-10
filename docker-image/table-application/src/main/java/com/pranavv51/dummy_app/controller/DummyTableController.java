package com.pranavv51.dummy_app.controller;

import com.pranavv51.dummy_app.service.DummyTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "table/")
public class DummyTableController {

    @Autowired
    private DummyTableService dummyTableService;

    // http://localhost:8080/table/
    @GetMapping("/{tableOf}")
    public ResponseEntity<List<String>> retrieveTables(@PathVariable int tableOf){
        return ResponseEntity.ok(dummyTableService.getTableOfChoice(tableOf));
    }
}
