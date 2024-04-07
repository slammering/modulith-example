package com.hyand.modulith.example.api.model;

import com.hyand.modulith.example.api.model.enums.InputType;

import java.util.UUID;

public record Input(UUID id, InputType inputType, MasterData masterData, Document document) {

}
