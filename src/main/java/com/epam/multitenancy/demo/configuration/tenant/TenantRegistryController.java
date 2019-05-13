package com.epam.multitenancy.demo.configuration.tenant;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class TenantRegistryController {

    private final TenantService tenantService;

    @GetMapping
    public String registerPage() {
        return "register";
    }

    @PostMapping("register")
    public ModelAndView registerTenant(@RequestParam("tenantId") String tenantId,
                                       @RequestParam("barbers") String barbers) {
        Tenant registeredTenant = tenantService.registerTenant(tenantId, barbers);
        ModelAndView mav = new ModelAndView("register");
        mav.addObject("registeredTenantId", registeredTenant.getId());
        return mav;
    }
}