package FilterAndInterceptor;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName MyFilter  过滤器
 * @Description
 * @Author Administrator
 * @Date 2020/6/5 0005 10:47
 */
@Component
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("前置");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("处理中");
        chain.doFilter(request,response);

    }

    @Override
    public void destroy() {
        System.out.println("后置");
    }
}
