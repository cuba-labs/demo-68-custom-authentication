package com.company.demo.web.screens;

import com.haulmont.cuba.web.app.loginwindow.AppLoginWindow;

public class ExtAppLoginWindow extends AppLoginWindow {
    @Override
    protected void doLogin() {
        // we can perform custom login call here
        super.doLogin();
    }
}