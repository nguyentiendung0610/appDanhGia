package com.be.controller;

import com.be.common_api.DanhGia;
import com.be.dto.DanhGiaDto;
import com.be.mapper.DanhGiaMapper;
import com.be.service.DanhGiaService;
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

@RequestMapping("/api/danh-gia")
@RestController
@Slf4j
@Api("danh-gia")
public class DanhGiaController {
    private final DanhGiaService danhGiaService;

    public DanhGiaController(DanhGiaService danhGiaService) {
        this.danhGiaService = danhGiaService;
    }

    @PostMapping("/post")
    public ResponseEntity<Map<String, Object>> save(@RequestBody @Validated DanhGiaDto danhGiaDto) {
        Map<String, Object> result = new HashMap<>();
        try{
            DanhGiaDto item = danhGiaService.save(danhGiaDto);
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
            DanhGiaDto danhGia = danhGiaService.findById(id);
            result.put("result",danhGia);
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
            Optional.ofNullable(danhGiaService.findById(id)).orElseThrow(() -> {
                log.error("Unable to delete non-existent data！");
                return new FileSystemNotFoundException();
            });
            danhGiaService.deleteById(id);
            return ResponseEntity.ok(true);
        }catch (Exception e){
            return ResponseEntity.ok(false);
        }
    }

    @GetMapping("/get/page")
    public ResponseEntity<Map<String, Object>> pageQuery(@Filter Specification<DanhGia> spec, @PageableDefault(sort = "id", direction = Sort.Direction.DESC, size = 10000000) Pageable pageable) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            Page<DanhGiaDto> danhGiaPage = danhGiaService.findByCondition(spec, pageable);
            result.put("result", danhGiaPage);
            result.put("success",true);
        } catch (Exception e) {
            result.put("result", e.getMessage());
            result.put("success",false);
        }
        return ResponseEntity.ok(result);

    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestBody @Validated DanhGiaDto danhGiaDto, @PathVariable("id") Long id) {
        Map<String, Object> result = new HashMap<>();
        try{
            danhGiaDto.setId(id);
            DanhGiaDto item =  danhGiaService.update(danhGiaDto, id);
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