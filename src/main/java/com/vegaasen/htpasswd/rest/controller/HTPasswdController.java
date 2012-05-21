package com.vegaasen.htpasswd.rest.controller;

import com.vegaasen.htpasswd.model.DigestResultModel;
import com.vegaasen.htpasswd.model.HTPasswdVariant;
import com.vegaasen.htpasswd.util.HashingDigester;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Simple controller for the rest-based-services for generating htpasswd-results
 *
 * TODO: A lot.
 *
 * @author vegaasen
 * @version 0.1-SNAPSHOT
 * @since HPW-004
 */
@Controller
@RequestMapping(value = "/")
@Transactional()
public class HTPasswdController {

    private static final Logger LOGGER = Logger.getLogger(HTPasswdController.class);

    @SuppressWarnings({"unused", "all"}) private Jaxb2Marshaller jaxMarshaller;

    /**
     * Handle requests for processing an htpasswd to be used together with the apache-ftp-server
     * (or in other cases where htpasswd needs to be used)
     *
     * Called from:
     * http://localhost:{PORT}/rest/generate?usr=USER&pwd=PASSWORD&digestType=CRYPT_TYPE
     *
     * @param request  _
     * @param response _
     * @param usr      UserName
     * @param pwd      Password
     * @param digest   Hashing algorithm
     * @return jsp-mapping
     */
    @RequestMapping(
            value = "generate",
            method = {RequestMethod.GET},
            headers = {"Accept=application/xml"},
            produces = "application/xml"
    )
    public
    @ResponseBody
    DigestResultModel handleGenerateRequest(
            @SuppressWarnings("unused") final HttpServletRequest request,
            @SuppressWarnings("unused") HttpServletResponse response,
            @RequestParam(value = "usr", defaultValue = "") String usr,
            @RequestParam(value = "pwd", defaultValue = "") String pwd,
            @RequestParam(value = "digestType", defaultValue = "ALG_CRYPT") String digest) {
        LOGGER.debug("Creating digestmodel.");
        DigestResultModel model = new DigestResultModel();
        model.setGeneratedDate(new Date());
        if (StringUtils.isNotEmpty(usr) && StringUtils.isNotEmpty(pwd) && StringUtils.isNotEmpty(digest)) {
            HTPasswdVariant htDigest = HTPasswdVariant.find(digest);
            LOGGER.debug("Initiate generation");
            String result = HashingDigester.generateEncryptedPassword(usr, pwd, htDigest);
            model.setUserName(usr);
            model.setUserPassword(pwd);
            model.setSelectedDigester(htDigest);
            model.setGeneratedPassword(result);
        }
        LOGGER.debug("Returning result");
        return model;
    }


    @Autowired
    public void setJaxMarshaller(Jaxb2Marshaller jaxMarshaller) {
        this.jaxMarshaller = jaxMarshaller;
    }

}
