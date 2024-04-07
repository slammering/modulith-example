package com.hyand.modulith.example.document;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "hyand.modulith.example.document")
record DocumentProperties(
        /**
         * URL for document service
         */
        String url
) {
}
