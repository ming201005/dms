package com.dms.app.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

//DO、PO、bean
/**
 * (Organization)表实体类
 * easyCode--工具
 * @author 
 * @since 2020-04-21 19:30:48
 */
@SuppressWarnings("serial")
public class Organization extends Model<Organization> {



    //院系ID号
    @TableId(type = IdType.AUTO)
    private Integer id;

    //院系名称
    private String name;

    //院系概况
    private String des;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", des='" + des + '\'' +
                '}';
    }
}