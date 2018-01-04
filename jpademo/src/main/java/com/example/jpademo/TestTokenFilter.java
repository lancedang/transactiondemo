package com.example.jpademo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Slf4j
@Order(20)
public class TestTokenFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("testTokenFilter");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        request.setAttribute("isValid", true);
        chain.doFilter(httpServletRequest, response);
    }

    @Override
    public void destroy() {

    }
}
