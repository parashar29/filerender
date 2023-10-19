package com.delimp.filerender.request;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class GroupDocsRenderRequest {

    private String process;
    private String sourceFile;
    private String extension;
    private String destinationFile;
    private Map<String, Object> pdfOptions= new HashMap<>();
    /*{
        "process": "viewer",
            "sourceFile": "/path/to/source/file.go",
            "extension": "txt",
            "destinationFile": "/path/to/cached/filename.pdf",
            "pdfOptions": {}
            possible value for pdfOptions
            "PdfDocumentOptions": {
      "DisableCharsGrouping": true,
      "EnableLayeredRendering": true,
      "EnableFontHinting": true,
      "RenderOriginalPageSize": true,
      "RenderTextAsImage": true
    }
    }*/
}
