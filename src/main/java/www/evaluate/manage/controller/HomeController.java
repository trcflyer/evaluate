package www.evaluate.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类描述
 * 
 * @author trc
 * @version 1.0 2018年1月6日 改订
 * @since 1.0
 */
@Controller
public class HomeController {

    /**
     * 打开首页
     */
    @RequestMapping("/")
    public String showIndex() {
        return "index";
    }
    /**
     * 展示其他页面
     * <p>Title: showpage</p>
     * <p>Description: </p>
     * @param page
     * @return
     */
    @RequestMapping("/{page}")
    public String showpage(@PathVariable String page) {
        return page;
    }
}
