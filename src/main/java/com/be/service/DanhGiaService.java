package com.be.service;

import com.be.common_api.DanhGia;
import com.be.dto.DanhGiaDto;
import com.be.handler.Utils;
import com.be.mapper.DanhGiaMapper;
import com.be.repository.DanhGiaRepository;
import com.turkraft.springfilter.boot.Filter;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class DanhGiaService {
    private final DanhGiaRepository repository;
    private final DanhGiaMapper danhGiaMapper;

    public DanhGiaService(DanhGiaRepository repository, DanhGiaMapper danhGiaMapper) {
        this.repository = repository;
        this.danhGiaMapper = danhGiaMapper;
    }

    public DanhGiaDto save(DanhGiaDto danhGiaDto) {
        DanhGia entity = danhGiaMapper.toEntity(danhGiaDto);
        return danhGiaMapper.toDto(repository.save(entity));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public DanhGiaDto findById(Long id) {
        return danhGiaMapper.toDto(repository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Item Not Found! ID: " + id)
        ));
    }

    public Page<DanhGiaDto> findByCondition(@Filter Specification<DanhGia> spec, Pageable pageable) {
        Page<DanhGia> entityPage = repository.findAll(spec,pageable);
        List<DanhGia> entities = entityPage.getContent();
        return new PageImpl<>(danhGiaMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public DanhGiaDto update(DanhGiaDto danhGiaDto, Long id) {
        DanhGiaDto data = findById(id);
        DanhGia entity = danhGiaMapper.toEntity(danhGiaDto);
        BeanUtils.copyProperties(entity, data, Utils.getNullPropertyNames(entity));
        return save(danhGiaMapper.toDto(entity));
    }
}