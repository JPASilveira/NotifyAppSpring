package br.com.silveira.notifyapp.domain.repository;

import br.com.silveira.notifyapp.domain.model.NotifyLog;
import org.springframework.stereotype.Repository;

@Repository
public interface NotifyLogRepository{
    void save(NotifyLog notifyLog);
}
