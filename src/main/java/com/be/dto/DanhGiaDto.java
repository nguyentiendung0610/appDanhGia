package com.be.dto;

import com.be.common_api.NguoiDung;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@ApiModel()
@Getter
@Setter
public class DanhGiaDto extends BaseDto {
    private Long idSv;
    private NguoiDung sinhVien;
    @Max(Integer.MAX_VALUE)
    private Integer diem1;
    @Max(Integer.MAX_VALUE)
    private Integer diem2;
    @Max(Integer.MAX_VALUE)
    private Integer diem3;
    @Max(Integer.MAX_VALUE)
    private Integer diem4;
    @Max(Integer.MAX_VALUE)
    private Integer diem5;
    @Max(Integer.MAX_VALUE)
    private Integer tong;
    private String xepLoai;
    private Short status;

    public DanhGiaDto() {
    }
}