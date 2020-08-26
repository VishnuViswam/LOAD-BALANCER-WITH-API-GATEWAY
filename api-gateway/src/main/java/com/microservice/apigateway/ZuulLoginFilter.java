package com.microservice.apigateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Class which act as a filter , in between API communications
 *
 * @author Vishnu Viswambharan
 * @version 1.0
 * @since 2020-06-01
 */
@Component
public class ZuulLoginFilter extends ZuulFilter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String filterType() {
        return "pre"; // filter before request is executed
        // return "post"; filter after request is executed
        //return "error"; upon request error
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
		logger.info("Request is filtered");
        HttpServletRequest httpServletRequest = RequestContext.getCurrentContext().getRequest();
        logger.info("request -> {} request uri -> {} ",
                httpServletRequest, httpServletRequest.getRequestURI());
        return null;
    }
}
