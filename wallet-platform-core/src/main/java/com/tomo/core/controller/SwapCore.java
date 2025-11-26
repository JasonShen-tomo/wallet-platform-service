package com.tomo.core.controller;

import com.tomo.core.pojo.dto.SwapTokenDTO;
import com.tomo.core.service.SwapCoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Swap Core Controller
 * Provides core swap functionality and token aggregation
 */
@Slf4j
@RestController
@RequestMapping("/api/core/swap")
public class SwapCore {

    private final SwapCoreService swapCoreService;

    @Autowired
    public SwapCore(SwapCoreService swapCoreService) {
        this.swapCoreService = swapCoreService;
    }

    /**
     * Get all available swap tokens
     * Aggregates core platform tokens and project-specific tokens
     *
     * @param projectId optional project ID to include project tokens
     * @param chainId   optional chain filter
     * @return list of all available swap tokens
     */
    @GetMapping("/tokens")
    public List<SwapTokenDTO> getSwapTokens(
            @RequestHeader(required = false) String projectId,
            @RequestParam(required = false) String chainId) {
        log.info("Getting swap tokens for projectId: {}, chainId: {}", projectId, chainId);
        return swapCoreService.getSwapTokens(projectId, chainId);
    }

}

