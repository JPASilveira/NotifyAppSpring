package br.com.silveira.notifyapp.infrastructure.sqlite;

import br.com.silveira.notifyapp.domain.model.NotifyLog;
import br.com.silveira.notifyapp.domain.repository.NotifyLogRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class SQLiteNotifyLogDAO implements NotifyLogRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void save(NotifyLog notifyLog) {
        em.persist(notifyLog);
    }
}
