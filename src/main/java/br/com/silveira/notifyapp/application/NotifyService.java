package br.com.silveira.notifyapp.application;

import br.com.silveira.notifyapp.domain.factory.NotifyFactory;
import br.com.silveira.notifyapp.domain.factory.RepositoryFactory;
import br.com.silveira.notifyapp.domain.model.NotifyLog;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotifyService {
    private final NotifyFactory notifyFactory;
    private final RepositoryFactory repositoryFactory;

    public NotifyService(NotifyFactory notifyFactory, RepositoryFactory repositoryFactory) {
        this.notifyFactory = notifyFactory;
        this.repositoryFactory = repositoryFactory;
    }

    public String sendAndLog(String to, String message) {
        var formatter = notifyFactory.createMessageFormatter();
        var sender = notifyFactory.createSender();

        String formatted = formatter.format(message);
        String url = sender.send(to, formatted);

        NotifyLog notifyLog = new NotifyLog(
            notifyFactory.getChannel(),
            message,
            to,
            LocalDateTime.now()
        );

        repositoryFactory.createNotifyLogRepository().save(notifyLog);

        return url;
    }

    public String getChannel(){
        return notifyFactory.getChannel();
    }
}
