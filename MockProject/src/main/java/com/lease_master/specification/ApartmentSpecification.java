package com.lease_master.specification;

import com.lease_master.model.Apartment;
import com.lease_master.service.apartment.dtos.ApartmentSearchDTO;
import com.lease_master.utils.SpecificationUtil;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;

public class ApartmentSpecification {

    public static Specification<Apartment> search(ApartmentSearchDTO searchDTO) {
        return (root, query, builder) -> {
            Predicate predicate = builder.conjunction();

            SpecificationUtil.addConditionIfNotNull(predicate, builder, root.get("apartmentName"), searchDTO.getApartmentName(), "like");
            SpecificationUtil.addConditionIfNotNull(predicate, builder, root.get("location"), searchDTO.getLocation(), "like");
            SpecificationUtil.addConditionIfNotNull(predicate, builder, root.get("buildYear"), searchDTO.getBuildYear(), "equal");
            SpecificationUtil.addConditionIfNotNull(predicate, builder, root.get("numberOfFloors"), searchDTO.getNumberOfFloors(), "equal");
            SpecificationUtil.addConditionIfNotNull(predicate, builder, root.get("numberOfUnits"), searchDTO.getNumberOfUnits(), "equal");
            SpecificationUtil.addConditionIfNotNull(predicate, builder, root.get("status"), searchDTO.getStatus(), "like");

            return predicate;
        };
    }
}
