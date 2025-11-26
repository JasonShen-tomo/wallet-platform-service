package com.wlfi.wallet.context;

import com.tomo.core.context.ProjectContext;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * WLFI Project Context Implementation
 * Defines WLFI project configuration and supported chains
 */
public class WLFIContext implements ProjectContext {

    private final Set<String> supportedChains;

    public WLFIContext(Set<String> supportedChains) {
        this.supportedChains = supportedChains;
    }

    @Override
    public String getProjectId() {
        return "WLFI";
    }

    @Override
    public Set<String> getSupportedChains() {
        return supportedChains;
    }

    @Override
    public Map<String, Boolean> getFeatureFlags() {
        return Collections.emptyMap();
    }

    @Override
    public Map<String, Object> getProjectConfig() {
        return Collections.emptyMap();
    }
}
