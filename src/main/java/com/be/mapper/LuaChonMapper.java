package com.be.mapper;

import com.be.common_api.LuaChon;
import com.be.dto.LuaChonDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LuaChonMapper extends EntityMapper<LuaChonDto, LuaChon> {
}