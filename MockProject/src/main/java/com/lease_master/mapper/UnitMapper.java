package com.lease_master.mapper;

import com.lease_master.model.Unit;
import com.lease_master.service.unit.dtos.UnitDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UnitMapper {
    UnitMapper INSTANCE = Mappers.getMapper(UnitMapper.class);

    UnitDTO toDto(Unit unit);

    Unit toEntity(UnitDTO unitDTO);
}
