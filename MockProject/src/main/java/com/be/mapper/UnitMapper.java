package com.be.mapper;

import com.be.model.Unit;
import com.be.service.unit.dtos.UnitDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UnitMapper {
    UnitMapper INSTANCE = Mappers.getMapper(UnitMapper.class);

    UnitDTO toDto(Unit unit);

    Unit toEntity(UnitDTO unitDTO);
}
