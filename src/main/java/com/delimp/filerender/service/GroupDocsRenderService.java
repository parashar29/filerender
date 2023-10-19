package com.delimp.filerender.service;

import com.delimp.filerender.request.GroupDocsRenderRequest;
import com.delimp.filerender.response.AppResonse;
import com.delimp.filerender.response.GroupDocsRenderResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface GroupDocsRenderService {
    public AppResonse<GroupDocsRenderResponse> processView(GroupDocsRenderRequest renderRequest) throws JsonProcessingException;
}
