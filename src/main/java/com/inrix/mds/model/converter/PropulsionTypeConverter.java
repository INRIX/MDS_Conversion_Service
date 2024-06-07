package com.inrix.mds.model.converter;

import com.inrix.mds.model.enums.PropulsionType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

@Converter(autoApply = true)
public class PropulsionTypeConverter implements AttributeConverter<List<PropulsionType>, String> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<PropulsionType> attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error converting propulsion types to JSON", e);
        }
    }

    @Override
    public List<PropulsionType> convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData, new TypeReference<List<PropulsionType>>() {});
        } catch (IOException e) {
            throw new IllegalArgumentException("Error converting JSON string to list of propulsion types.", e);
        }
    }
}
