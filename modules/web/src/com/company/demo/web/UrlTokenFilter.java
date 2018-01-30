package com.company.demo.web;

import com.haulmont.cuba.web.security.HttpRequestFilter;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class UrlTokenFilter implements HttpRequestFilter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if ("demo".equals(request.getParameter("token"))) {
            ((HttpServletRequest) request).getSession().setAttribute("token", "true");
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}