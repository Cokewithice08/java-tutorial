package io.github.jast90.jta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class JTAService implements IJTAService{
    @Autowired
    @Qualifier("firstJdbcTemplate")
    private JdbcTemplate firstJdbcTemplate;

    @Autowired
    @Qualifier("secondJdbcTemplate")
    private JdbcTemplate secondJdbcTemplate;

    @Transactional
    @Override
    public void save() {
        String username = UUID.randomUUID().toString();
        String sql1 = "insert into t_user(`name`,age) values(?,?)";
        firstJdbcTemplate.update(sql1, username,18);
        String sql2 = "insert into t_order(id,user_name) values(?,?)";
        secondJdbcTemplate.update(sql2, UUID.randomUUID().toString(),username);
    }
}
