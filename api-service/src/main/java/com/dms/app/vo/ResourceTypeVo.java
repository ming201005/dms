package com.dms.app.vo;

/**
 * 资料类型
 */
public class ResourceTypeVo {
    
    Integer typeId;
    String resourceTypeName;
    Integer organizationId;
    String organizationName;

    public ResourceTypeVo() {
    }

    public ResourceTypeVo(Integer typeId, String resourceTypeName, Integer organizationId, String organizationName) {
        this.typeId = typeId;
        this.resourceTypeName = resourceTypeName;
        this.organizationId = organizationId;
        this.organizationName = organizationName;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getResourceTypeName() {
        return resourceTypeName;
    }

    public void setResourceTypeName(String resourceTypeName) {
        this.resourceTypeName = resourceTypeName;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    @Override
    public String toString() {
        return "ResourceTypeVo{" +
                "typeId=" + typeId +
                ", resourceTypeName='" + resourceTypeName + '\'' +
                ", organizationId=" + organizationId +
                ", organizationName='" + organizationName + '\'' +
                '}';
    }
}
