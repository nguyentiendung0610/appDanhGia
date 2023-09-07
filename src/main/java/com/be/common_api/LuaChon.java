package com.be.common_api;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "lua_chon")
@Getter
@Setter
@DynamicUpdate
@Where(clause = "deleted=false")
public class LuaChon extends BaseEntity{
    @Column(name = "type")
    private Integer type;
    @Column(name = "content")
    private String content;
    @Column(name = "point")
    private Integer point;
}
