package com.example.demo.conections;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;

import org.springframework.stereotype.Component;

import com.example.demo.constante.RabbitMqConstantes;

import jakarta.annotation.PostConstruct;

@Component
public class RabbitMqConections {

    private AmqpAdmin amqpAdmin;

    public RabbitMqConections(AmqpAdmin amqpAdmin){
        this.amqpAdmin = amqpAdmin;
    }
    
    private static final String NOME_EXCHANGE = "amq.direct"; //Nome da amq.direct que está na Exchange do rabbitmq

    private Queue fila(String nomeFila){
        return new Queue(nomeFila, true, false, false);
    }
    private DirectExchange trocaDireta(){
        return  new  DirectExchange(NOME_EXCHANGE);
    }
    private Binding relacionamento(Queue fila, DirectExchange troca){
        return new Binding(fila.getName(), Binding.DestinationType.QUEUE, troca.getName(), fila.getName(), null);
    }

    @PostConstruct  //Atonação para fazer que o metodo adiciona inicie assim que levantar a aplicação
    private void adiciona(){
        Queue filaEstoque = this.fila(RabbitMqConstantes.FILA_ESTOQUE);
        Queue filaPreco = this.fila(RabbitMqConstantes.FILA_PRECO);

        DirectExchange troca = trocaDireta();

        Binding ligacaoEstoque = this.relacionamento(filaEstoque, troca);
        Binding ligacaoPreco = this.relacionamento(filaPreco, troca);

        //Criando fila no RabbitMq
        this.amqpAdmin.declareQueue(filaEstoque);
        this.amqpAdmin.declareQueue(filaPreco);

        //Criando Exchange
        this.amqpAdmin.declareExchange(troca);

        //Criando relacionamento
        this.amqpAdmin.declareBinding(ligacaoEstoque);
        this.amqpAdmin.declareBinding(ligacaoPreco);
    }
}
 