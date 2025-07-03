package br.com.silveira.notifyapp.infrastructure.whatsapp;

import br.com.silveira.notifyapp.domain.factory.NotifyFactory;
import br.com.silveira.notifyapp.domain.model.MessageFormatter;
import br.com.silveira.notifyapp.domain.model.MessageSender;

public class WhatsAppNotifyFactory implements NotifyFactory {
    public MessageSender createSender() {
        return new WhatsAppSender();
    }

    public MessageFormatter createMessageFormatter() {
        return new WhatsAppFormatter();
    }

    public String getChannel() {
        return "whatsapp";
    }
}
