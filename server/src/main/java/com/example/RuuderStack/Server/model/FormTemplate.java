package com.example.RuuderStack.Server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormTemplate {

    private String type;

    private Map<String, Object> fields;
}
