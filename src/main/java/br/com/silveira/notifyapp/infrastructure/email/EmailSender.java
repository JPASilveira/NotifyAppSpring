package br.com.silveira.notifyapp.infrastructure.email;

import br.com.silveira.notifyapp.domain.model.MessageSender;

public class EmailSender implements MessageSender {
    @Override
    public String send(String to, String message) {
        return "mailto:" + to + "?subject=Mensagem Gerada Automáticamente&body=" + message;
    }
}