package com.example.RuuderStack.Server.dao;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Dao class for Storing user responses Map
 */
@Repository
public class UserDao {

    Map<String, Map<String, Map<String, String>>> userSourceResponseMap; // Map<user id, Map<source type, Map<field, tag>>>

    UserDao() {
        userSourceResponseMap = new HashMap<>();
    }

    /**
     * Method to store response posted by the user for a given resource
     *
     * @param userId        -- Id of the user
     * @param sourceType    -- Type of the source
     * @param userResponses -- Responses submitted by user
     */
    public void postSourceResponse(String userId, String sourceType, Map<String, String> userResponses) {
        userSourceResponseMap.computeIfAbsent(userId, (k -> new HashMap<>())).computeIfAbsent(sourceType,
                (k -> new HashMap<>()));
        // test this
        Map<String, Map<String, String>> sourceTypeResponseMap = userSourceResponseMap.get(userId);
        sourceTypeResponseMap.put(sourceType, userResponses);
        userSourceResponseMap.put(userId, sourceTypeResponseMap);
    }

    /**
     * Method to fetch responses of the user for given source type
     *
     * @param userId     -- Id of the user
     * @param sourceType -- Type of source
     * @return -- Map<Field, Response>
     */
    public Map<String, String> getSourceResponse(String userId, String sourceType) {
        return userSourceResponseMap.getOrDefault(userId, new HashMap<>()).getOrDefault(sourceType, new HashMap<>());
    }
}
