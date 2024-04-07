package com.hyand.modulith.example.api;

import com.hyand.modulith.example.api.model.Input;
import com.hyand.modulith.example.document.DocumentDto;
import com.hyand.modulith.example.document.DocumentService;
import com.hyand.modulith.example.masterdata.MasterDataDto;
import com.hyand.modulith.example.masterdata.MasterDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final MasterDataService masterDataService;
    private final DocumentService documentService;

    @PostMapping("/receive")
    @Transactional
    public ResponseEntity<String> receive(Input input) {
        switch (input.inputType()) {
            case MASTERDATA -> masterDataService.handle(mapMasterData(input));
            case DOCUMENT -> documentService.handle(mapDocument(input));
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    private MasterDataDto mapMasterData(Input input) {
        return new MasterDataDto(input.id(), input.masterData().key());
    }

    private DocumentDto mapDocument(Input input) {
        return new DocumentDto(input.id(), input.document().data());
    }

}
