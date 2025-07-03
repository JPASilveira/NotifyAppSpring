package br.com.silveira.notifyapp.infrastructure.h2;

import br.com.silveira.notifyapp.domain.factory.RepositoryFactory;
import br.com.silveira.notifyapp.domain.repository.NotifyLogRepository;

public class H2NotifyLogFactory implements RepositoryFactory {
    private final NotifyLogRepository notifyLogRepository;

    public H2NotifyLogFactory(NotifyLogRepository notifyLogRepository) {
        this.notifyLogRepository = notifyLogRepository;
    }

    @Override
    public NotifyLogRepository createNotifyLogRepository(){
        return notifyLogRepository;
    }
}
