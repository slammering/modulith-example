package com.hyand.modulith.example.api;

import com.hyand.modulith.example.api.model.Input;
import com.hyand.modulith.example.api.model.MasterData;
import com.hyand.modulith.example.api.model.enums.InputType;
import com.hyand.modulith.example.masterdata.MasterDataCompleted;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;

import java.util.UUID;

@ApplicationModuleTest(ApplicationModuleTest.BootstrapMode.DIRECT_DEPENDENCIES)
@RequiredArgsConstructor
public class ApiTest {

    private final Controller controller;

    @Test
    public void handle(Scenario scenario) {
        var id = UUID.randomUUID();
        var input = new Input(id, InputType.MASTERDATA, new MasterData("Yeah!"), null);
        scenario.stimulate(() -> controller.receive(input))
                .andWaitForEventOfType(MasterDataCompleted.class)
                .matchingMappedValue(MasterDataCompleted::id, id)
                .toArrive();
    }
}
