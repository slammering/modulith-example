package com.hyand.modulith.example.masterdata;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;

import java.util.UUID;

@ApplicationModuleTest
@RequiredArgsConstructor
public class MasterDataTest {

    private final MasterDataService masterDataService;

    @Test
    public void handle(Scenario scenario) {
        UUID id = UUID.randomUUID();
        MasterDataDto masterDataDto = new MasterDataDto(id, "Yeah!");
        scenario.stimulate(() -> masterDataService.handle(masterDataDto))
                .andWaitForEventOfType(MasterDataCompleted.class)
                .matchingMappedValue(MasterDataCompleted::id, id)
                .toArrive();
    }
}
