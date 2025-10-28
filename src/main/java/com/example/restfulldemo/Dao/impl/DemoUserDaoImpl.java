package com.example.restfulldemo.Dao.impl;

import com.example.restfulldemo.Bean.DemoUser;
import com.example.restfulldemo.Bean.Page;
import com.example.restfulldemo.Dao.DemoUserDao;
import com.example.restfulldemo.util.sql.Sql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

@Repository
public class DemoUserDaoImpl extends JdbcDaoImpl implements DemoUserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(DemoUser demoUser) {
        String sql = "insert into demo_user (name, create_time) values (?, ?)";
        return jdbcTemplate.update(sql, demoUser.getName(), demoUser.getCreateTime());
    }


    @Override
    public int deleteById(int id) {

        String sql = "delete from demo_user where id=?";
        return jdbcTemplate.update(sql, id);

    }


    @Override
    public int updateById(DemoUser demoUser) {
        String sql = "update demo_user set name=?, create_time=? where id=?";
        return jdbcTemplate.update(sql, demoUser.getName(), demoUser.getCreateTime(), demoUser.getId());

    }

    @Override
    public DemoUser selectById(int id) {

        String sql = "select * from demo_user where id=?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<DemoUser>() {
            @Override
            public DemoUser mapRow(ResultSet rs, int rowNum) throws SQLException {
                DemoUser demoUser = new DemoUser();
                demoUser.setId(rs.getInt("id"));
                demoUser.setName(rs.getString("name"));
                demoUser.setCreateTime(rs.getDate("create_time"));
                return demoUser;
            }}, id);
    }

    @Override
    public Page<DemoUser> queryForPage(int pageCurrent, int pageSize, String name){
        // 确定参数
        /*String sql = "select * from demo_user where name=?";
        return queryForPage(sql.toString(), pageCurrent, pageSize, RoncooUser.class, name);*/

        // 若name可能为空，则要进行判定，如下
        /*StringBuffer sql = new StringBuffer("select * from demo_user where 1");
        if(!StringUtils.isNullOrEmpty(name)){
            // Sql.checkSql 的作用是防止sql注入
            sql.append(" and name = '").append(Sql.checkSql(name)).append("' ");
        }
        return queryForPage(sql.toString(), pageCurrent, pageSize, RoncooUser.class);*/

        // 若要like查询，如下
        StringBuffer sql = new StringBuffer("select * from demo_user where 1");
        if(!StringUtils.isEmpty(name)){
            // Sql.checkSql 的作用是防止sql注入
            sql.append(" and name like '%").append(Sql.checkSql(name)).append("%' ");
        }
        return queryForPage(sql.toString(), pageCurrent, pageSize, DemoUser.class);
    }
}