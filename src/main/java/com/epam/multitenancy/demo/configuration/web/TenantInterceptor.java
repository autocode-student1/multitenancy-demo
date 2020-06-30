package com.epam.multitenancy.demo.configuration.web;

import com.epam.multitenancy.demo.configuration.tenant.TenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class TenantInterceptor extends HandlerInterceptorAdapter {

    private final TenantService tenantService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String tenantId = request.getParameter("tenantId");
        if (tenantService.knownTenant(tenantId)) {
            TenantHolder.setTenantId(tenantId);
        } else {
            throw new UnknownTenantException();
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        TenantHolder.remove();
    }
}
