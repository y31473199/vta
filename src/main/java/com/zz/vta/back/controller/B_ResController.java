package com.zz.vta.back.controller;

import com.alibaba.fastjson.JSONObject;
import com.zz.vta.back.resentity.RespCode;
import com.zz.vta.back.resentity.RespEntity;
import com.zz.vta.front.db2map.AdvertisementMapper;
import com.zz.vta.front.db2map.CaseMapper;
import com.zz.vta.front.db2map.NewsMapper;
import com.zz.vta.front.db2map.ProductMapper;
import com.zz.vta.front.entity.AdvertisementEntity;
import com.zz.vta.front.entity.CaseEntity;
import com.zz.vta.front.entity.NewsEntity;
import com.zz.vta.front.entity.ProductEntity;
import com.zz.vta.front.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

/**
 * 路径跳转（路由）
 */
@Controller
public class B_ResController {

    private static final String UPLOADED_PRO = "/home/alan/Public/vta/src/main/resources/static/front/media/products/";
    private static final String UPLOADED_NEWS = "/home/alan/Public/vta/src/main/resources/static/front/media/news/";
    private static final String UPLOADED_CASE = "/home/alan/Public/vta/src/main/resources/static/front/media/case/";
    private static final String UPLOADED_ADV = "/home/alan/Public/vta/src/main/resources/static/front/media/adv/";
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
    @Autowired
    TypeService typeService;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    NewsMapper newsMapper;
    @Autowired
    CaseMapper caseMapper;
    @Autowired
    AdvertisementMapper advertisementMapper;
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
     *产品编辑页
     */
    @RequestMapping("edit")
    public ModelAndView goEdit(HttpServletRequest request,ModelAndView mv){
        if (request.getSession().getAttribute("user")==null){
            mv.setViewName("back/login");
        }else {
            if (request.getParameter("idn")!=null){
                mv.addObject("prod",productService.getPro(Integer.valueOf(request.getParameter("idn"))));
                mv.addObject("ProductEntity",new ProductEntity());
                mv.addObject("state","noedit");
                mv.setViewName("back/edit");
            }else if (request.getParameter("ide")!=null){
                mv.addObject("prod",productService.getPro(Integer.valueOf(request.getParameter("ide"))));
                mv.addObject("typel",typeService.getType());
                mv.addObject("state","edit");
                ProductEntity entity =  productMapper.findById(Integer.valueOf(request.getParameter("ide"))).get();
                mv.addObject("ids",entity.getId());
                mv.addObject("ProductEntity",entity);
                mv.setViewName("back/edit");
            }else if (request.getParameter("idr")!=null){
                if (productService.deletePro(Integer.valueOf(request.getParameter("idr")),Integer.valueOf(request.getParameter("state")))){
                    mv.addObject("state","success");
                }else {
                    mv.addObject("state","faild");
                }
                mv.addObject("listp",productService.getProAll());
                mv.addObject("state","remove");
                mv.setViewName("back/list");
            }else if (request.getParameter("add")!=null){
                mv.addObject("ids","0");
                mv.addObject("state","add");
                mv.addObject("typel",typeService.getType());
                mv.addObject("ProductEntity",new ProductEntity());
                mv.setViewName("back/edit");
            }
        }
        return mv;
    }

    /**
     * 新闻列表页
     */
    @RequestMapping("newslist")
    public ModelAndView goNewsList(HttpServletRequest request, ModelAndView mv){
        if (request.getSession().getAttribute("user")==null){
            mv.setViewName("back/login");
        }else {
            mv.addObject("listn",newsService.getNewsAll());
            mv.setViewName("back/newslist");
        }
        return mv;
    }

    /**
     * 案例列表页
     */
    @RequestMapping("caselist")
    public ModelAndView goCaseList(HttpServletRequest request, ModelAndView mv){
        if (request.getSession().getAttribute("user")==null){
            mv.setViewName("back/login");
        }else {
            mv.addObject("listc",caseService.getCaAll());
            mv.setViewName("back/caselist");
        }
        return mv;
    }

    /**
     * 新闻编辑页
     */
    @RequestMapping("newsedit")
    public ModelAndView goNewsEdit(HttpServletRequest request,ModelAndView mv){
        if (request.getSession().getAttribute("user")==null){
            mv.setViewName("back/login");
        }else {
            if (request.getParameter("idn")!=null){
                mv.addObject("news",newsService.getNew(Integer.valueOf(request.getParameter("idn"))));
                mv.addObject("NewsEntity",newsMapper.findById(Integer.valueOf(request.getParameter("idn"))));
                mv.addObject("state","noedit");
                mv.setViewName("back/newsedit");
            }else if (request.getParameter("ide")!=null){
                NewsEntity entity =  newsMapper.findById(Integer.valueOf(request.getParameter("ide"))).get();
                mv.addObject("news",newsService.getNew(Integer.valueOf(request.getParameter("ide"))));
                mv.addObject("state","edit");
                mv.addObject("ids",entity.getId());
                mv.addObject("NewsEntity",entity);
                mv.setViewName("back/newsedit");
            }else if (request.getParameter("idr")!=null){
                newsService.deleteNews(Integer.valueOf(request.getParameter("idr")),Integer.valueOf(request.getParameter("state")));
                mv.addObject("listn",newsService.getNewsAll());
                mv.addObject("state","remove");
                mv.addObject("NewsEntity",new NewsEntity());
                mv.setViewName("back/newslist");
            }else if (request.getParameter("add")!=null){
                mv.addObject("state","add");
                mv.addObject("ids","0");
                mv.addObject("NewsEntity",new NewsEntity(new Date()));
                mv.setViewName("back/newsedit");
            }
        }
        return mv;
    }
    /**
     * 广告版编辑页
     */
    @RequestMapping("advedit")
    public ModelAndView goHonorEdit(HttpServletRequest request,ModelAndView mv){
        if (request.getSession().getAttribute("user")==null){
            mv.setViewName("back/login");
        }else {
            if (request.getParameter("idn")!=null){
                mv.addObject("show",advertisementMapper.findById(Integer.valueOf(request.getParameter("idn"))).get());
                mv.addObject("entity",advertisementMapper.findById(Integer.valueOf(request.getParameter("idn"))).get());
                mv.addObject("state","noedit");
                mv.setViewName("back/advedit");
            }else if (request.getParameter("ide")!=null){
                AdvertisementEntity entity = advertisementMapper.findById(Integer.valueOf(request.getParameter("ide"))).get();
                mv.addObject("show",entity);
                mv.addObject("ids",entity.getAd_id());
                mv.addObject("state","edit");
                mv.addObject("entity",entity);
                mv.setViewName("back/advedit");
            }else if (request.getParameter("idr")!=null){
                advertisementService.delAdv(advertisementMapper.findById(Integer.valueOf(request.getParameter("idr"))).get(),Integer.valueOf(request.getParameter("state")));
                mv.addObject("lista",advertisementService.getADAll());
                mv.addObject("state","remove");
                mv.addObject("entity",new AdvertisementEntity());
                mv.setViewName("back/advlist");
            }else if (request.getParameter("add")!=null){
                mv.addObject("ids","0");
                mv.addObject("state","add");
                mv.addObject("entity",new AdvertisementEntity());
                mv.setViewName("back/advedit");
            }
        }
        return mv;
    }
    /**
     * 案例编辑页
     */
    @RequestMapping("caseedit")
    public ModelAndView goCaseEdit(HttpServletRequest request,ModelAndView mv){
        if (request.getSession().getAttribute("user")==null){
            mv.setViewName("back/login");
        }else {
            if (request.getParameter("idn")!=null){
                mv.addObject("show",caseService.getCaseById(Integer.valueOf(request.getParameter("idn"))));
                mv.addObject("entity",caseMapper.findById(Integer.valueOf(request.getParameter("idn"))).get());
                mv.addObject("state","noedit");
                mv.setViewName("back/caseedit");
            }else if (request.getParameter("ide")!=null){
                CaseEntity entity = caseMapper.findById(Integer.valueOf(request.getParameter("ide"))).get();
                mv.addObject("ids",entity.getCase_id());
                mv.addObject("show",caseService.getCaseById(Integer.valueOf(request.getParameter("ide"))));
                mv.addObject("state","edit");
                mv.addObject("entity",entity);
                mv.setViewName("back/caseedit");
            }else if (request.getParameter("idr")!=null){
                CaseEntity entity = caseMapper.findById(Integer.valueOf(request.getParameter("idr"))).get();
                caseService.delCase(entity,Integer.valueOf(request.getParameter("state")));
                mv.addObject("listc",caseService.getCaAll());
                mv.addObject("state","remove");
                mv.addObject("entity",new CaseEntity());
                mv.setViewName("back/caselist");
            }else if (request.getParameter("add")!=null){
                mv.addObject("ids","0");
                mv.addObject("state","add");
                mv.addObject("entity",new CaseEntity());
                mv.setViewName("back/caseedit");
            }
        }
        return mv;
    }
    /**
     * 添加广告版
     */
    @RequestMapping("addadv")
    public ModelAndView addAdv(HttpServletRequest request,ModelAndView mv,AdvertisementEntity entity,@RequestParam("img") MultipartFile file){
        if (request.getSession().getAttribute("user")==null){
            mv.setViewName("back/login");
        }else {
            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_PRO + file.getOriginalFilename());
                Files.write(path, bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
            entity.setAd_id(Integer.valueOf(request.getParameter("ids")));
            mv.addObject("state","success");
            if (file.getOriginalFilename()==null||file.getOriginalFilename()==" "||file.getOriginalFilename().isEmpty()){
                advertisementService.addAdv(entity,request.getParameter("imge"));
            }else {
                advertisementService.addAdv(entity,file.getOriginalFilename());
            }
            mv.addObject("lista",advertisementService.getADAll());
            mv.setViewName("back/advlist");
        }
        return mv;
    }
    /**
     * 添加案例
     */
    @RequestMapping("addcase")
    public ModelAndView addCase(HttpServletRequest request,ModelAndView mv,CaseEntity entity,@RequestParam("img") MultipartFile file){
        if (request.getSession().getAttribute("user")==null){
            mv.setViewName("back/login");
        }else {
            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_CASE + file.getOriginalFilename());
                Files.write(path, bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (file.getOriginalFilename()==null||file.getOriginalFilename()==" "||file.getOriginalFilename().isEmpty()){
                caseService.addCase(entity,request.getParameter("imge"),Integer.valueOf(request.getParameter("ids")));
            }else {
                caseService.addCase(entity,file.getOriginalFilename(),Integer.valueOf(request.getParameter("ids")));
            }
            mv.addObject("state","success");
            mv.addObject("listc",caseService.getCaAll());
            mv.setViewName("back/caselist");
        }
        return mv;
    }
    /**
     * 添加产品路由
     */
    @RequestMapping("add")
    public ModelAndView addPro(HttpServletRequest request,ModelAndView mv,ProductEntity productEntity,@RequestParam("img") MultipartFile file){
        if (request.getSession().getAttribute("user")==null){
            mv.setViewName("back/login");
        }else {
            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_PRO + file.getOriginalFilename());
                Files.write(path, bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
            mv.addObject("state","add");
            productService.addPro(productEntity,file.getOriginalFilename(),Integer.valueOf(request.getParameter("ids")));
            mv.addObject("listp",productService.getProAll());
            mv.setViewName("back/list");
        }
        return mv;
    }

    /**
     *添加新闻
     */
    @RequestMapping("addnews")
    public ModelAndView addNews(HttpServletRequest request,ModelAndView mv,NewsEntity newsEntity,@RequestParam("img") MultipartFile file){
        if (request.getSession().getAttribute("user")==null){
            mv.setViewName("back/login");
        }else {
            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_NEWS + file.getOriginalFilename());
                Files.write(path, bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
            mv.addObject("state","success");
            if (file.getOriginalFilename()==null||file.getOriginalFilename()==" "||file.getOriginalFilename().isEmpty()){
                newsService.addNews(newsEntity,request.getParameter("imge"),Integer.valueOf(request.getParameter("ids")));
            }else {
                newsService.addNews(newsEntity,file.getOriginalFilename(),Integer.valueOf(request.getParameter("ids")));
            }

            mv.addObject("listn",newsService.getNewsAll());
            mv.setViewName("back/newslist");
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
    /**
     * 广告版列表页
     */
    @RequestMapping("advlist")
    public ModelAndView goAdvList(HttpServletRequest request, ModelAndView mv){
        if (request.getSession().getAttribute("user")==null){
            mv.setViewName("back/login");
        }else {
            mv.addObject("lista",advertisementService.getADAll());
            mv.setViewName("back/advlist");
        }
        return mv;
    }

}
