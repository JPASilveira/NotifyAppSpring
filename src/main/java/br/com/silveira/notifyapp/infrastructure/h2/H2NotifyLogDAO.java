package br.com.silveira.notifyapp.infrastructure.h2;

import br.com.silveira.notifyapp.domain.model.NotifyLog;
import br.com.silveira.notifyapp.domain.repository.NotifyLogRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class H2NotifyLogDAO implements NotifyLogRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void save(NotifyLog notifyLog) {
        em.persist(notifyLog);
    }
}
