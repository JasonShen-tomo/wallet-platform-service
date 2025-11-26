package com.tomo.core.pojo.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Data
public class BasePortfolioDTO {
    private Long userId;
    private BigDecimal totalValueUsd;
    private Map<String, Object> chainData;
    
    public BasePortfolioDTO() {
        this.chainData = new HashMap<>();
    }
}

