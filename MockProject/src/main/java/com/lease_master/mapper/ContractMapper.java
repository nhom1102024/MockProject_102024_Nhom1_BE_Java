package com.lease_master.mapper;

import com.lease_master.model.Contract;
import com.lease_master.service.contract.dtos.ContractListDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ContractMapper {
    ContractMapper INSTANCE = Mappers.getMapper(ContractMapper.class);

    @Mapping(source = "customer.user.fullName", target = "fullName")
    @Mapping(source = "customer.user.avatar", target = "avatar")
    @Mapping(source = "customer.user.dateOfBirth", target = "dateOfBirth")
    @Mapping(source = "customer.user.gender", target = "gender")
    @Mapping(source = "customer.user.address", target = "address")
    @Mapping(source = "customer.user.phoneNumber", target = "phoneNumber")
    @Mapping(source = "customer.user.email", target = "email")
    @Mapping(source = "customer.user.status", target = "status")
    @Mapping(source = "customer.occupation", target = "occupation")
    @Mapping(source = "customer.unit.roomNumber", target = "roomNumber")
    @Mapping(source = "service.serviceName", target = "serviceName")
    @Mapping(source = "service.description", target = "description")
    @Mapping(source = "service.serviceType", target = "serviceType")
    @Mapping(source = "service.price", target = "price")
    @Mapping(source = "service.duration", target = "duration")
    @Mapping(source = "service.contactInformation", target = "contactInformation")
    @Mapping(source = "service.scopeOfServices", target = "scopeOfServices")
    @Mapping(source = "service.qualityStandards", target = "qualityStandards")
    ContractListDTO convertToContractListDto(Contract contract);
}