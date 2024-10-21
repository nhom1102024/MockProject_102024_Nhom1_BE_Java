package com.lease_master.specification;

import com.lease_master.model.Contract;
import com.lease_master.service.contract.dtos.ContractSearchDTO;
import com.lease_master.utils.SpecificationUtil;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;

public class ContractSpecification {
    public static Specification<Contract> search(ContractSearchDTO searchDTO) {
        return (root, query, builder) -> {
            Predicate predicate = builder.conjunction();

            if (searchDTO.getServiceName() != null) {
                predicate.getExpressions().add(
                        builder.like(root.join("service").get("serviceName"), "%" + searchDTO.getServiceName() + "%")
                );
            }
            if (searchDTO.getCustomerName() != null) {
                predicate.getExpressions().add(
                        builder.like(root.join("customer").join("user").get("fullName"), "%" + searchDTO.getCustomerName() + "%")
                );
            }
            if (searchDTO.getRoomNumber() != null) {
                predicate.getExpressions().add(
                        builder.like(root.join("customer").join("unit").get("roomNumber"), "%" + searchDTO.getRoomNumber() + "%")
                );
            }
            SpecificationUtil.addConditionIfNotNull(predicate, builder, root.get("startDate"), searchDTO.getStartDate(), "equal");
            SpecificationUtil.addConditionIfNotNull(predicate, builder, root.get("endDate"), searchDTO.getEndDate(), "equal");
            SpecificationUtil.addConditionIfNotNull(predicate, builder, root.get("contractTerms"), searchDTO.getContractTerms(), "like");
            SpecificationUtil.addConditionIfNotNull(predicate, builder, root.get("specialTerms"), searchDTO.getSpecialTerms(), "like");
            SpecificationUtil.addConditionIfNotNull(predicate, builder, root.get("amount"), searchDTO.getAmount(), "equal");
            SpecificationUtil.addConditionIfNotNull(predicate, builder, root.get("status"), searchDTO.getStatus(), "like");

            return predicate;
        };
    }
}