package com.delimp.filerender.controller;

import com.delimp.filerender.constant.AppConstant;
import com.delimp.filerender.helper.FileSupportHelper;
import com.delimp.filerender.request.GroupDocsRenderRequest;
import com.delimp.filerender.response.AppResonse;
import com.delimp.filerender.response.GroupDocsRenderResponse;
import com.delimp.filerender.response.ErrorResponse;
import com.delimp.filerender.service.GroupDocsRenderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupdocs.conversion.Converter;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.options.PdfViewOptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("v1/api")
public class GroupDocsRenderController {

    @Autowired
    private GroupDocsRenderService groupDocsRenderService;

    @PostMapping("/render")
    public AppResonse<GroupDocsRenderResponse> generateView(@RequestBody GroupDocsRenderRequest renderRequest) throws JsonProcessingException {
        return groupDocsRenderService.processView(renderRequest);
    }
}






