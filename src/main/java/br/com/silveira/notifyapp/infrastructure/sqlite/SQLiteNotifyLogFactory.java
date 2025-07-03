package br.com.silveira.notifyapp.infrastructure.sqlite;

import br.com.silveira.notifyapp.domain.factory.RepositoryFactory;
import br.com.silveira.notifyapp.domain.repository.NotifyLogRepository;

public class SQLiteNotifyLogFactory implements RepositoryFactory {
    private final NotifyLogRepository notifyLogRepository;

    public SQLiteNotifyLogFactory(NotifyLogRepository notifyLogRepository){
        this.notifyLogRepository = notifyLogRepository;
    }

    @Override
    public NotifyLogRepository createNotifyLogRepository(){
        return notifyLogRepository;
    };
}
