package com.be.controller;

import com.be.common_api.NguoiDung;
import com.be.common_api.UserLogin;
import com.be.dto.NguoiDungDto;
import com.be.handler.Utils;
import com.be.mapper.NguoiDungMapper;
import com.be.repository.NguoiDungRepository;
import com.be.service.NguoiDungService;
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
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.nio.file.FileSystemNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/api/nguoi-dung")
@RestController
@Slf4j
@Api("nguoi-dung")
public class NguoiDungController {
    private final NguoiDungService nguoiDungService;
    private final NguoiDungRepository repository;
    private final NguoiDungMapper nguoiDungMapper;

    public NguoiDungController(NguoiDungService nguoiDungService, NguoiDungRepository repository, NguoiDungMapper nguoiDungMapper) {
        this.nguoiDungService = nguoiDungService;
        this.repository = repository;
        this.nguoiDungMapper = nguoiDungMapper;
    }


    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginPass(@RequestBody @Validated UserLogin userLogin) {
        Map<String, Object> result =new HashMap<String, Object>();
        try {
            NguoiDung nguoiDung = repository.findByUsername(userLogin.getUsername());
            Boolean checkPass = BCrypt.checkpw(userLogin.getPassword(), nguoiDung.getPassword());
            if(checkPass){
                nguoiDung.setPassword("");
                result.put("result", nguoiDung);
                result.put("success", true);
            }else {
                result.put("result", "Tài khoản / mật khẩu không đúng");
                result.put("success", false);
            }
        }catch (Exception e){
            result.put("result",e.getMessage());
            result.put("success", false);
        }
        return ResponseEntity.ok(result);
    }
    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> save(@RequestBody @Validated NguoiDungDto nguoiDungDto) {
        Map<String, Object> result =new HashMap<String, Object>();
        NguoiDung nguoiDung = repository.findByUsername(nguoiDungDto.getUsername());
        if(nguoiDung == null){
            try{
                NguoiDung user = nguoiDungMapper.toEntity(nguoiDungDto);
                user.setUsername(nguoiDungDto.getUsername());
                user.setPassword(Utils.getBCryptedPassword("123456"));
                user.setFullName(nguoiDungDto.getFullName());
                user.setNgaySinh(nguoiDungDto.getNgaySinh());
                user.setGioiTinh(nguoiDungDto.getGioiTinh());
                user.setEmail(nguoiDungDto.getEmail());
                user.setAddress(nguoiDungDto.getAddress());
                user.setSdt(nguoiDungDto.getSdt());
                user.setAvatar(nguoiDungDto.getAvatar());
                user.setRole(nguoiDungDto.getRole());
                user.setStatus(nguoiDungDto.getStatus());
                NguoiDung userLogin=  repository.save(user);
                result.put("result", userLogin.getId());
                result.put("success", true);
            }catch (Exception e){
                System.out.printf("======="+e.getMessage()+"========");
                result.put("result",e.getMessage());
                result.put("success", false);
            }
        }
        else{
            result.put("result","Người dùng đã tồn tại");
            result.put("success", false);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable("id") Long id) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            NguoiDung nguoiDung = nguoiDungService.findById(id);
            result.put("result",nguoiDung);
            result.put("success",true);
        } catch (Exception e) {
            result.put("result",e.getMessage());
            result.put("success",false);
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        try {
            NguoiDung nguoiDung = nguoiDungService.findById(id);
            nguoiDung.setDeleted(true);
            NguoiDungDto nguoiDungDto = nguoiDungMapper.toDto(nguoiDung);
            nguoiDungService.update(nguoiDungDto, id);
        }catch (Exception e){
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/page")
    public ResponseEntity<Map<String, Object>> pageQuery(@Filter Specification<NguoiDung> spec, @PageableDefault(sort = "id", direction = Sort.Direction.DESC,size = 1000000) Pageable pageable) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            Page<NguoiDung> nguoiDungPage = nguoiDungService.findByCondition(spec, pageable);
            result.put("result", nguoiDungPage);
            result.put("success",true);
        } catch (Exception e) {
            result.put("result", e.getMessage());
            result.put("success",false);
        }
        return ResponseEntity.ok(result);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestBody @Validated NguoiDungDto nguoiDungDto, @PathVariable("id") Long id) {
        Map<String, Object> result =new HashMap<String, Object>();
        try{
            nguoiDungDto.setId(id);
            NguoiDungDto item=  nguoiDungService.update(nguoiDungDto, id);
            result.put("result",item.getId());
            result.put("success", true);
        }catch (Exception e){
            result.put("result",e.getMessage());
            result.put("success", false);
        }

        return ResponseEntity.ok(result);

    }
}