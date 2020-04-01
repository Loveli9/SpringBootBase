package com.hou.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(String id) {
        String sql = "insert into user(id) values(" + id + ")";
        jdbcTemplate.execute(sql);
    }

    /**
     * @Transactional:此方法使用事务 参数:rollbackFor:设置对哪些异常进行回滚,默认是运行时异常,其他不回滚
     * noRollbackFor:设置哪些异常不回滚
     */
    @Transactional(rollbackFor = Exception.class, noRollbackFor = NullPointerException.class)
    public void addUserBatch(String... ids) throws Exception {
        for (String id : ids) {
            String sql = "insert into user(id) values(" + id + ")";
            jdbcTemplate.execute(sql);
            if (id == "5") {
                throw new IllegalAccessException();
            }
        }
    }

}
