package com.zerobase.weather.repository;


import com.zerobase.weather.domain.Memo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcMemoRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcMemoRepository(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Memo save(Memo memo){
        String sql = "insert into memo values(?,?)";
        jdbcTemplate.update(sql, memo.getId(),memo.getText());

        return memo;
    }

    public List<Memo> findAll(){
        String sql = "select * from memo";
        return jdbcTemplate.query(sql,memoRowMapper());
    }

    public Optional<Memo> findById(int id){
        String sql = "select * from memo where id= ?";
        return jdbcTemplate.query(sql,memoRowMapper(),id).stream().findFirst();
    }

    private RowMapper<Memo> memoRowMapper(){
        //jdbc를 통해서 mysql데이터를 가져오면
        //ResultSet 형식의 데이터로 가져오게 됨, 이것을 우리의 객체 클래스와 매핑해주는 것
        return(rs, rowNum) -> new Memo(
                rs.getInt("id"),
                rs.getString("text")
        );
    }
}
