package com.epam.multitenancy.demo.configuration.web;

public class TenantHolder {

    private static final ThreadLocal<String> TENANT_ID = new ThreadLocal<>();

    public static String getTenantId() {
        return TENANT_ID.get();
    }

    static void setTenantId(String tenantId) {
        TENANT_ID.set(tenantId);
    }

    static void remove() {
        TENANT_ID.remove();
    }
}
