package br.com.silveira.notifyapp.repository;

import br.com.silveira.notifyapp.domain.factory.RepositoryFactory;
import br.com.silveira.notifyapp.domain.model.NotifyLog;
import br.com.silveira.notifyapp.domain.repository.NotifyLogRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class NotifyLogSaveTest {

    @Autowired
    private RepositoryFactory repositoryFactory;

    @Test
    public void testSaveLog() {
        NotifyLogRepository repository = repositoryFactory.createNotifyLogRepository();

        NotifyLog log = new NotifyLog(
                "test-channel",
                "Mensagem de teste",
                "destino@teste.com",
                LocalDateTime.now()
        );

        repository.save(log);

        System.out.println("Salvo com ID: " + log.getId());
        assert log.getId() != null;
    }
}
