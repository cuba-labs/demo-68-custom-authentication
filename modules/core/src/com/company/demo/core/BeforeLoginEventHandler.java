package com.company.demo.core;

import com.haulmont.cuba.security.auth.AbstractClientCredentials;
import com.haulmont.cuba.security.auth.events.BeforeLoginEvent;
import com.haulmont.cuba.security.global.LoginException;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;

//todo disabled
//@Component
public class BeforeLoginEventHandler {
    @EventListener
    protected void onBeforeLogin(BeforeLoginEvent event) throws LoginException {
        if (event.getCredentials() instanceof AbstractClientCredentials) {
            if (LocalDate.now().getDayOfWeek() == DayOfWeek.TUESDAY) {
                throw new LoginException("System is unavailable on Tuesday");
            }
        }
    }
}