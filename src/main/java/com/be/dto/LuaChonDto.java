package com.be.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@ApiModel()
@Getter
@Setter
public class LuaChonDto extends BaseDto {
    @Max(Integer.MAX_VALUE)
    private Integer type;
    @Size(max = 255)
    private String content;
    @Max(Integer.MAX_VALUE)
    private Integer point;

    public LuaChonDto() {
    }
}