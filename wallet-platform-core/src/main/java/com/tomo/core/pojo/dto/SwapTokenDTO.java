package com.tomo.core.pojo.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class SwapTokenDTO {
    private String symbol;
    private String name;
    private String address;
    private String chainId;
    private Integer decimals;
    private String logoUrl;
    private BigDecimal priceUsd;
    private Boolean isProjectToken;
    private String projectId;
    
    public SwapTokenDTO() {
    }
    
    public SwapTokenDTO(String symbol, String name, String chainId) {
        this.symbol = symbol;
        this.name = name;
        this.chainId = chainId;
        this.isProjectToken = false;
    }
}

