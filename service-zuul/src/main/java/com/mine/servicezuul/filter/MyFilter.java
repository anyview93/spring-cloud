package com.mine.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author shizhiguo
 * @ClassName MyFilter
 * @date 2019-05-04
 */
@Component
public class MyFilter extends ZuulFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        LOGGER.info(String.format("%s >>> %s",request.getMethod(),request.getRequestURL().toString()));
        String token = request.getParameter("token");
        if(token == null || token.trim().length() == 0){
            LOGGER.warn("token is impty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try{
                ctx.getResponse().getWriter().write("token is empty");
            } catch (Exception e){
                LOGGER.error(e.getMessage());
            }
            return null;
        }
        LOGGER.info("ok");
        return null;
    }
}
