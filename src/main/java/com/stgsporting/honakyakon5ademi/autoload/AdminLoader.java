package com.stgsporting.honakyakon5ademi.autoload;

import com.stgsporting.honakyakon5ademi.dtos.admins.AdminFormDTO;
import com.stgsporting.honakyakon5ademi.services.AdminService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class AdminLoader implements CommandLineRunner {

    private final AdminService adminService;

    AdminLoader(AdminService adminService) {
        this.adminService = adminService;
    }

    @Override
    public void run(String... args) throws Exception {
        if(adminService.getAllAdmins().isEmpty()) {
            AdminFormDTO admin = new AdminFormDTO();

            admin.setUsername("admin");
            admin.setPassword("admin");

            adminService.createAdmin(admin);
        }
    }
}
