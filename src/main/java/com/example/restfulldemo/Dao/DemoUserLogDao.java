package com.example.restfulldemo.Dao;

import com.example.restfulldemo.Bean.DemoUserLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoUserLogDao extends JpaRepository<DemoUserLog, Integer> {

}