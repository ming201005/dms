package com.niudao.app.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.niudao.app.enums.ProductSaleModelEnum;

import java.io.Serializable;
import java.util.Date;

/**
 * (Product)表实体类
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-15 22:49:38
 */
@SuppressWarnings("serial")
public class Product extends Model<Product> {
    //ID
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    //商品登记时间（新增）
    private Date productCreateTime;
    //销售模式（1：现货销售；2：预售模式）--必填项

    @TableField(value = "product_sale_model")
    private ProductSaleModelEnum productSaleModel;
    //商品智能显示名称
    private String productNameValue;
    //商品规格显示
    private String productStandardsValue;
    //商品名称--必填项
    private String productName;
    //销量
    private Integer productSaleNum;
    //商品分类ID-外键--必选项
    private Integer productTypeId;
    //商品图片-URL地址（多张图逗号分开）-外键
    private String productImgId;
    //第一张图片URL（用于后台列表展现、前端列表、首页等地方）
    private String productImgIndexUrl;
    //商品视频-URL地址（单个视频）-外键
    private Integer productVideoId;
    //商品唯一编码（如：白色巧克力、黑色巧克力）
    private String productSku;
    //商品编码-但不是唯一的（如：巧克力）
    private String productSpu;
    //出售价格（单位：元）--必填项
    private Double productSalePrice;
    //商品单位（如：市场价：20元/公斤）
    private Integer productSaleUnitId;
    //成本价格（单位：元）
    private Double productCostPrice;
    //市场价格（用于对比）（单位：元）
    private Double productMarketPrice;
    //库存总数量（后台可更新【增加-减少】）
    private Integer productAmount;
    //规格
    private Double productStandards;
    //重量单位-外键
    private Integer productAmountUnitId;
    //份数
    private Integer productCopies;
    //体积
    private Double productVolume;
    //体积单位-外键
    private Integer productVolumeUnitId;
    //预售商品数量
    private Integer productSaleModel2Num;
    //商品标签-外键
    private Integer productTagId;
    //商品状态（1：上架、0：下架0，2：售完）【可通过时间控制：发布即上架、发布不上架、设置一个时间上架】
    private Integer productState;
    //商品详细描述信息
    private String productInformation;
    //访问量
    private Integer productViewNum;
    //访问来源【移动端、PC端(预留)】
    private String productViewFrom;
    //商品发布时间
    private Date productUpTime;
    //是否启用智能标题
    private Object productPnValue;
    //是否启用大约规格
    private Object productGgValue;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getProductCreateTime() {
        return productCreateTime;
    }

    public void setProductCreateTime(Date productCreateTime) {
        this.productCreateTime = productCreateTime;
    }

    public ProductSaleModelEnum getProductSaleModel() {
        return productSaleModel;
    }

    public void setProductSaleModel(ProductSaleModelEnum productSaleModel) {
        this.productSaleModel = productSaleModel;
    }

    public String getProductNameValue() {
        return productNameValue;
    }

    public void setProductNameValue(String productNameValue) {
        this.productNameValue = productNameValue;
    }

    public String getProductStandardsValue() {
        return productStandardsValue;
    }

    public void setProductStandardsValue(String productStandardsValue) {
        this.productStandardsValue = productStandardsValue;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductSaleNum() {
        return productSaleNum;
    }

    public void setProductSaleNum(Integer productSaleNum) {
        this.productSaleNum = productSaleNum;
    }

    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getProductImgId() {
        return productImgId;
    }

    public void setProductImgId(String productImgId) {
        this.productImgId = productImgId;
    }

    public String getProductImgIndexUrl() {
        return productImgIndexUrl;
    }

    public void setProductImgIndexUrl(String productImgIndexUrl) {
        this.productImgIndexUrl = productImgIndexUrl;
    }

    public Integer getProductVideoId() {
        return productVideoId;
    }

    public void setProductVideoId(Integer productVideoId) {
        this.productVideoId = productVideoId;
    }

    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }

    public String getProductSpu() {
        return productSpu;
    }

    public void setProductSpu(String productSpu) {
        this.productSpu = productSpu;
    }

    public Double getProductSalePrice() {
        return productSalePrice;
    }

    public void setProductSalePrice(Double productSalePrice) {
        this.productSalePrice = productSalePrice;
    }

    public Integer getProductSaleUnitId() {
        return productSaleUnitId;
    }

    public void setProductSaleUnitId(Integer productSaleUnitId) {
        this.productSaleUnitId = productSaleUnitId;
    }

    public Double getProductCostPrice() {
        return productCostPrice;
    }

    public void setProductCostPrice(Double productCostPrice) {
        this.productCostPrice = productCostPrice;
    }

    public Double getProductMarketPrice() {
        return productMarketPrice;
    }

    public void setProductMarketPrice(Double productMarketPrice) {
        this.productMarketPrice = productMarketPrice;
    }

    public Integer getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(Integer productAmount) {
        this.productAmount = productAmount;
    }

    public Double getProductStandards() {
        return productStandards;
    }

    public void setProductStandards(Double productStandards) {
        this.productStandards = productStandards;
    }

    public Integer getProductAmountUnitId() {
        return productAmountUnitId;
    }

    public void setProductAmountUnitId(Integer productAmountUnitId) {
        this.productAmountUnitId = productAmountUnitId;
    }

    public Integer getProductCopies() {
        return productCopies;
    }

    public void setProductCopies(Integer productCopies) {
        this.productCopies = productCopies;
    }

    public Double getProductVolume() {
        return productVolume;
    }

    public void setProductVolume(Double productVolume) {
        this.productVolume = productVolume;
    }

    public Integer getProductVolumeUnitId() {
        return productVolumeUnitId;
    }

    public void setProductVolumeUnitId(Integer productVolumeUnitId) {
        this.productVolumeUnitId = productVolumeUnitId;
    }

    public Integer getProductSaleModel2Num() {
        return productSaleModel2Num;
    }

    public void setProductSaleModel2Num(Integer productSaleModel2Num) {
        this.productSaleModel2Num = productSaleModel2Num;
    }

    public Integer getProductTagId() {
        return productTagId;
    }

    public void setProductTagId(Integer productTagId) {
        this.productTagId = productTagId;
    }

    public Integer getProductState() {
        return productState;
    }

    public void setProductState(Integer productState) {
        this.productState = productState;
    }

    public String getProductInformation() {
        return productInformation;
    }

    public void setProductInformation(String productInformation) {
        this.productInformation = productInformation;
    }

    public Integer getProductViewNum() {
        return productViewNum;
    }

    public void setProductViewNum(Integer productViewNum) {
        this.productViewNum = productViewNum;
    }

    public String getProductViewFrom() {
        return productViewFrom;
    }

    public void setProductViewFrom(String productViewFrom) {
        this.productViewFrom = productViewFrom;
    }

    public Date getProductUpTime() {
        return productUpTime;
    }

    public void setProductUpTime(Date productUpTime) {
        this.productUpTime = productUpTime;
    }

    public Object getProductPnValue() {
        return productPnValue;
    }

    public void setProductPnValue(Object productPnValue) {
        this.productPnValue = productPnValue;
    }

    public Object getProductGgValue() {
        return productGgValue;
    }

    public void setProductGgValue(Object productGgValue) {
        this.productGgValue = productGgValue;
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
        return "Product{" +
                "id=" + id +
                ", productCreateTime=" + productCreateTime +
                ", productSaleModel=" + productSaleModel +
                ", productNameValue='" + productNameValue + '\'' +
                ", productStandardsValue='" + productStandardsValue + '\'' +
                ", productName='" + productName + '\'' +
                ", productSaleNum=" + productSaleNum +
                ", productTypeId=" + productTypeId +
                ", productImgId='" + productImgId + '\'' +
                ", productImgIndexUrl='" + productImgIndexUrl + '\'' +
                ", productVideoId=" + productVideoId +
                ", productSku='" + productSku + '\'' +
                ", productSpu='" + productSpu + '\'' +
                ", productSalePrice=" + productSalePrice +
                ", productSaleUnitId=" + productSaleUnitId +
                ", productCostPrice=" + productCostPrice +
                ", productMarketPrice=" + productMarketPrice +
                ", productAmount=" + productAmount +
                ", productStandards=" + productStandards +
                ", productAmountUnitId=" + productAmountUnitId +
                ", productCopies=" + productCopies +
                ", productVolume=" + productVolume +
                ", productVolumeUnitId=" + productVolumeUnitId +
                ", productSaleModel2Num=" + productSaleModel2Num +
                ", productTagId=" + productTagId +
                ", productState=" + productState +
                ", productInformation='" + productInformation + '\'' +
                ", productViewNum=" + productViewNum +
                ", productViewFrom='" + productViewFrom + '\'' +
                ", productUpTime=" + productUpTime +
                ", productPnValue=" + productPnValue +
                ", productGgValue=" + productGgValue +
                '}';
    }
}