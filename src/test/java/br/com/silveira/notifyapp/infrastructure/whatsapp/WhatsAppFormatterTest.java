package br.com.silveira.notifyapp.infrastructure.whatsapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WhatsAppFormatterTest {

    @Test
    void format_shouldEncodeMessageCorrectly() {
        WhatsAppFormatter formatter = new WhatsAppFormatter();
        String rawMessage = "Olá mundo";
        String expected = "Ol%C3%A1+mundo"; // Valor esperado após encode

        String result = formatter.format(rawMessage);
        System.out.println(result);

        assertEquals(expected, result);
    }
}
