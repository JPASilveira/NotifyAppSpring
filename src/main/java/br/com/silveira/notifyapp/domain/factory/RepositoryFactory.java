package br.com.silveira.notifyapp.domain.factory;

import br.com.silveira.notifyapp.domain.repository.NotifyLogRepository;

public interface RepositoryFactory {
    NotifyLogRepository createNotifyLogRepository();
}
