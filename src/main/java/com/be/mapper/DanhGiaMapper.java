package com.be.mapper;

import com.be.common_api.DanhGia;
import com.be.dto.DanhGiaDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DanhGiaMapper extends EntityMapper<DanhGiaDto, DanhGia> {
}