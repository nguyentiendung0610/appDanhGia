package com.be.dto;

import com.be.annotation.CheckEmail;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.sql.Timestamp;

@ApiModel()
@Getter
@Setter
public class NguoiDungDto extends BaseDto {
    private Long id;
    @Size(max = 255)
    private String username;
    @Size(max = 255)
    private String password;
    private Short role;
    @Size(max = 255)
    private String fullName;
    private Timestamp ngaySinh;
    private Boolean gioiTinh;
    @CheckEmail
    @Size(max = 255)
    private String email;
    @Size(max = 255)
    private String address;
    @Size(max = 255)
    private String sdt;
    @Size(max = 255)
    private String avatar;
    private Short status;

    public NguoiDungDto() {
    }
}