package com.example.demo.conections;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;

import org.springframework.stereotype.Component;

import com.example.demo.constante.RabbitMqConstantes;

@Component
public class RabbitMqConections {
    
    private static final String NOME_EXCHANGE = "amq.direct"; //Nome da amq.direct que está na Exchange do rabbitmq

    private Queue fila(String nomeFila){
        return new Queue(nomeFila, true, false, false);
    }
    private DirectExchange trocaDireta(){
        return  new  DirectExchange(NOME_EXCHANGE);
    }
    private Binding relacionamento(Queue fila, DirectExchange troca){
        return new Binding(fila.getName(), Binding.DestinationType.EXCHANGE, troca.getName(), fila.getName(), null);
    }
    private void adiciona(){
        this.fila(RabbitMqConstantes.FILA_ESTOQUE);
    }
}
 