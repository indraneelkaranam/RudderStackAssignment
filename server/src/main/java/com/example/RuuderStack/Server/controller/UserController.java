package com.example.RuuderStack.Server.controller;

import com.example.RuuderStack.Server.model.FormTemplate;
import com.example.RuuderStack.Server.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Controller for admin actions
 */
@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;

    @GetMapping("/formTemplate/{sourceType}")
    @ApiOperation("API to get form template by given source type")
    public FormTemplate getFormTemplateByType(@PathVariable String sourceType) {
        return userService.getFormTemplateByType(sourceType);
    }

    @PostMapping("/sourceType/{sourceType}/user/{userId}")
    @ApiOperation("API to post response for a source type by a user Id")
    public void postSourceResponse(@PathVariable String userId, @PathVariable String sourceType,
                                   @RequestBody Map<String,String> userResponses) {
        userService.postSourceResponse(userId, sourceType, userResponses);
    }

    @GetMapping("/sourceType/{sourceType}/user/{userId}")
    @ApiOperation("API to get responses by userId for given source type")
    public Map<String, String> getSourceResponse(@PathVariable String userId, @PathVariable String sourceType) {
        return userService.getSourceResponse(userId, sourceType);
    }

    @GetMapping("/sourceTypes")
    @ApiOperation("API to fetch list if source types")
    public List<String> getSourceTypes() {
        return userService.getAllSourceTypes();
    }
}
