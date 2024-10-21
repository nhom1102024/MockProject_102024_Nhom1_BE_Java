package com.lease_master.specification;

import com.lease_master.model.Unit;
import com.lease_master.service.unit.dtos.UnitSearchDTO;
import com.lease_master.utils.SpecificationUtil;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;

public class UnitSpecification {
    public static Specification<Unit> search(UnitSearchDTO searchDTO) {
        return (root, query, builder) -> {
            Predicate predicate = builder.conjunction();

            SpecificationUtil.addConditionIfNotNull(predicate, builder, root.get("apartment").get("apartment_id"), searchDTO.getApartmentId(), "equal");
            SpecificationUtil.addConditionIfNotNull(predicate, builder, root.get("roomNumber"), searchDTO.getRoomNumber(), "like");
            SpecificationUtil.addConditionIfNotNull(predicate, builder, root.get("floor"), searchDTO.getFloor(), "equal");
            SpecificationUtil.addConditionIfNotNull(predicate, builder, root.get("area"), searchDTO.getArea(), "equal");
            SpecificationUtil.addConditionIfNotNull(predicate, builder, root.get("bedRooms"), searchDTO.getBedRooms(), "equal");
            SpecificationUtil.addConditionIfNotNull(predicate, builder, root.get("bathRooms"), searchDTO.getBathRooms(), "equal");
            SpecificationUtil.addConditionIfNotNull(predicate, builder, root.get("status"), searchDTO.getStatus(), "like");
            SpecificationUtil.addConditionIfNotNull(predicate, builder, root.get("price"), searchDTO.getPrice(), "equal");
            SpecificationUtil.addConditionIfNotNull(predicate, builder, root.get("description"), searchDTO.getDescription(), "like");

            return predicate;
        };
    }
}
