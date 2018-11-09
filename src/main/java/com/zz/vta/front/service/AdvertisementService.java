package com.zz.vta.front.service;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import com.zz.vta.front.db2map.AdvertisementMapper;
import com.zz.vta.front.entity.AdvertisementEntity;
import com.zz.vta.front.frontentity.AdvertisementShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 广告牌转页面实体
 */
@Service
public class AdvertisementService {

    @Autowired
    AdvertisementMapper advertisementMapper;

    /**
     * 广告牌清单
     */
    public List<AdvertisementShow> getADAll(){
        List<AdvertisementEntity> list =  advertisementMapper.findAll();
        List<AdvertisementShow> listAD = new ArrayList<AdvertisementShow>();

        for (int i = 0;i<list.size();i++){
            AdvertisementShow advertisementShow = new AdvertisementShow();
            advertisementShow.setIntAdId(list.get(i).getAd_id());
            advertisementShow.setIntAdState(list.get(i).getAd_state());
            advertisementShow.setStrAdImage(list.get(i).getAd_image());
            advertisementShow.setStrAdRetitle(list.get(i).getAd_retitle());
            advertisementShow.setStrAdText(list.get(i).getAd_text());
            advertisementShow.setStrAdTitle(list.get(i).getAd_title());
            listAD.add(advertisementShow);
        }
        return listAD;
    }
    /**
     *添加广告版
     */
    public void addAdv(AdvertisementEntity entity,String img){
            entity.setAd_image(img);
        advertisementMapper.saveAndFlush(entity);
    }
    /**
     * 删除广告版
     */
    public void delAdv(AdvertisementEntity entity,int state){
        entity.setAd_state(state);
        advertisementMapper.saveAndFlush(entity);
    }


}
