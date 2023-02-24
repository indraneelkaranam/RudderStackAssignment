package com.example.RuuderStack.Server.service;

import com.example.RuuderStack.Server.dao.AdminDao;
import com.example.RuuderStack.Server.model.FormTemplate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for admin
 */
@Service
@AllArgsConstructor
public class AdminService {

    private final AdminDao adminDao;

    /**
     * Method to add Source form Template to data base, if source type already exists, it replaces
     *
     * @param formTemplate -- form template by admin
     */
    public void addSourceFormTemplate(FormTemplate formTemplate) {
        adminDao.addSourceFormTemplate(formTemplate);
    }

    /**
     * Method to fetch Form Template By given source Type
     *
     * @param sourceType -- source Type
     * @return -- Form template associated with the source Type
     */
    public FormTemplate getFormTemplateByType(String sourceType) {
        return adminDao.getFormTemplateByType(sourceType);
    }

    /**
     * Method to fetch all Source Types
     *
     * @return -- {@List<String> list of source types}
     */
    public List<String> getAllSourceTypes() {
        return adminDao.getAllSourceTypes();
    }
}
