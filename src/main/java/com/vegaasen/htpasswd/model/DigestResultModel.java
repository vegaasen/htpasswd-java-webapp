package com.vegaasen.htpasswd.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

/**
 *
 * @author vegaasen
 * @version 1.0-SNAPSHOT
 * @since HTW-004
 */
@XmlRootElement(name = "digest")
@XmlType(name = "digest")
public class DigestResultModel {
    private String userName;
    private String userPassword;
    private HTPasswdVariant selectedDigester;
    private String generatedPassword;
    private Date generatedDate;

    @XmlElement(name = "usr")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @XmlElement(name = "originalPwd")
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @XmlElement(name = "digestType")
    public HTPasswdVariant getSelectedDigester() {
        return selectedDigester;
    }

    public void setSelectedDigester(HTPasswdVariant selectedDigester) {
        this.selectedDigester = selectedDigester;
    }

    @XmlElement(name = "genPwd")
    public String getGeneratedPassword() {
        return generatedPassword;
    }

    public void setGeneratedPassword(String generatedPassword) {
        this.generatedPassword = generatedPassword;
    }

    @XmlElement(name = "genDate")
    public Date getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(Date generatedDate) {
        this.generatedDate = generatedDate;
    }
}
