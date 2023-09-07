package com.be.controller;

import com.be.common_api.LuaChon;
import com.be.dto.LuaChonDto;
import com.be.mapper.LuaChonMapper;
import com.be.service.LuaChonService;
import com.turkraft.springfilter.boot.Filter;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.nio.file.FileSystemNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/api/lua-chon")
@RestController
@Slf4j
@Api("lua-chon")
public class LuaChonController {
    private final LuaChonService luaChonService;

    public LuaChonController(LuaChonService luaChonService) {
        this.luaChonService = luaChonService;
    }

    @PostMapping("/post")
    public ResponseEntity<Map<String, Object>> save(@RequestBody @Validated LuaChonDto luaChonDto) {
        Map<String, Object> result = new HashMap<>();
        try{
            LuaChonDto item =  luaChonService.save(luaChonDto);
            result.put("result", item.getId());
            result.put("success",true);
        }
        catch (Exception e){
            result.put("result",e.getMessage());
            result.put("success",false);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable("id") Long id) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            LuaChonDto luaChon = luaChonService.findById(id);
            result.put("result",luaChon);
            result.put("success",true);
        } catch (Exception e) {
            result.put("result",e.getMessage());
            result.put("success",false);
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        try {
            Optional.ofNullable(luaChonService.findById(id)).orElseThrow(() -> {
                log.error("Unable to delete non-existent data！");
                return new FileSystemNotFoundException();
            });
            luaChonService.deleteById(id);
            return ResponseEntity.ok(true);
        }catch (Exception e){
            return ResponseEntity.ok(false);
        }
    }

    @GetMapping("/get/page")
    public ResponseEntity<Map<String, Object>> pageQuery(@Filter Specification<LuaChon> spec, @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            Page<LuaChonDto> luaChonPage = luaChonService.findByCondition(spec, pageable);
            result.put("result", luaChonPage);
            result.put("success",true);
        } catch (Exception e) {
            result.put("result", e.getMessage());
            result.put("success",false);
        }
        return ResponseEntity.ok(result);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity< Map<String, Object>> update(@RequestBody @Validated LuaChonDto luaChonDto, @PathVariable("id") Long id) {
        Map<String, Object> result = new HashMap<>();
        try{
            luaChonDto.setId(id);
            LuaChonDto item = luaChonService.update(luaChonDto, id);
            result.put("result", item.getId());
            result.put("success",true);
        }
        catch (Exception e){
            result.put("result",e.getMessage());
            result.put("success",false);
        }
        return ResponseEntity.ok(result);
    }
}