package com.example.RuuderStack.Server.controller;

import com.example.RuuderStack.Server.model.FormTemplate;
import com.example.RuuderStack.Server.service.AdminService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Controller for admin actions
 */
@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/admin/add")
    @ApiOperation("API to add Source form template")
    public void addSourceFormTemplate(@RequestBody FormTemplate formTemplate) {
        adminService.addSourceFormTemplate(formTemplate);
    }
}
