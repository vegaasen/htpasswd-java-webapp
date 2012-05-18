package com.vegaasen.htpasswd.web.util.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Simple Filter that passes all static content to the containers default servlet
 * E.g:
 * -js
 * -css
 * -images
 *
 * @author vegaasen
 * @since 1.0-SNAPSHOT
 */
public class StaticContentFilter implements Filter {
    
    private static final String DEFAULT_SERVLET_NAME = "default";

    private ServletContext servletContext;

    public void destroy() {}

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        servletContext.getNamedDispatcher(DEFAULT_SERVLET_NAME).forward(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        servletContext = config.getServletContext();
    }

}
