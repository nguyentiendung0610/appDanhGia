package com.be.common_api;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "danh_gia")
@Getter
@Setter
@DynamicUpdate
@Where(clause = "deleted=false")
public class DanhGia extends BaseEntity{
    @Column(name = "id_sv")
    private Long idSv;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_sv",referencedColumnName="id", nullable = false, insertable = false, updatable = false)
    private NguoiDung sinhVien;
    @Column(name = "diem1")
    private Integer diem1;
    @Column(name = "diem2")
    private Integer diem2;
    @Column(name = "diem3")
    private Integer diem3;
    @Column(name = "diem4")
    private Integer diem4;
    @Column(name = "diem5")
    private Integer diem5;
    @Column(name = "tong")
    private Integer tong;
    @Column(name = "xep_loai")
    private String xepLoai;
    @Column(name = "status")
    private Short status;
}
