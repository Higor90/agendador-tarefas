package com.agendadortarefas.infrastructure.exceptions;

public class RessourceNotFoundException extends  RuntimeException{

    public RessourceNotFoundException(String mensagem){
        super(mensagem);
    }
    public RessourceNotFoundException(String mensagem, Throwable throwable ){
        super( mensagem, throwable);
    }

}