package br.com.silveira.notifyapp.presentation.controller;

import br.com.silveira.notifyapp.application.NotifyService;
import br.com.silveira.notifyapp.presentation.dto.NotifyRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class NotifyController {
    private final NotifyService notifyService;

    public NotifyController(NotifyService notifyService) {
        this.notifyService = notifyService;
    }

    @PostMapping("/notify")
    public ResponseEntity<String> notify(@RequestBody NotifyRequestDto dto) {
        String url = notifyService.sendAndLog(dto.to(), dto.message());
        return ResponseEntity.ok(url);
    }

    @GetMapping("/channel")
    public ResponseEntity<String> channel() {
        return ResponseEntity.ok(notifyService.getChannel());
    }
}
