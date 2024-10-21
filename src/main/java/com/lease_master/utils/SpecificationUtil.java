package com.lease_master.utils;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;

public class SpecificationUtil {

    public static void addConditionIfNotNull(Predicate predicate, CriteriaBuilder builder, Path<?> path, Object value, String type) {
        if (value != null) {
            switch (type) {
                case "like":
                    predicate.getExpressions().add(builder.like(path.as(String.class), "%" + value + "%"));
                    break;
                case "equal":
                    predicate.getExpressions().add(builder.equal(path, value));
                    break;
            }
        }
    }
}
