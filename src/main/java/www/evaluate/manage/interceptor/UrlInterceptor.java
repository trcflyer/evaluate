package www.evaluate.manage.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 类描述
 * 
 * @author trc
 * @version 1.0 2018年1月7日 改订
 * @since 1.0
 */
public class UrlInterceptor extends HandlerInterceptorAdapter{
    private static Logger logger = Logger.getLogger(UrlInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
         logger.info("[请求入口]"+request.getRequestURI());
         return true;
    }

}
