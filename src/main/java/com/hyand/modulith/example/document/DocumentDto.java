package com.hyand.modulith.example.document;

import java.util.UUID;

public record DocumentDto(UUID id, byte[] data) {
}
