package com.tomo.core.pojo.dto;

import lombok.Data;

@Data
public class AddressDTO {
    private String chainId;
    private String address;
    private String label;
    private Long userId;
    
    public AddressDTO() {
    }
    
    public AddressDTO(String chainId, String address) {
        this.chainId = chainId;
        this.address = address;
    }
}

