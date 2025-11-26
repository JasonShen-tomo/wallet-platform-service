package com.tomo.core.pojo.dto;

import lombok.Data;
import java.util.HashMap;
import java.util.Map;

@Data
public class ProjectPortfolioExtension {
    private String projectId;
    private Map<String, Object> extensions;
    
    public ProjectPortfolioExtension() {
        this.extensions = new HashMap<>();
    }
    
    public ProjectPortfolioExtension(String projectId) {
        this.projectId = projectId;
        this.extensions = new HashMap<>();
    }
    
    public void addExtension(String key, Object value) {
        this.extensions.put(key, value);
    }
    
    public static ProjectPortfolioExtension empty() {
        return new ProjectPortfolioExtension();
    }
    
    public static ProjectPortfolioExtension of(String projectId) {
        return new ProjectPortfolioExtension(projectId);
    }
}

