package com.be.specification;

import com.be.model.Provider;
import com.be.service.provider.dtos.ProviderSearchDTO;
import com.be.utils.SpecificationUtil;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;

public class ProviderSpecification {

    public static Specification<Provider> search(ProviderSearchDTO searchDTO) {
        return (root, query, builder) -> {
            Predicate predicate = builder.conjunction();

            SpecificationUtil.addConditionIfNotNull(predicate, builder, root.get("providerName"), searchDTO.getProviderName(), "like");
            SpecificationUtil.addConditionIfNotNull(predicate, builder, root.get("contactPerson"), searchDTO.getContactPerson(), "like");
            SpecificationUtil.addConditionIfNotNull(predicate, builder, root.get("phoneNumber"), searchDTO.getPhoneNumber(), "like");
            SpecificationUtil.addConditionIfNotNull(predicate, builder, root.get("email"), searchDTO.getEmail(), "like");
            SpecificationUtil.addConditionIfNotNull(predicate, builder, root.get("address"), searchDTO.getAddress(), "like");
            SpecificationUtil.addConditionIfNotNull(predicate, builder, root.get("status"), searchDTO.getStatus(), "like");

            return predicate;
        };
    }
}
