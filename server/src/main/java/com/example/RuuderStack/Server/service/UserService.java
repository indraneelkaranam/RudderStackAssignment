package com.example.RuuderStack.Server.service;

import com.example.RuuderStack.Server.dao.UserDao;
import com.example.RuuderStack.Server.model.FormTemplate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service class for user
 */
@Service
@AllArgsConstructor
public class UserService {

    private final AdminService adminService;

    private final UserDao userDao;

    /**
     * Method to fetch Form Template By given source Type
     *
     * @param sourceType -- source Type
     * @return -- Form template associated with the source Type
     */
    public FormTemplate getFormTemplateByType(String sourceType) {
        return adminService.getFormTemplateByType(sourceType);
    }

    /**
     * Method to store response posted by the user for a given resource
     *
     * @param userId        -- Id of the user
     * @param sourceType    -- Type of the source
     * @param userResponses -- Responses submitted by user
     */
    public void postSourceResponse(String userId, String sourceType, Map<String, String> userResponses) {
        userDao.postSourceResponse(userId, sourceType, userResponses);
    }

    /**
     * Method to fetch all Source Types
     *
     * @return -- {@List<String> list of source types}
     */
    public List<String> getAllSourceTypes() {
        return adminService.getAllSourceTypes();
    }

    /**
     * Method to fetch responses of the user for given source type
     *
     * @param userId     -- Id of the user
     * @param sourceType -- Type of source
     * @return -- Map<Field, Response>
     */
    public Map<String, String> getSourceResponse(String userId, String sourceType) {
        return userDao.getSourceResponse(userId, sourceType);
    }
}
