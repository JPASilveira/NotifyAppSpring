package br.com.silveira.notifyapp.infrastructure.email;

import br.com.silveira.notifyapp.domain.model.MessageFormatter;

public class EmailFormatter implements MessageFormatter {
    @Override
    public String format(String rawMessage) {
        String cleanMessage = rawMessage.replaceAll("[\\p{Cntrl}&&[^\r\n\t]]", "");

        cleanMessage = cleanMessage
                .replaceAll("&", "&amp;")
                .replaceAll("<", "&lt;")
                .replaceAll(">", "&gt;")
                .replaceAll("\"", "&quot;")
                .replaceAll("'", "&#39;");

        return cleanMessage;
    }
}