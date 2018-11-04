package com.zz.vta.front.controller;

        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 路径跳转（路由）
 */
@Controller
public class RouteController {








    /**
     * 论坛博客
     * @return
     */
    @RequestMapping("blog.html")
    public String goBlog(){
        return "news";
    }



    /**
     * 售后服务
     * @return
     */
    @RequestMapping("saled")
    public String goSaled(){
        return  "front/saled";
    }

}
