package com.example.sandbox.hibernatespringboot.model.converters;

import javax.persistence.AttributeConverter;

public class BooleanToYNStringConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean b) {
        return b != null && b ? "Y" : "N";
    }

    @Override
    public Boolean convertToEntityAttribute(String s) {
        return "y".equalsIgnoreCase(s);
    }
}
