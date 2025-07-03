package br.com.silveira.notifyapp.infrastructure.whatsapp;

import br.com.silveira.notifyapp.domain.model.MessageFormatter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class WhatsAppFormatter implements MessageFormatter {
    @Override
    public String format(String rawMessage) {
        String cleanMessage = rawMessage.replaceAll("[\\p{Cntrl}&&[^\r\n\t]]", "");

        cleanMessage = cleanMessage
                .replaceAll("&", "&amp;")
                .replaceAll("<", "&lt;")
                .replaceAll(">", "&gt;")
                .replaceAll("\"", "&quot;")
                .replaceAll("'", "&#39;");

        return URLEncoder.encode(cleanMessage, StandardCharsets.UTF_8);
    }
}
