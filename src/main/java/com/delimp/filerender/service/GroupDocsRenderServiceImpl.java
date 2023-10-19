package com.delimp.filerender.service;

import com.delimp.filerender.constant.AppConstant;
import com.delimp.filerender.helper.FileSupportHelper;
import com.delimp.filerender.request.GroupDocsRenderRequest;
import com.delimp.filerender.response.AppResonse;
import com.delimp.filerender.response.ErrorResponse;
import com.delimp.filerender.response.GroupDocsRenderResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupdocs.conversion.Converter;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.options.PdfViewOptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class GroupDocsRenderServiceImpl implements  GroupDocsRenderService{

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private FileSupportHelper fileSupportHelper;

    public AppResonse<GroupDocsRenderResponse>  processView(GroupDocsRenderRequest renderRequest) throws JsonProcessingException {
        String successMessage=null;
        String errorMessage =null;
        String detailedErrorMessage=null;
        Converter converter = null;
        ErrorResponse errorResponse=null;
        GroupDocsRenderResponse renderResponse= null;
        AppResonse<GroupDocsRenderResponse> appResonse;

        try {
            if(fileSupportHelper.getPossiblesupportedFile(renderRequest.getSourceFile())== null){
                errorMessage= AppConstant.ERROR_MESSAGE;
            }else{
                if(renderRequest.getProcess().trim().equalsIgnoreCase("viewer")){
                    try(Viewer viewer = new Viewer(renderRequest.getSourceFile())){
                        PdfViewOptions viewOptions = new PdfViewOptions(renderRequest.getDestinationFile());
                        viewer.view(viewOptions);
                        successMessage=AppConstant.SUCCESS_MESSAGE;
                    }catch (Exception exception){
                        exception.printStackTrace();
                        detailedErrorMessage=exception.toString();
                        errorMessage= exception.getMessage();
                    }
                }else /*if(!renderRequest.getProcess().trim().equalsIgnoreCase("viewer"))*/{
                    errorMessage= AppConstant.UNDER_CONSTRUCTION;
                }
                renderResponse= GroupDocsRenderResponse.builder().message(successMessage).build();
            }

        } catch (Exception e){
            e.printStackTrace();
            errorMessage= e.getMessage();
            detailedErrorMessage=e.toString();
        }finally {
            errorResponse=ErrorResponse.builder().message(errorMessage).issue(detailedErrorMessage).build();
            appResonse= AppResonse.<GroupDocsRenderResponse>builder().data(renderResponse).errors(errorResponse).build();
            log.info("request payload {}"+ objectMapper.writeValueAsString(renderRequest));
            log.info("response payload {}"+ objectMapper.writeValueAsString(appResonse));
        }
        return appResonse;
    }
}
