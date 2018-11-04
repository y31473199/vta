package com.zz.vta.front.service;

import com.zz.vta.front.db2map.TypeMapper;
import com.zz.vta.front.entity.TypeEntity;
import com.zz.vta.front.frontentity.TypeShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeService{

    @Autowired
    TypeMapper typeMapper;
    /**
     * 类别清单
     */
    public List<TypeShow> getType(){
        List<TypeEntity> list = typeMapper.findAll();
        List<TypeShow> listS = new ArrayList<TypeShow>();
        for (int i = 0;list.size()>i;i++){
            listS.add(new TypeShow(list.get(i).getTy_id(),list.get(i).getTy_name(),list.get(i).getTy_state(),list.get(i).getTy_leave()));
        }
        return listS;
    }

}
