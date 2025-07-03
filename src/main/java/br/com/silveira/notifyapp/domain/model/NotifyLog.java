package br.com.silveira.notifyapp.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table
@Setter
@Getter
public class NotifyLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String channel;

    private String message;

    private String destination;

    private LocalDateTime createdAt;


    public NotifyLog() {
    }

    public NotifyLog(String channel, String message, String destination,LocalDateTime createdAt) {
        this.channel = channel;
        this.message = message;
        this.destination = destination;
        this.createdAt = createdAt;
    }
}
