package com.inrix.mds.model.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inrix.mds.model.enums.PropulsionType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Converter(autoApply = true)
public class TripIdsConverter implements AttributeConverter<List<UUID>, String> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<UUID> uuids) {
        try {
            return objectMapper.writeValueAsString(uuids);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error converting trip ids to JSON", e);
        }
    }

    @Override
    public List<UUID> convertToEntityAttribute(String s) {
        try {
            return objectMapper.readValue(s, new TypeReference<List<UUID>>() {});
        }
        catch (IOException e) {
            throw new IllegalArgumentException("Error converting JSON string to list of trip ids", e);
        }
    }
}
