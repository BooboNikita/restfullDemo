package com.example.restfulldemo.Dao;

import com.example.restfulldemo.Bean.DemoUserLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DemoUserLogDao extends JpaRepository<DemoUserLog, Integer> {
    /**
     * @param userName
     * @return
     */
    @Query(value = "select u from DemoUserLog u where u.userName=?1")
    List<DemoUserLog> findByUserName(String userName);

    /**
     * @param string
     * @param string2
     * @return
     */
    List<DemoUserLog> findByUserNameAndUserIp(String string, String string2);

    /**
     * @param userName
     * @param pageable
     * @return
     */
    Page<DemoUserLog> findByUserName(String userName, Pageable pageable);

}