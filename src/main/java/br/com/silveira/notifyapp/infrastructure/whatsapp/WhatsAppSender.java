package br.com.silveira.notifyapp.infrastructure.whatsapp;

import br.com.silveira.notifyapp.domain.model.MessageSender;

public class WhatsAppSender implements MessageSender {
    @Override
    public String send(String to, String message) {
        return "https://wa.me/+55" + to + "?text=" + message;
    }
}