package com.company.demo.web.screens;

import com.haulmont.cuba.security.auth.Credentials;
import com.haulmont.cuba.security.global.LoginException;
import com.haulmont.cuba.web.app.loginwindow.AppLoginWindow;

public class ExtAppLoginWindow extends AppLoginWindow {
    @Override
    protected void doLogin() {
        super.doLogin();
    }

    @Override
    protected void doLogin(Credentials credentials) throws LoginException {
        // add pre-process
        super.doLogin(credentials);
        // add post-process steps
    }
}