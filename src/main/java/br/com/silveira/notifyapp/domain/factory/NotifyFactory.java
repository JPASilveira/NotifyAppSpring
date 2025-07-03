package br.com.silveira.notifyapp.domain.factory;

import br.com.silveira.notifyapp.domain.model.MessageFormatter;
import br.com.silveira.notifyapp.domain.model.MessageSender;

public interface NotifyFactory {
    MessageSender createSender();
    MessageFormatter createMessageFormatter();
    String getChannel();
}