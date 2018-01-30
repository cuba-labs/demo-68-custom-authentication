package com.company.demo.web;

import com.haulmont.cuba.security.global.LoginException;
import com.haulmont.cuba.web.Connection;
import com.haulmont.cuba.web.security.ExternalUserCredentials;
import com.haulmont.cuba.web.security.events.AppStartedEvent;
import com.haulmont.cuba.web.sys.RequestContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
public class AutoLoginSsoEventListener implements ApplicationListener<AppStartedEvent> {
    @Override
    public void onApplicationEvent(AppStartedEvent event) {
        HttpSession session = RequestContext.get().getSession();

        if (session != null && session.getAttribute("token") != null) {
            Connection connection = event.getApp().getConnection();
            if (!connection.isAuthenticated()) {
                try {
                    connection.login(new ExternalUserCredentials("admin"));
                } catch (LoginException ignored) {
                } finally {
                    session.removeAttribute("token");
                }
            }
        }
    }
}