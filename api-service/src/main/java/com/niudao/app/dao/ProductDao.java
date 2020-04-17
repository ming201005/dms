package com.niudao.app.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.niudao.app.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * (Product)表数据库访问层
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-15 22:49:38
 */
public interface ProductDao extends BaseMapper<Product> {

    /**
     * 关联多张表进行查询
     * @param page 分页
     * @param queryWrapper 查询条件
     * @return
     */
    @Select("select\n" +
            "       a.*, \n" +
            "       case \n"+
            "         when a.product_sale_model=1 then '实物销售' \n"+
            "         when a.product_sale_model=2 then '预售模式' \n"+
            "       end saleModel,\n"+
            "       b.product_type_name,\n" +
            "       c.unit_name_zh as amount_unit,\n" +
            "       d.unit_name_zh as volume_unit,\n" +
            "       e.product_tag_name,\n" +
            "       e.product_tag_type \n" +
            "from product a\n" +
            "  left join product_type b on b.id = a.product_type_id\n" +
            "  left join product_unit c on c.id = a.product_amount_unit_id\n" +
            "  left join product_unit d on d.id = a.product_volume_unit_id\n" +
            "  left join product_tag  e on e.id = a.product_tag_id \n" +
            "${ew.customSqlSegment}")
    public List<Map<String, Object>> getList(IPage<Map<String, Object>> page, @Param(Constants.WRAPPER) Wrapper<Product> queryWrapper);

}