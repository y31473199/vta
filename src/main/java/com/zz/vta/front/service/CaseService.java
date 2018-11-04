package com.zz.vta.front.service;

import com.zz.vta.front.db2map.CaseMapper;
import com.zz.vta.front.entity.CaseEntity;
import com.zz.vta.front.frontentity.CaseShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 案例转页面实体
 */
@Service
public class CaseService {

    @Autowired
    CaseMapper caseMapper;

    DateFormat bf = new SimpleDateFormat("yyyy年MM-dd");
    /**
     * 案例清单
     * @return
     */
    public List<CaseShow> getCaAll(){
        List<CaseEntity> list = caseMapper.findAll();
        List<CaseShow> listC = new ArrayList<CaseShow>();
        for (int i = 0;i<list.size();i++){
            CaseShow caseShow = new CaseShow();
            caseShow.setIntCaseId(list.get(i).getCase_id());
            caseShow.setDateCaseDate(bf.format(list.get(i).getCase_date()));
            caseShow.setIntCaseState(list.get(i).getCase_state());
            caseShow.setStrCaseDesc(list.get(i).getCase_desc());
            caseShow.setStrCaseImage(list.get(i).getCase_image());
            caseShow.setStrCasePlace(list.get(i).getCase_place());
            caseShow.setStrCaseText(list.get(i).getCase_text());
            caseShow.setStrCaseTitle(list.get(i).getCase_title());
            listC.add(caseShow);
        }
        return listC;
    }

    /**
     * 根据id查询案例
     */
    public CaseShow getCaseById(int id){
        CaseEntity c =  caseMapper.findById(id).get();
        CaseShow caseShow = new CaseShow();
        caseShow.setIntCaseId(id);
        caseShow.setDateCaseDate(bf.format(c.getCase_date()));
        caseShow.setIntCaseState(c.getCase_state());
        caseShow.setStrCaseDesc(c.getCase_desc());
        caseShow.setStrCaseImage(c.getCase_image());
        caseShow.setStrCasePlace(c.getCase_place());
        caseShow.setStrCaseText(c.getCase_text());
        caseShow.setStrCaseTitle(c.getCase_title());
        return caseShow;
    }

}
