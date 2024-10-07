package com.xcure.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CategoryConverter implements AttributeConverter<Category, String> {
    @Override
    public String convertToDatabaseColumn(Category category) {
        return category != null ? category.toString() : null;
    }

    @Override
    public Category convertToEntityAttribute(String dbData) {
        return dbData != null ? Category.valueOf(dbData) : null;
    }
}
