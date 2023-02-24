package com.example.RuuderStack.Server.dao;

import com.example.RuuderStack.Server.exception.SourceNotFoundException;
import com.example.RuuderStack.Server.model.FormTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Dao class for Form Templates
 */
@Repository
public class AdminDao {

    final Map<String, Map<String, Object>> formTemplateMap;

    AdminDao() {
        formTemplateMap = new HashMap<>();
    }

    /**
     * Method to add Source form Template to data base, if source type already exists, it replaces
     *
     * @param formTemplate -- form template by admin
     */
    public void addSourceFormTemplate(FormTemplate formTemplate) {
        formTemplateMap.computeIfAbsent(formTemplate.getType(),
                (k -> new HashMap<>()));
        formTemplateMap.put(formTemplate.getType(), formTemplate.getFields());
    }

    /**
     * Method to fetch Form Template By given source Type
     *
     * @param sourceType -- source Type
     * @return -- Form template associated with the source Type
     */
    public FormTemplate getFormTemplateByType(String sourceType) {
        if (!formTemplateMap.containsKey(sourceType))
            throw new SourceNotFoundException("Source is not available in Database");
        return new FormTemplate(sourceType, formTemplateMap.get(sourceType));
    }

    /**
     * Method to fetch all Source Types
     *
     * @return -- {@List<String> list of source types}
     */
    public List<String> getAllSourceTypes() {
        return formTemplateMap.keySet().stream().toList();
    }
}
