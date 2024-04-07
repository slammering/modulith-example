package com.hyand.modulith.example.status;

import com.hyand.modulith.example.document.DocumentCompleted;
import com.hyand.modulith.example.masterdata.MasterDataCompleted;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@Component
public class StatusEventHandler {

    @ApplicationModuleListener
    public void on(MasterDataCompleted masterDataCompleted) {
       // handle event
    }

    @ApplicationModuleListener
    public void on(DocumentCompleted documentCompleted) {
        // handle event
    }
}
