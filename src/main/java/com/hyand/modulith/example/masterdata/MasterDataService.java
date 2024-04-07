package com.hyand.modulith.example.masterdata;

import com.hyand.modulith.example.masterdata.entities.MasterDataEntity;
import com.hyand.modulith.example.masterdata.repository.MasterDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MasterDataService {

    private final ApplicationEventPublisher events;
    private final MasterDataRepository masterDataRepository;

    @Transactional
    public void handle(MasterDataDto masterData) {
        masterDataRepository.save(map(masterData));
        events.publishEvent(new MasterDataCompleted(masterData.id()));
    }

    private MasterDataEntity map(MasterDataDto masterData) {
        return MasterDataEntity.builder()
                .id(masterData.id())
                .key(masterData.key())
                .build();
    }
}
