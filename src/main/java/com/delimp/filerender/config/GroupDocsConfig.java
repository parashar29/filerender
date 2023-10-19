package com.delimp.filerender.config;

import com.groupdocs.viewer.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class GroupDocsConfig {
    @Value("classpath:data/resource-data.txt")
    Resource resourceFile;


   /*
   @Bean
   private License setLicense() throws IOException {
        License license = new License();
        try (InputStream fileStream = resourceFile.getInputStream()) {
            license.setLicense(fileStream);
        }
        return license;
    }*/

}
