package com.be.repository;

import com.be.common_api.LuaChon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LuaChonRepository extends JpaRepository<LuaChon, Long>, JpaSpecificationExecutor<LuaChon> {
}