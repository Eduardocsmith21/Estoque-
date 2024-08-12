package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EstoqueDto;

@RestController //Mostra a c classe vai ser exporta por uma API 
@RequestMapping (value = "/estoque")     //Mapeia a classe por meio de em endpoint

public class EstoqueController {

    @RequestMapping("/alteraEstoque")
    private ResponseEntity<String> alteraEstoque (@RequestBody EstoqueDto estoqueDto){        //ResponseEntity - Representa a  resposta HTTP
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
