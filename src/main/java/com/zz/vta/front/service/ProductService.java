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

        import java.math.BigDecimal;
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
            ProductShow show = new ProductShow();
            TypeEntity proT = typeMapper.getProType(proE.getPro_type_id());
            if (proE.getPro_name()==""||proE.getPro_name()==null){
                show.setStrProName("名称未填写");
            }else {
                show.setStrProName(proE.getPro_name());
            }if (proE.getPro_color()==""||proE.getPro_color()==null){
                show.setStrProColor("未填写");
            }else {
                show.setStrProColor(proE.getPro_color());
            }if (proE.getPro_desc()==""||proE.getPro_desc()==null){
                show.setStrProDesc("颜色未填写");
            }else {
                show.setStrProDesc(proE.getPro_desc());
            }if (proE.getPro_image()==""||proE.getPro_image()==null){
                show.setStrProImage("未填写");
            }else {
                show.setStrProImage(proE.getPro_image());
            }if (proE.getPro_mate()==""||proE.getPro_mate()==null){
                show.setStrProMate("未填写");
            }else {
                show.setStrProMate(proE.getPro_mate());
            }if (proE.getPro_modle()==""||proE.getPro_modle()==null){
                show.setStrProModle("未填写");
            }else {
                show.setStrProModle(proE.getPro_modle());
            }if (proE.getPro_para()==""||proE.getPro_para()==null){
                show.setStrProModle("未填写");
            }else {
                show.setStrProModle(proE.getPro_modle());
            }if (proE.getPro_spec()==""||proE.getPro_spec()==null){
                show.setStrProSpec("未填写");
            }else {
                show.setStrProSpec(proE.getPro_spec());
            }if (proE.getPro_maprice()==null){
                show.setBigProMaprice(new BigDecimal(0));
            }else {
                show.setBigProMaprice(proE.getPro_maprice());
            }if (proE.getPro_price()==null){
                show.setBigProPrice(new BigDecimal(0));
            }else {
                show.setBigProPrice(proE.getPro_price());
            }if (proE.getPro_weigth()==null){
                show.setDouProWeigth(0.0);
            }else {
                show.setDouProWeigth(proE.getPro_weigth());
            }if (proE.getPro_para()==""||proE.getPro_para()==null){
                show.setStrProPara("未填写");
            }else {
                show.setStrProPara(proE.getPro_para());
            }
            show.setIntProId(proE.getId());
            show.setIntProReally(proE.getPro_really());
            show.setIntProState(proE.getPro_state());
            show.setIntProStar(proE.getPro_star());
            show.setStrProSelfdev(String.valueOf(proE.getPro_selfdev()));
            /*ProductShow show = new ProductShow(proE.getId(),proE.getPro_name(),proE.getPro_type_id(),proT.getTy_name(),proE.getPro_spec(),proE.getPro_mate(),proE.getPro_color(),proE.getPro_modle(),proE.getPro_weigth(),proE.getPro_price(),proE.getPro_maprice(),
                    proE.getPro_really(),proE.getPro_desc(),proE.getPro_para(),String.valueOf(proE.getPro_selfdev()), proE.getPro_image(),proE.getPro_star(),proE.getPro_state());*/
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
        ProductShow show = new ProductShow();
        if (proE.getPro_name()==""||proE.getPro_name()==null){
            show.setStrProName("名称未填写");
        }else {
            show.setStrProName(proE.getPro_name());
        }if (proE.getPro_color()==""||proE.getPro_color()==null){
            show.setStrProColor("未填写");
        }else {
            show.setStrProColor(proE.getPro_color());
        }if (proE.getPro_desc()==""||proE.getPro_desc()==null){
            show.setStrProDesc("颜色未填写");
        }else {
            show.setStrProDesc(proE.getPro_desc());
        }if (proE.getPro_image()==""||proE.getPro_image()==null){
            show.setStrProImage("未填写");
        }else {
            show.setStrProImage(proE.getPro_image());
        }if (proE.getPro_mate()==""||proE.getPro_mate()==null){
            show.setStrProMate("未填写");
        }else {
            show.setStrProMate(proE.getPro_mate());
        }if (proE.getPro_modle()==""||proE.getPro_modle()==null){
            show.setStrProModle("未填写");
        }else {
            show.setStrProModle(proE.getPro_modle());
        }if (proE.getPro_para()==""||proE.getPro_para()==null){
            show.setStrProModle("未填写");
        }else {
            show.setStrProModle(proE.getPro_modle());
        }if (proE.getPro_spec()==""||proE.getPro_spec()==null){
            show.setStrProSpec("未填写");
        }else {
            show.setStrProSpec(proE.getPro_spec());
        }if (proE.getPro_maprice()==null){
            show.setBigProMaprice(new BigDecimal(0));
        }else {
            show.setBigProMaprice(proE.getPro_maprice());
        }if (proE.getPro_price()==null){
            show.setBigProPrice(new BigDecimal(0));
        }else {
            show.setBigProPrice(proE.getPro_price());
        }if (proE.getPro_para()==""||proE.getPro_para()==null){
            show.setStrProPara("未填写");
        }else {
            show.setStrProPara(proE.getPro_para());
        }if (proE.getPro_weigth()==null){
            show.setDouProWeigth(0.0);
        }else {
            show.setDouProWeigth(proE.getPro_weigth());
        }
        show.setIntProId(proE.getId());
        show.setIntProReally(proE.getPro_really());
        show.setIntProState(proE.getPro_state());
        show.setIntProStar(proE.getPro_star());
        show.setStrProSelfdev(String.valueOf(proE.getPro_selfdev()));
        show.setProType(proT.getTy_name());
            /*ProductShow show = new ProductShow(proE.getId(),proE.getPro_name(),proE.getPro_type_id(),proT.getTy_name(),proE.getPro_spec(),proE.getPro_mate(),proE.getPro_color(),proE.getPro_modle(),proE.getPro_weigth(),proE.getPro_price(),proE.getPro_maprice(),
                    proE.getPro_really(),proE.getPro_desc(),proE.getPro_para(),String.valueOf(proE.getPro_selfdev()), proE.getPro_image(),proE.getPro_star(),proE.getPro_state());*/
        return show;
    }

    /**
     *根据产品类型查询
     */
    public List<ProductShow> getProByType(int id){
        List<ProductEntity> list =  productMapper.getProByType(id);
        List<ProductShow> listShow = new ArrayList();
        TypeEntity proT = typeMapper.getProType(id);
        for (int i = 0;i<list.size();i++){
            ProductShow show = new ProductShow(list.get(i).getId(),list.get(i).getPro_name(),list.get(i).getPro_type_id(),proT.getTy_name(),list.get(i).getPro_spec(),list.get(i).getPro_mate(),list.get(i).getPro_color(),list.get(i).getPro_modle(),list.get(i).getPro_weigth(),list.get(i).getPro_price(),list.get(i).getPro_maprice(),
                    list.get(i).getPro_really(),list.get(i).getPro_desc(),list.get(i).getPro_para(),String.valueOf(list.get(i).getPro_selfdev()), list.get(i).getPro_image(),list.get(i).getPro_star(),list.get(i).getPro_state());
            listShow.add(show);
        }
        return listShow;
    }

    /**
     * 通过id删除产品
     */
    public boolean deletePro(int id,int state){
        ProductEntity proE =  productMapper.findById(id).get();
        TypeEntity proT = typeMapper.getProType(proE.getPro_type_id());
        proE.setPro_state(state);
        productMapper.saveAndFlush(proE);
            /*ProductShow show = new ProductShow(proE.getId(),proE.getPro_name(),proE.getPro_type_id(),proT.getTy_name(),proE.getPro_spec(),proE.getPro_mate(),proE.getPro_color(),proE.getPro_modle(),proE.getPro_weigth(),proE.getPro_price(),proE.getPro_maprice(),
                    proE.getPro_really(),proE.getPro_desc(),proE.getPro_para(),String.valueOf(proE.getPro_selfdev()), proE.getPro_image(),proE.getPro_star(),proE.getPro_state());*/
        return true;
    }


    /**
     * 添加产品
     */
    public ProductEntity addPro(ProductEntity entity,String imgUrl,int id){
        if (id==0){
            entity.setPro_image(imgUrl);
            return productMapper.saveAndFlush(entity);
        }else {
            entity.setPro_image(imgUrl);
            entity.setId(id);
            return productMapper.saveAndFlush(entity);
        }
    }

    /**
     * 根据型号查询产品
     */
    public ProductEntity selectPro(String modle){
        return productMapper.getProByModle(modle);
    }


}
