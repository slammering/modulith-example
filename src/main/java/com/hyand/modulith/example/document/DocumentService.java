package com.hyand.modulith.example.document;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DocumentService {

    private final ApplicationEventPublisher events;
    private final DocumentProperties documentProperties;

    public void handle(DocumentDto documentDto) {
        log.info("Send document to url {}", documentProperties.url());
        events.publishEvent(new DocumentCompleted(documentDto.id()));
    }
}
