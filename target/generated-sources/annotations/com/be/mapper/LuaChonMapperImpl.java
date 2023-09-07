package com.be.mapper;

import com.be.common_api.LuaChon;
import com.be.dto.LuaChonDto;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-26T01:06:48+0700",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 11.0.20 (Oracle Corporation)"
)
@Component
public class LuaChonMapperImpl implements LuaChonMapper {

    @Override
    public LuaChon toEntity(LuaChonDto dto) {
        if ( dto == null ) {
            return null;
        }

        LuaChon luaChon = new LuaChon();

        luaChon.setId( dto.getId() );
        luaChon.setModifiedDate( dto.getModifiedDate() );
        luaChon.setCreatedDate( dto.getCreatedDate() );
        luaChon.setDeleted( dto.isDeleted() );
        luaChon.setType( dto.getType() );
        luaChon.setContent( dto.getContent() );
        luaChon.setPoint( dto.getPoint() );

        return luaChon;
    }

    @Override
    public LuaChonDto toDto(LuaChon entity) {
        if ( entity == null ) {
            return null;
        }

        LuaChonDto luaChonDto = new LuaChonDto();

        luaChonDto.setId( entity.getId() );
        if ( entity.getModifiedDate() != null ) {
            luaChonDto.setModifiedDate( new Timestamp( entity.getModifiedDate().getTime() ) );
        }
        if ( entity.getCreatedDate() != null ) {
            luaChonDto.setCreatedDate( new Timestamp( entity.getCreatedDate().getTime() ) );
        }
        luaChonDto.setDeleted( entity.isDeleted() );
        luaChonDto.setType( entity.getType() );
        luaChonDto.setContent( entity.getContent() );
        luaChonDto.setPoint( entity.getPoint() );

        return luaChonDto;
    }

    @Override
    public List<LuaChon> toEntity(List<LuaChonDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<LuaChon> list = new ArrayList<LuaChon>( dtoList.size() );
        for ( LuaChonDto luaChonDto : dtoList ) {
            list.add( toEntity( luaChonDto ) );
        }

        return list;
    }

    @Override
    public List<LuaChonDto> toDto(List<LuaChon> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<LuaChonDto> list = new ArrayList<LuaChonDto>( entityList.size() );
        for ( LuaChon luaChon : entityList ) {
            list.add( toDto( luaChon ) );
        }

        return list;
    }

    @Override
    public Set<LuaChonDto> toDto(Set<LuaChon> entityList) {
        if ( entityList == null ) {
            return null;
        }

        Set<LuaChonDto> set = new LinkedHashSet<LuaChonDto>( Math.max( (int) ( entityList.size() / .75f ) + 1, 16 ) );
        for ( LuaChon luaChon : entityList ) {
            set.add( toDto( luaChon ) );
        }

        return set;
    }
}
