package com.ssm.service.schedule.impl;

import com.ssm.bean.schedule.PageDetail;
import com.ssm.bean.schedule.Product;
import com.ssm.mapper.schedule.ProductMapper;
import com.ssm.service.schedule.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/5/18
 * @since 1.0.0
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public List<Product> queryPageProduct(PageDetail pageDetail) {
        return productMapper.selectByPageInformation(pageDetail);
    }

    @Override
    public int queryAllProduct() {
        return productMapper.selectAllRecords();
    }

    @Override
    public int insertProduct(Product product) {
        return productMapper.insert(product);
    }

    @Override
    public int deleteProduct(String productId) {
        return productMapper.deleteByPrimaryKey(productId);
    }

    @Override
    public int updateByProductId(Product product) {
        return productMapper.updateByPrimaryKeySelective(product);
    }

    @Override
    public List<Product> queryPageCustomByProductId(PageDetail pageDetail, Map<String, String> condition) {
        condition.put("productId", "%" + condition.get("productId") + "%");
        return productMapper.selectByPageAndProductCondition(pageDetail,condition);
    }

    @Override
    public int queryAllRecordByProductId(Map<String, String> condition) {
        condition.put("productId", "%" + condition.get("productId") + "%");
        return productMapper.selectAllRecordsByCondition(condition);
    }

    @Override
    public List<Product> queryPageCustomByProductName(PageDetail pageDetail, Map<String, String> condition) {
        condition.put("productName", "%" + condition.get("productName") + "%");
        return productMapper.selectByPageAndProductCondition(pageDetail,condition);
    }

    @Override
    public int queryAllRecordByProductName(Map<String, String> condition) {
        condition.put("productName", "%" + condition.get("productName") + "%");
        return productMapper.selectAllRecordsByCondition(condition);
    }

    @Override
    public List<Product> queryPageCustomByProductType(PageDetail pageDetail, Map<String, String> condition) {
        condition.put("productType", "%" + condition.get("productType") + "%");
        return productMapper.selectByPageAndProductCondition(pageDetail,condition);
    }

    @Override
    public int queryAllRecordByProductType(Map<String, String> condition) {
        condition.put("productType", "%" + condition.get("productType") + "%");
        return productMapper.selectAllRecordsByCondition(condition);
    }

    @Override
    public Product queryProductByProductId(String productId) {
        return productMapper.selectByPrimaryKey(productId);
    }

    @Override
    public List<Product> queryProducts() {
        return productMapper.selectAllProducts();
    }

    @Override
    public int deleteProducts(String[] ids) {
        return productMapper.deleteProductsByPrimaryKey(ids);
    }

}
