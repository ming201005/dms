package com.niudao.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niudao.app.dao.ProductDao;
import com.niudao.app.entity.Product;
import com.niudao.app.enums.ProductSaleModelEnum;
import com.niudao.app.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * (Product)表服务实现类
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-15 22:49:39
 */
@Service("productService")
public class ProductServiceImpl extends ServiceImpl<ProductDao, Product> implements ProductService {

    //打印信息
    Logger logger =  LoggerFactory.getLogger (this.getClass ());

    /**
     * 商品列表（后台管理列表，带搜索）
     * @param page
     * @param searchModel 搜索模型
     * @return
     */
    @Override
    public Page<Map<String,Object>> getList(Page<Map<String,Object>> page, Product searchModel){


        //销售模式
        ProductSaleModelEnum productSaleModel = searchModel.getProductSaleModel ();
        Integer saleModel = 0;
        if(StringUtils.checkValNotNull(productSaleModel)) {
            saleModel = productSaleModel.getValue ();
        }

        //产品类型
        Integer productTypeId = searchModel.getProductTypeId ();

        //产品标签ID(扩展说明：如果产品标签可以多选，则searchModel可以定义一个新的)
        Integer productTagId = searchModel.getProductTagId ();

        //产品名称
        String  productName  = searchModel.getProductName ();
        //查询条件
        LambdaQueryWrapper<Product> lambdaQueryWrapper = new LambdaQueryWrapper ();
        //匹配查询结条件
        lambdaQueryWrapper
                .eq (
                        //1.匹配销售模式
                        StringUtils.checkValNotNull (saleModel) && saleModel>0,
                        Product::getProductSaleModel,
                        saleModel)
                //2.产品类型
                .eq (
                        StringUtils.checkValNotNull (productTypeId) && productTypeId>0,
                        Product::getProductTypeId,
                        productTypeId)
                //3.匹配商品标签
                .eq (
                        StringUtils.checkValNotNull (productTagId) && productTagId>0,
                        Product::getProductTagId,
                        productTagId)
                .like (
                        //4.模糊查询商品名称
                        StringUtils.isNotEmpty (productName),
                        Product::getProductName,
                        productName);

        //分页对象是否为空
        if(page==null) {
            page = new Page<> ();
        }

        //结果
        List<Map<String, Object>> list = this.baseMapper.getList (page,lambdaQueryWrapper);

        return page.setRecords (list);

    }
}