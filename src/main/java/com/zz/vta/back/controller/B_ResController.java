package com.zz.vta.back.controller;

import com.alibaba.fastjson.JSONObject;
import com.zz.vta.back.resentity.RespCode;
import com.zz.vta.back.resentity.RespEntity;
import com.zz.vta.front.entity.ProductEntity;
import com.zz.vta.front.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static com.zz.vta.back.resentity.RespCode.SUCCESS;

/**
 * 路径跳转（路由）
 */
@Controller
public class B_ResController {
    @Autowired
    AdminService adminService;
    @Autowired
    ProductService productService;
    @Autowired
    NewsService newsService;
    @Autowired
    AdvertisementService advertisementService;
    @Autowired
    CaseService caseService;
    /**
     * 首页
     * @return
     */
    @RequestMapping("admin")
    public ModelAndView goIndex(ModelAndView mv,HttpServletRequest request){
        if (request.getSession().getAttribute("user")==null){
            mv.setViewName("back/login");
        }else {
            mv.addObject("listp",productService.getProAll());
            mv.addObject("lintn",newsService.getNewsAll());
            mv.addObject("listadv",advertisementService.getADAll());
            mv.addObject("listcase",caseService.getCaAll());
            mv.setViewName("back/index");
        }
        return mv;
    }

    /**
     * 登录页路由
     */
    @RequestMapping("login")
    public ModelAndView goLogin(ModelAndView mv){
        mv.setViewName("back/login");
        return mv;
    }
    /**
     * 管理员ajax验证
     */
    @PostMapping(value = "clogin" ,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public RespEntity cLogin( HttpServletRequest request,@RequestBody JSONObject json){
        if(adminService.checkLogin(json.getString("user"),json.getString("passwd"))){
            request.getSession().setAttribute("user",json.getString("passwd"));
            return new RespEntity(RespCode.SUCCESS);
        }else {
            return new RespEntity(RespCode.FAIL);
        }
    }
    /**
     *编辑页
     */
    @RequestMapping("edit")
    public ModelAndView goEdit(HttpServletRequest request,ModelAndView mv){
        if (request.getSession().getAttribute("user")==null){
            mv.setViewName("back/login");
        }else {
            if (request.getParameter("idn")!=null){
                mv.addObject("prod",productService.getPro(Integer.valueOf(request.getParameter("idn"))));
                mv.addObject("state","noedit");
                mv.setViewName("back/edit");
            }else if (request.getParameter("ide")!=null){
                mv.addObject("prod",productService.getPro(Integer.valueOf(request.getParameter("ide"))));
                mv.addObject("state","edit");
                mv.setViewName("back/edit");
            }else if (request.getParameter("idr")!=null){
                if (productService.deletePro(Integer.valueOf(request.getParameter("idr")))){
                    mv.addObject("state","success");
                }else {
                    mv.addObject("state","faild");
                }
                mv.addObject("listp",productService.getProAll());
                mv.addObject("state","remove");
                mv.setViewName("back/list");
            }else if (request.getParameter("add")!=null){
                mv.addObject("state","add");
                mv.setViewName("back/edit");
            }

        }
        return mv;
    }
    /**
     * 添加产品路由
     */
    @RequestMapping("add")
    public ModelAndView addPro(HttpServletRequest request,ModelAndView mv, ProductEntity productEntity){
        if (request.getSession().getAttribute("user")==null){
            mv.setViewName("back/login");
        }else {
            mv.addObject("prod",productService.addPro(productEntity));
            mv.addObject("state","noedit");
            mv.setViewName("back/edit");
        }
        return mv;
    }

    /**
     *列表页
     */
    @RequestMapping("list")
    public ModelAndView goList(HttpServletRequest request, ModelAndView mv){
        if (request.getSession().getAttribute("user")==null){
            mv.setViewName("back/login");
        }else {
            mv.addObject("listp",productService.getProAll());
            mv.setViewName("back/list");
        }
        return mv;
    }

}
