package com.api.videosharingplatform.service.validator;

import com.api.videosharingplatform.service.annotations.UniqueValue;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {
    @PersistenceContext
    private EntityManager entityManager;

    private Class<?> className;

    private String field;

    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        className = constraintAnnotation.domainClass();
        field = constraintAnnotation.fieldName();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        List<?> list = entityManager.createQuery("select 1 from " + className.getName() + " where " + field + "=:value")
                .setParameter("value", value)
                .getResultList();
        if (value == null || list.size() > 0) {
            return true;
        }
        return false;
    }
}
