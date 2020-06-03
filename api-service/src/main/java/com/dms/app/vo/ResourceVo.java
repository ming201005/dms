package com.dms.app.vo;
import com.dms.app.entity.Resource;

/**
 * 资料模型
 */
public class ResourceVo extends Resource {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    String  resourceTypeName;
    Integer organizationId;
    String  organizationName;

    String datetime1;

    String datetime2;

    public String getDatetime1() {
        return datetime1;
    }

    public void setDatetime1(String datetime1) {
        this.datetime1 = datetime1;
    }

    public String getDatetime2() {
        return datetime2;
    }

    public void setDatetime2(String datetime2) {
        this.datetime2 = datetime2;
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
  
}
