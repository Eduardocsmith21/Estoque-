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

@RestController //Mostra a c classe vai ser exporta por uma API 
@RequestMapping (value = "/estoque")     //Mapeia a classe por meio de em endpoint

public class EstoqueController {

    @Autowired
    private RabbitMqServer rabbitMqServer;

    @RequestMapping("/alteraEstoque")
    private ResponseEntity<String> alteraEstoque (@RequestBody EstoqueDto estoqueDto){        //ResponseEntity - Representa a  resposta HTT
        this.rabbitMqServer.enviaMensagem(RabbitMqConstantes.FILA_ESTOQUE, estoqueDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
