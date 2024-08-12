package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constante.RabbitMqConstantes;
import com.example.demo.dto.EstoqueDto;
import com.example.demo.service.RabbitMqServer;

@RestController
@RequestMapping(value = "/preco")

public class PrecoController {

    @Autowired
    private RabbitMqServer rabbitMqServer;

    @RequestMapping("/alteraPreco")
    private ResponseEntity<String> alterarPreco(@RequestBody EstoqueDto estoqueDto){
        System.out.println(estoqueDto);
        this.rabbitMqServer.enviaMensagem(RabbitMqConstantes.FILA_PRECO, estoqueDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
