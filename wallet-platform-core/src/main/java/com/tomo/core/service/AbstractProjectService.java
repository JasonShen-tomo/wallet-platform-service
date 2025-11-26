package com.tomo.core.service;

import com.tomo.core.context.ProjectContext;
import com.tomo.core.controller.ChainRegistryCore;
import com.tomo.core.controller.PortfolioCore;
import com.tomo.core.controller.TokenCatalogCore;
import com.tomo.core.pojo.dto.AddressDTO;
import com.tomo.core.pojo.dto.BasePortfolioDTO;
import com.tomo.core.pojo.dto.ProjectPortfolioExtension;
import com.tomo.core.pojo.dto.SwapTokenDTO;
import com.tomo.core.service.provider.ProjectAssetProvider;
import com.tomo.core.service.provider.ProjectTokenProvider;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Abstract Project Service Base Class
 * Provides common infrastructure for project-specific business logic
 * <p>
 * This class:
 * 1. Implements ProjectAssetProvider and ProjectTokenProvider interfaces
 * 2. Injects core platform services for project use
 * 3. Provides template method for portfolio extension
 * 4. Allows projects to provide their specific swap tokens
 *
 * @param <C> Project context type that extends ProjectContext
 */
@Slf4j
public abstract class AbstractProjectService<C extends ProjectContext>
        implements ProjectAssetProvider<C>, ProjectTokenProvider<C> {

    /**
     * Core platform service dependencies
     * These are injected by constructor and available to all project implementations
     */
    protected final ChainRegistryCore chainRegistry;
    protected final TokenCatalogCore tokenCatalog;
    protected final PortfolioCore portfolioCore;

    /**
     * Project context instance (lazy initialized)
     */
    private C projectContext;

    /**
     * Constructor with core service dependencies
     * Subclasses should call super() to initialize core services
     */
    protected AbstractProjectService(ChainRegistryCore chainRegistry,
                                     TokenCatalogCore tokenCatalog,
                                     PortfolioCore portfolioCore) {
        this.chainRegistry = chainRegistry;
        this.tokenCatalog = tokenCatalog;
        this.portfolioCore = portfolioCore;
    }

    /**
     * Create project context instance
     * Subclasses must implement this to provide their specific context
     *
     * @return project context instance
     */
    protected abstract C createProjectContext();

    /**
     * Get project context (lazy initialization)
     *
     * @return project context
     */
    protected C getProjectContext() {
        if (projectContext == null) {
            projectContext = createProjectContext();
        }
        return projectContext;
    }

    /**
     * Get project ID from context
     * No need to override in subclasses - automatically gets from ProjectContext
     *
     * @return project ID
     */
    @Override
    public final String getProjectId() {
        return getProjectContext().getProjectId();
    }

    /**
     * Template method for portfolio extension
     * Provides common workflow: validation -> extension -> error handling
     */
    @Override
    public ProjectPortfolioExtension extendPortfolio(
            C context,
            Long userId,
            List<AddressDTO> addresses,
            BasePortfolioDTO basePortfolioDTO) {

        return doExtendPortfolio(context, userId, addresses, basePortfolioDTO);
    }

    /**
     * Project-specific portfolio extension logic
     * Subclasses can override this method to add their custom asset logic
     *
     * @param context          project context with configuration
     * @param userId           platform user ID
     * @param addresses        user's addresses across chains
     * @param basePortfolioDTO base portfolio from core platform
     * @return project-specific portfolio extension
     */
    protected ProjectPortfolioExtension doExtendPortfolio(
            C context,
            Long userId,
            List<AddressDTO> addresses,
            BasePortfolioDTO basePortfolioDTO) {
        // use injected core services
        // Example: query wallet's special tokens for current project
        return ProjectPortfolioExtension.empty();
    }

    /**
     * Get project-specific tokens for swap
     * Default implementation returns empty list
     * Projects should override to provide their tokens
     *
     * @param chainId optional chain filter
     * @return list of project-specific swap tokens
     */
    @Override
    public abstract List<SwapTokenDTO> getProjectTokens(String chainId);
}

