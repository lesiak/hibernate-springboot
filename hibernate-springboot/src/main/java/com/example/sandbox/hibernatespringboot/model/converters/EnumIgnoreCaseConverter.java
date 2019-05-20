package com.example.sandbox.hibernatespringboot.model.converters;

import com.example.sandbox.hibernatespringboot.model.HasCustomName;

import javax.persistence.AttributeConverter;

public abstract class EnumIgnoreCaseConverter<E extends Enum<E> & HasCustomName> implements AttributeConverter<E, String> {

    Class<E> clazz;

    public EnumIgnoreCaseConverter(Class<E> clazz) {
        this.clazz = clazz;
    }

    @Override
    public String convertToDatabaseColumn(E attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getCustomName();
    }

    @Override
    public E convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }
        for (E enumVal : clazz.getEnumConstants()) {
            if (enumVal.getCustomName().equalsIgnoreCase(value)) {
                return enumVal;
            }
        }
        throw new IllegalArgumentException("Unknown enum value: " + value + " not in enum " + clazz.getSimpleName());
    }
}
