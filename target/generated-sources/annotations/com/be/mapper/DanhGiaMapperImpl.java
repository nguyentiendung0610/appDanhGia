package com.be.mapper;

import com.be.common_api.DanhGia;
import com.be.dto.DanhGiaDto;
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
public class DanhGiaMapperImpl implements DanhGiaMapper {

    @Override
    public DanhGia toEntity(DanhGiaDto dto) {
        if ( dto == null ) {
            return null;
        }

        DanhGia danhGia = new DanhGia();

        danhGia.setId( dto.getId() );
        danhGia.setModifiedDate( dto.getModifiedDate() );
        danhGia.setCreatedDate( dto.getCreatedDate() );
        danhGia.setDeleted( dto.isDeleted() );
        danhGia.setIdSv( dto.getIdSv() );
        danhGia.setSinhVien( dto.getSinhVien() );
        danhGia.setDiem1( dto.getDiem1() );
        danhGia.setDiem2( dto.getDiem2() );
        danhGia.setDiem3( dto.getDiem3() );
        danhGia.setDiem4( dto.getDiem4() );
        danhGia.setDiem5( dto.getDiem5() );
        danhGia.setTong( dto.getTong() );
        danhGia.setXepLoai( dto.getXepLoai() );
        danhGia.setStatus( dto.getStatus() );

        return danhGia;
    }

    @Override
    public DanhGiaDto toDto(DanhGia entity) {
        if ( entity == null ) {
            return null;
        }

        DanhGiaDto danhGiaDto = new DanhGiaDto();

        danhGiaDto.setId( entity.getId() );
        if ( entity.getModifiedDate() != null ) {
            danhGiaDto.setModifiedDate( new Timestamp( entity.getModifiedDate().getTime() ) );
        }
        if ( entity.getCreatedDate() != null ) {
            danhGiaDto.setCreatedDate( new Timestamp( entity.getCreatedDate().getTime() ) );
        }
        danhGiaDto.setDeleted( entity.isDeleted() );
        danhGiaDto.setIdSv( entity.getIdSv() );
        danhGiaDto.setSinhVien( entity.getSinhVien() );
        danhGiaDto.setDiem1( entity.getDiem1() );
        danhGiaDto.setDiem2( entity.getDiem2() );
        danhGiaDto.setDiem3( entity.getDiem3() );
        danhGiaDto.setDiem4( entity.getDiem4() );
        danhGiaDto.setDiem5( entity.getDiem5() );
        danhGiaDto.setTong( entity.getTong() );
        danhGiaDto.setXepLoai( entity.getXepLoai() );
        danhGiaDto.setStatus( entity.getStatus() );

        return danhGiaDto;
    }

    @Override
    public List<DanhGia> toEntity(List<DanhGiaDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<DanhGia> list = new ArrayList<DanhGia>( dtoList.size() );
        for ( DanhGiaDto danhGiaDto : dtoList ) {
            list.add( toEntity( danhGiaDto ) );
        }

        return list;
    }

    @Override
    public List<DanhGiaDto> toDto(List<DanhGia> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DanhGiaDto> list = new ArrayList<DanhGiaDto>( entityList.size() );
        for ( DanhGia danhGia : entityList ) {
            list.add( toDto( danhGia ) );
        }

        return list;
    }

    @Override
    public Set<DanhGiaDto> toDto(Set<DanhGia> entityList) {
        if ( entityList == null ) {
            return null;
        }

        Set<DanhGiaDto> set = new LinkedHashSet<DanhGiaDto>( Math.max( (int) ( entityList.size() / .75f ) + 1, 16 ) );
        for ( DanhGia danhGia : entityList ) {
            set.add( toDto( danhGia ) );
        }

        return set;
    }
}
