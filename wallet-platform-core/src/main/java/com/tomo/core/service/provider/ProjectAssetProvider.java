package com.tomo.core.service.provider;

import com.tomo.core.context.ProjectContext;
import com.tomo.core.pojo.dto.AddressDTO;
import com.tomo.core.pojo.dto.BasePortfolioDTO;
import com.tomo.core.pojo.dto.ProjectPortfolioExtension;

import java.util.List;

public interface ProjectAssetProvider<C extends ProjectContext> {
    String getProjectId();
    
    ProjectPortfolioExtension extendPortfolio(
            C context,
            Long userId,
            List<AddressDTO> addresses,
            BasePortfolioDTO basePortfolioDTO
    );
}

