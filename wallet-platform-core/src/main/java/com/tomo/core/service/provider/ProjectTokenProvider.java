package com.tomo.core.service.provider;

import com.tomo.core.context.ProjectContext;
import com.tomo.core.pojo.dto.SwapTokenDTO;

import java.util.List;

public interface ProjectTokenProvider<C extends ProjectContext> {
    String getProjectId();
    List<SwapTokenDTO> getProjectTokens(String chainId);
}

