package com.vegaasen.htpasswd.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Set;

/**
 * Simple htpasswd generator Controller
 *
 * todo: a lot.
 *
 * @author vegaasen
 */
@Controller
public class HTPwdController {

    /**
     * Handle requests for processing an htpasswd to be used together with the apache-ftp-server
     * (or in other cases where htpasswd needs to be used)
     *
     * @param request _
     * @param response _
     * @return jsp-mapping
     */
    @RequestMapping(value = "/mordi", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView handleRequestForPasswdGeneration(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView("mordi");
        if(request.getMethod().equals(RequestMethod.POST.name())) {
            if(request.getParameterMap()!=null && request.getParameterNames().hasMoreElements()) {
                String userName = request.getParameter("usr");
            }
        }
        return view;
    }

    @RequestMapping(value = "/download", method = RequestMethod.POST)
    public String handleDownloadRequest(HttpServletRequest request, HttpServletResponse response) {
        return "";
    }

}
