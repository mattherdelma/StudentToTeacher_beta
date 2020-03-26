package com.java.code.model;

import java.util.Date;

/**
 * 管理员模型
 */
public class Administrators {
    private String AdministratorsId;
    private String AdministratorsName;
    private String AdministratorsPassword;
    private String AdministratorsCreateTime;

    public void setAdministratorsId(String administratorsId) {
        AdministratorsId = administratorsId;
    }

    public String getAdministratorsId() {
        return AdministratorsId;
    }

    public void setAdministratorsCreateTime(String administratorsCreateTime) {
        AdministratorsCreateTime = administratorsCreateTime;
    }

    public String getAdministratorsCreateTime() {
        return AdministratorsCreateTime;
    }


    public String getAdministratorsName() {
        return AdministratorsName;
    }

    public String getAdministratorsPassword() {
        return AdministratorsPassword;
    }


    public void setAdministratorsName(String administratorsName) {
        AdministratorsName = administratorsName;
    }

    public void setAdministratorsPassword(String administratorsPassword) {
        AdministratorsPassword = administratorsPassword;
    }
}
