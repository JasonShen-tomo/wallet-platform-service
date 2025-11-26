package com.tomo.core.service;

import com.tomo.core.pojo.dto.SwapTokenDTO;
import com.tomo.core.service.provider.ProjectTokenProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SwapCoreService{


    private final Map<String, ProjectTokenProvider<?>> projectTokenProviders;

    public SwapCoreService(List<ProjectTokenProvider<?>> providers) {
        this.projectTokenProviders = providers.stream()
                .collect(Collectors.toMap(
                        ProjectTokenProvider::getProjectId,
                        provider -> provider
                ));
        log.info("Initialized SwapCore with {} project token providers",
                projectTokenProviders.size());
    }

    public List<SwapTokenDTO> getSwapTokens(String projectId, String chainId) {

        // 1. Add core platform tokens (available to all projects)
        List<SwapTokenDTO> allTokens = new ArrayList<>(getCoreTokens(chainId));

        // 2. Add project-specific tokens if projectId provided
        if (projectId != null && projectTokenProviders.containsKey(projectId)) {
            ProjectTokenProvider<?> provider = projectTokenProviders.get(projectId);
            List<SwapTokenDTO> projectTokens = provider.getProjectTokens(chainId);
            allTokens.addAll(projectTokens);
            log.info("Added {} project tokens from {}", projectTokens.size(), projectId);
        }

        log.info("Returning {} total swap tokens", allTokens.size());
        return allTokens;
    }

    /**
     * Get core platform tokens (mock implementation)
     * These tokens are available to all projects
     */
    private List<SwapTokenDTO> getCoreTokens(String chainId) {
        List<SwapTokenDTO> tokens = new ArrayList<>();

        // Mock Ethereum tokens
        if (chainId == null || "100".equals(chainId)) {
            tokens.add(createToken("ETH", "Ethereum", "100", 18, "3000.00"));
            tokens.add(createToken("USDT", "Tether USD", "100", 6, "1.00",
                    "0xdac17f958d2ee523a2206206994597c13d831ec7"));
            tokens.add(createToken("USDC", "USD Coin", "100", 6, "1.00",
                    "0xa0b86991c6218b36c1d19d4a2e9eb0ce3606eb48"));
        }

        // Mock Polygon tokens
        if (chainId == null || "137".equals(chainId)) {
            tokens.add(createToken("MATIC", "Polygon", "137", 18, "0.80"));
            tokens.add(createToken("USDT", "Tether USD", "137", 6, "1.00",
                    "0xc2132d05d31c914a87c6611c10748aeb04b58e8f"));
        }

        // Mock BSC tokens
        if (chainId == null || "8453".equals(chainId)) {
            tokens.add(createToken("BNB", "BNB", "8453", 18, "300.00"));
            tokens.add(createToken("USDT", "Tether USD", "8453", 18, "1.00",
                    "0x55d398326f99059ff775485246999027b3197955"));
        }

        return tokens;
    }

    /**
     * Helper method to create token DTO
     */
    private SwapTokenDTO createToken(String symbol, String name, String chainId,
                                     Integer decimals, String price) {
        return createToken(symbol, name, chainId, decimals, price, null);
    }

    private SwapTokenDTO createToken(String symbol, String name, String chainId,
                                     Integer decimals, String price, String address) {
        SwapTokenDTO token = new SwapTokenDTO(symbol, name, chainId);
        token.setDecimals(decimals);
        token.setPriceUsd(new BigDecimal(price));
        token.setAddress(address);
        token.setIsProjectToken(false);
        token.setLogoUrl("https://example.com/logos/" + symbol.toLowerCase() + ".png");
        return token;
    }
}
