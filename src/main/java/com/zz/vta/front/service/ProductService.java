package com.zz.vta.front.service;


        import com.zz.vta.front.db2map.ProductMapper;
        import com.zz.vta.front.db2map.TypeMapper;
        import com.zz.vta.front.entity.ProductEntity;
        import com.zz.vta.front.entity.TypeEntity;
        import com.zz.vta.front.frontentity.ProductShow;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.data.domain.Page;
        import org.springframework.data.domain.Pageable;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;

        import java.util.ArrayList;
        import java.util.List;

/**
 * 数据库实体转页面所需实体
 */
@Service
@Transactional
public class ProductService {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    TypeMapper typeMapper;

    /**
     * 新闻分页查询
     */
    public Page<ProductEntity> getSeProduct(Pageable pageable){
        return productMapper.findAll(pageable);
    }


    /**
     * 产品清单
     * @return
     */
    public List<ProductShow> getProAll(){
        List<ProductEntity> list =  productMapper.findAll();
        List<ProductShow> listShow = new ArrayList();

        for (int i = 0;i<list.size();i++){
            ProductEntity proE = list.get(i);
            ProductShow show = new ProductShow(proE.getId(),proE.getPro_name(),proE.getPro_type_id(),proE.getPro_spec(),proE.getPro_mate(),proE.getPro_color(),proE.getPro_modle(),proE.getPro_weigth(),proE.getPro_maprice(),
                    proE.getPro_desc(),proE.getPro_para(),proE.getPro_image(),proE.getPro_star(),proE.getPro_state());
            listShow.add(show);
        }
        return listShow;
    }

    /**
     * 根据Id查询产品详情
     */
    public ProductShow getPro(int id){
        ProductEntity proE =  productMapper.findById(id).get();
        TypeEntity proT = typeMapper.getProType(proE.getPro_type_id());
        ProductShow show = new ProductShow(proE.getId(),proE.getPro_name(),proE.getPro_type_id(),proE.getPro_spec(),proE.getPro_mate(),proE.getPro_color(),proE.getPro_modle(),proE.getPro_weigth(),proE.getPro_maprice(),
                proE.getPro_desc(),proE.getPro_para(),proE.getPro_image(),proE.getPro_star(),proE.getPro_state());
        show.setProType(proT.getTy_name());
        return show;
    }

    /**
     *根据产品类型查询
     */
    public List<ProductShow> getProByType(int id){
        List<ProductEntity> list =  productMapper.getProByType(id);
        List<ProductShow> listShow = new ArrayList();
        for (int i = 0;i<list.size();i++){
            ProductShow show = new ProductShow(list.get(i).getId(),list.get(i).getPro_name(),list.get(i).getPro_type_id(),list.get(i).getPro_spec(),list.get(i).getPro_mate(),list.get(i).getPro_color(),list.get(i).getPro_modle(),list.get(i).getPro_weigth(),list.get(i).getPro_maprice(),
                    list.get(i).getPro_desc(),list.get(i).getPro_para(),list.get(i).getPro_image(),list.get(i).getPro_star(),list.get(i).getPro_state());
            listShow.add(show);
        }
        return listShow;
    }

    /**
     * 通过id删除产品
     */
    public Boolean deletePro(int id){
        productMapper.deleteById(id);
        return !productMapper.existsById(id);
    }

    /**
     * 添加产品
     */
    public ProductEntity addPro(ProductEntity entity){
       return productMapper.saveAndFlush(entity);
    }


}
