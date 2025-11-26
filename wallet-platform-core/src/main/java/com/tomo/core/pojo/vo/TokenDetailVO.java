package com.tomo.core.pojo.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class TokenDetailVO implements Serializable {
    private String name;
    private Long chainIndex;
    private String address;
    private String symbol;
    private String imageUrl;
    private Integer decimals;
    private Boolean isNative;
    private String priceUsd;
    private String priceChangeH24;
    private String volumeH24;
    private String marketCapUsd;
    private String fdvUsd;
    private Integer riskLevel;
    private String protocol;
    private Integer status;
    private String balance;
}
