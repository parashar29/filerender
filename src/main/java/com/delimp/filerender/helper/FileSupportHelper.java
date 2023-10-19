package com.delimp.filerender.helper;

import com.groupdocs.conversion.internal.o.a.c.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class FileSupportHelper {

    public static final String  defaultView="pdf";
    @Value("#{'${groupdocs.support.file.documents}'.replaceAll('\\s+', '').split(',')}")
    private List<String> documents;
    @Value("#{'${groupdocs.support.file.spreadsheets}'.replaceAll('\\s+', '').split(',')}")
    private List<String> spreadsheets;
    @Value("#{'${groupdocs.support.file.presentations}'.replaceAll('\\s+', '').split(',')}")
     private List<String> presentations;
    @Value("#{'${groupdocs.support.file.images}'.replaceAll('\\s+', '').split(',')}")
    private List<String> images;
    @Value("#{'${groupdocs.support.file.portable}'.replaceAll('\\s+', '').split(',')}")
    private List<String> portables;
    @Value("#{'${groupdocs.support.file.html}'.replaceAll('\\s+', '').split(',')}")
    private List<String> html;
    @Value("#{'${groupdocs.support.file.metafiles}'.replaceAll('\\s+', '').split(',')}")
    private List<String> metafiles;
    @Value("#{'${groupdocs.support.file.photoshop}'.replaceAll('\\s+', '').split(',')}")
    private List<String> photoshop;
    @Value("#{'${groupdocs.support.file.project}'.replaceAll('\\s+', '').split(',')}")
    private List<String> project;
    @Value("#{'${groupdocs.support.file.outlook}'.replaceAll('\\s+', '').split(',')}")
    private List<String> outlook;
    @Value("#{'${groupdocs.support.file.email}'.replaceAll('\\s+', '').split(',')}")
    private List<String> email;
    @Value("#{'${groupdocs.support.file.diagrams}'.replaceAll('\\s+', '').split(',')}")
    private List<String> diagrams;
    @Value("#{'${groupdocs.support.file.autocad}'.replaceAll('\\s+', '').split(',')}")
    private List<String> autocad;
    @Value("#{'${groupdocs.support.file.postscript}'.replaceAll('\\s+', '').split(',')}")
    private List<String> postscript;
    @Value("#{'${groupdocs.support.file.coreldraw}'.replaceAll('\\s+', '').split(',')}")
    private List<String> coreldraw;
    @Value("#{'${groupdocs.support.file.others}'.replaceAll('\\s+', '').split(',')}")
    private List<String> others;

    public List<String> supportedFiles ;

    @PostConstruct
    public void init(){
        this.supportedFiles= Stream.of(documents, spreadsheets, presentations,images,portables,html,metafiles,photoshop
                        ,project,outlook,email,diagrams,autocad,postscript,coreldraw,others)
                .flatMap(Collection::stream).collect(Collectors.toList());

    }
    public String getPossiblesupportedFile(String sourceFile){
       return this.supportedFiles.stream().filter(item -> item.equalsIgnoreCase(FilenameUtils.getExtension(sourceFile))).findAny().orElse(null);
    }

}
