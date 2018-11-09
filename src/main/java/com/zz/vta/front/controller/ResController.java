package com.zz.vta.front.controller;

import com.zz.vta.front.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 页面传值路由
 */
@RestController
public class ResController {
    @Autowired
    ProductService productService;
    @Autowired
    AdvertisementService advertisementService;
    @Autowired
    CaseService caseService;
    @Autowired
    HonorService honorService;
    @Autowired
    NewsService newsService;
    @Autowired
    TypeService typeService;

    /**
     * 产品页
     * @return
     */
    @RequestMapping("product")
    public ModelAndView goProduct(ModelAndView m,@RequestParam(value = "tyid",defaultValue = "0")int id,@RequestParam(value = "start",defaultValue = "0") int start,@RequestParam(value = "size",defaultValue = "9")int size){
        if (id==0){
            start = start<0?0:start;
            Sort sort = new Sort(Sort.Direction.DESC, "id");
            Pageable pageable = PageRequest.of(start, size, sort);
            m.addObject("product",productService.getSeProduct(pageable));
            m.addObject("types",typeService.getType());
            m.setViewName("front/product");
        }else {
            m.addObject("productByT",productService.getProByType(id));
            m.addObject("types",typeService.getType());
            m.setViewName("front/product");
        }
        return m;
    }

    /**
     * 首页
     */
    @RequestMapping("/")
    public ModelAndView goIndex(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("listAD",advertisementService.getADAll());
        mv.addObject("listC",caseService.getCaAll());
        mv.addObject("listH",honorService.getHonAll());
        mv.addObject("listP",productService.getProAll());
        mv.addObject("listN",newsService.getNewsAll());
        mv.setViewName("front/index");
        return mv;
    }

    /**
     * 商品详情页
     */
    @RequestMapping("item")
    public ModelAndView goItem(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        mv.addObject("pro",productService.selectPro(request.getParameter("modle")));
        mv.addObject("types",typeService.getType());
        mv.addObject("proList",productService.getProAll());
        mv.setViewName("front/item");
        return mv;
    }

    /**
     * 企业优势页
     */
    @RequestMapping("aboutus")
    public ModelAndView goEnt(){
        return new ModelAndView("front/enterprise","list",productService.getProAll());
    }

    /**
     * 新闻页
     */
    @GetMapping("news")
    public ModelAndView goNews(ModelAndView m,@RequestParam(value = "start",defaultValue = "0") int start,@RequestParam(value = "size",defaultValue = "5")int size){
            start = start<0?0:start;
            Sort sort = new Sort(Sort.Direction.DESC, "id");
            Pageable pageable = PageRequest.of(start, size, sort);
            m.addObject("page",newsService.getSeNews(pageable));
            m.addObject("date",newsService.getNewsData());
            m.setViewName("front/news");
            return m;
    }

    /**
     * 新闻详情
     * @param id
     * @return
     */
    @GetMapping("newdetails")
    public ModelAndView getDetails(@RequestParam(value = "id",defaultValue = "0")int id){
            return new ModelAndView("front/newdetails","news",newsService.getNew(id));
    }

    /**     
     * 案例
     */
    @RequestMapping("comcase")
    public  ModelAndView goComCase(ModelAndView m,@RequestParam(value = "caid",defaultValue = "0")int id){
        m.setViewName("front/comcase");
        if(id==0){
            m.addObject("caselist",caseService.getCaAll());
        }else {
            m.addObject("case",caseService.getCaseById(id));
        }
        return m;
    }

}
