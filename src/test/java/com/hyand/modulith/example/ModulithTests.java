package com.hyand.modulith.example;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

public class ModulithTests {

    ApplicationModules applicationModules = ApplicationModules.of(App.class);

    @Test
    public void writeModuleInformation() {
        applicationModules.forEach(System.out::println);
    }

    @Test
    public void verify() {
        applicationModules.verify();
    }

    @Test
    public void writeDocumentationSnippets() {
        new Documenter(applicationModules)
                .writeDocumentation();
    }

}
