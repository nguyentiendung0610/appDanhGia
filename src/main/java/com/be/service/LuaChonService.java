package com.be.service;

import com.be.common_api.LuaChon;
import com.be.dto.LuaChonDto;
import com.be.handler.Utils;
import com.be.mapper.LuaChonMapper;
import com.be.repository.LuaChonRepository;
import com.turkraft.springfilter.boot.Filter;
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
public class LuaChonService {
    private final LuaChonRepository repository;
    private final LuaChonMapper luaChonMapper;

    public LuaChonService(LuaChonRepository repository, LuaChonMapper luaChonMapper) {
        this.repository = repository;
        this.luaChonMapper = luaChonMapper;
    }

    public LuaChonDto save(LuaChonDto luaChonDto) {
        LuaChon entity = luaChonMapper.toEntity(luaChonDto);
        return luaChonMapper.toDto(repository.save(entity));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public LuaChonDto findById(Long id) {
        return luaChonMapper.toDto(repository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Item Not Found! ID: " + id)
        ));
    }

    public Page<LuaChonDto> findByCondition(@Filter Specification<LuaChon> spec, Pageable pageable) {
        Page<LuaChon> entityPage = repository.findAll(spec, pageable);
        List<LuaChon> entities = entityPage.getContent();
        return new PageImpl<>(luaChonMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public LuaChonDto update(LuaChonDto luaChonDto, Long id) {
        LuaChonDto data = findById(id);
        LuaChon entity = luaChonMapper.toEntity(luaChonDto);
        BeanUtils.copyProperties(entity, data, Utils.getNullPropertyNames(entity));
        return save(luaChonMapper.toDto(entity));
    }
}