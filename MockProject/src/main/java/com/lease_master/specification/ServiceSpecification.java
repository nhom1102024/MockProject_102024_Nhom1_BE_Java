package com.lease_master.specification;

import com.lease_master.model.Services;
import com.lease_master.service.service.dtos.ServiceSearchDTO;
import com.lease_master.utils.SpecificationUtil;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;

public class ServiceSpecification {
    public static Specification<Services> search(ServiceSearchDTO searchDTO) {
        return (root, query, builder) -> {
            Predicate predicate = builder.conjunction();

            SpecificationUtil.addConditionIfNotNull(predicate, builder, root.get("provider").get("providerName"), searchDTO.getProviderName().getProviderName(), "like");
            SpecificationUtil.addConditionIfNotNull(predicate, builder, root.get("serviceName"), searchDTO.getServiceName(), "like");
            SpecificationUtil.addConditionIfNotNull(predicate, builder, root.get("description"), searchDTO.getDescription(), "like");
            SpecificationUtil.addConditionIfNotNull(predicate, builder, root.get("serviceType"), searchDTO.getCategoryService(), "like");
            SpecificationUtil.addConditionIfNotNull(predicate, builder, root.get("price"), searchDTO.getPrice(), "equal");
            SpecificationUtil.addConditionIfNotNull(predicate, builder, root.get("duration"), searchDTO.getDuration(), "like");
            SpecificationUtil.addConditionIfNotNull(predicate, builder, root.get("contactInformation"), searchDTO.getContactInformation(), "like");
            SpecificationUtil.addConditionIfNotNull(predicate, builder, root.get("scopeOfServices"), searchDTO.getScopeOfServices(), "like");
            SpecificationUtil.addConditionIfNotNull(predicate, builder, root.get("qualityStandards"), searchDTO.getQualityStandards(), "like");
            SpecificationUtil.addConditionIfNotNull(predicate, builder, root.get("implementationSchedule"), searchDTO.getImplementationSchedule(), "like");

            return predicate;
        };
    }
}
