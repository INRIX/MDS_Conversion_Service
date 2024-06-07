package com.inrix.mds.model.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inrix.mds.model.enums.EventType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.io.IOException;
import java.util.List;
@Converter(autoApply = true)

public class EventTypeConverter implements AttributeConverter<List<EventType>, String> {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public String convertToDatabaseColumn(List<EventType> eventTypes) {
        try {
            return objectMapper.writeValueAsString(eventTypes);
        }
        catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error converting event types to JSON", e);
        }
    }

    @Override
    public List<EventType> convertToEntityAttribute(String s) {
        try {
            return objectMapper.readValue(s, new TypeReference<List<EventType>>() {});
        }
        catch (IOException e) {
            throw new IllegalArgumentException("Error converting JSON string to list of event types", e);
        }
    }
}
