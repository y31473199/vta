package com.zz.vta.front.service;

import com.zz.vta.front.db2map.HonorMapper;
import com.zz.vta.front.entity.HonorEntity;
import com.zz.vta.front.frontentity.HonorShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class HonorService {

    @Autowired
    HonorMapper honorMapper;

    /**
     * 企业荣誉清单
     */
    public List<HonorShow> getHonAll(){
        List<HonorEntity> list = honorMapper.findAll();
        List<HonorShow> listH = new ArrayList<HonorShow>();
        DateFormat bf = new SimpleDateFormat("yyyy-MM-dd E a ");
        for (int i = 0;i<list.size();i++){
            HonorShow honorShow = new HonorShow();
            honorShow.setStrHonDate(bf.format(list.get(i).getHon_date()));
            honorShow.setIntHonState(list.get(i).getHon_state());
            honorShow.setStrHonImage(list.get(i).getHon_image());
            honorShow.setStrHonName(list.get(i).getHon_name());
            honorShow.setStrHonPlace(list.get(i).getHon_place());
            honorShow.setStrHonTag(list.get(i).getHon_tag());
            honorShow.setStrHonType(list.get(i).getHon_type());
            listH.add(honorShow);
        }
        return listH;
    }
}
