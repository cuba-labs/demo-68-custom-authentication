package com.company.demo.core;

import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.security.auth.AuthenticationDetails;
import com.haulmont.cuba.security.auth.AuthenticationProvider;
import com.haulmont.cuba.security.auth.Credentials;
import com.haulmont.cuba.security.auth.LoginPasswordCredentials;
import com.haulmont.cuba.security.auth.providers.LoginPasswordAuthenticationProvider;
import com.haulmont.cuba.security.global.LoginException;

import javax.inject.Inject;

//@Component("demo_AdminAuthenticationProvider")
public class AdminAuthenticationProvider extends LoginPasswordAuthenticationProvider
    implements AuthenticationProvider {

    @Inject
    public AdminAuthenticationProvider(Persistence persistence, Messages messages) {
        super(persistence, messages);
    }

    @Override
    public AuthenticationDetails authenticate(Credentials credentials) throws LoginException {
        LoginPasswordCredentials loginAndPassword = (LoginPasswordCredentials) credentials;

        if (!"admin".equals(loginAndPassword.getLogin())) {
            throw new LoginException("Only admin is allowed to login");
        }

        return super.authenticate(credentials);
    }

    @Override
    public int getOrder() {
        return 10;
    }
}