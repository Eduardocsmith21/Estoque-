package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EstoqueDto;

@RestController
@RequestMapping(value = "/preco")

public class PrecoController {

    @RequestMapping("/alteraPreco")
    private ResponseEntity<String> alterarPreco(@RequestBody EstoqueDto estoqueDto){
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
