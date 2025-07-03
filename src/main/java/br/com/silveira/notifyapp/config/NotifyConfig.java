package br.com.silveira.notifyapp.config;

import br.com.silveira.notifyapp.domain.factory.NotifyFactory;
import br.com.silveira.notifyapp.infrastructure.email.EmailNotifyFactory;
import br.com.silveira.notifyapp.infrastructure.whatsapp.WhatsAppNotifyFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotifyConfig {

    @Bean
    @ConditionalOnProperty(name = "notify.type", havingValue = "email", matchIfMissing = true)
    public NotifyFactory emailFactory() {
        return new EmailNotifyFactory();
    }

    @Bean
    @ConditionalOnProperty(name = "notify.type", havingValue = "whatsapp")
    public NotifyFactory whatsappFactory() {
        return new WhatsAppNotifyFactory();
    }
}
