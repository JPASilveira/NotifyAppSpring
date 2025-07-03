package br.com.silveira.notifyapp.infrastructure.email;

import br.com.silveira.notifyapp.domain.factory.NotifyFactory;
import br.com.silveira.notifyapp.domain.model.MessageFormatter;
import br.com.silveira.notifyapp.domain.model.MessageSender;

public class EmailNotifyFactory implements NotifyFactory {
    public MessageSender createSender() {
        return new EmailSender();
    }

    public MessageFormatter createMessageFormatter() {
        return new EmailFormatter();
    }

    public String getChannel() {
        return "email";
    }
}