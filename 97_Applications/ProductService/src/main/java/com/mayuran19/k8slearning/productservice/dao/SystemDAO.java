package com.mayuran19.k8slearning.productservice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Date;

@Repository("systemDAO")
public class SystemDAO {
    @Autowired private DataSource dataSource;

    public Date getCurrentTimestamp(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Date date = jdbcTemplate.queryForObject("select current_timestamp", Date.class);
        return date;
    }
}
