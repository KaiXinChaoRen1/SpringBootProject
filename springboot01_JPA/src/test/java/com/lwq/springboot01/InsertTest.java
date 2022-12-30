package com.lwq.springboot01;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.lwq.springboot01.Entity.treeUtils.Subject;
import com.lwq.springboot01.dao.treeRepository.SubjectRepository;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.IdUtil;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class InsertTest {

    @Autowired
    private SubjectRepository sr;

      // 雪花算法生成uuid的Hutool工具类
      private static Snowflake snowflake = IdUtil.getSnowflake(1, 1);

    /**
     * uuid
     */
    @Test
    public void name() {
        ArrayList<Subject> arrayList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(Subject.builder().uuid(UUID.randomUUID().toString()).build());
        }
        long begin = System.currentTimeMillis();
        sr.saveAll(arrayList);
        long end = System.currentTimeMillis();
        System.out.println("用时"+(end-begin)/1000+"秒");
        long count = sr.count();
        System.out.println("表里共"+count+"条数据");
    }

     /**
     * 雪花算法
     */
    @Test
    public void name2() {
        ArrayList<Subject> arrayList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(Subject.builder().uuid(snowflake.nextIdStr()).build());
        }
        long begin = System.currentTimeMillis();
        sr.saveAll(arrayList);
        long end = System.currentTimeMillis();
        System.out.println("用时"+(end-begin)/1000+"秒");
        long count = sr.count();
        System.out.println("表里共"+count+"条数据");
    }

    @Test
    public void name3() {
        ArrayList<Subject> arrayList = new ArrayList<>();
        for (int i = 0; i < 500000; i++) {
            arrayList.add(Subject.builder().uuid(UUID.randomUUID().toString()).build());
        }
        long begin = System.currentTimeMillis();
        batchInsert(arrayList);
        long end = System.currentTimeMillis();
        System.out.println("用时"+(end-begin)/1000+"秒");
        long count = sr.count();
        System.out.println("表里共"+count+"条数据");
    }

    /**
     * 雪花算法
     */
    @Test
    public void name4() {
        ArrayList<Subject> arrayList = new ArrayList<>();
        for (int i = 0; i < 500000; i++) {
            arrayList.add(Subject.builder().uuid(snowflake.nextIdStr()).build());
        }
        long begin = System.currentTimeMillis();
        batchInsert(arrayList);
        long end = System.currentTimeMillis();
        System.out.println("用时"+(end-begin)/1000+"秒");
        long count = sr.count();
        System.out.println("表里共"+count+"条数据");
    }



    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void batchInsert(List<Subject> list){
        String sql = "insert into tree_subject(uuid, subject_name , father_uuid) values(?, ?, ?)";
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
 
            @Override
            public int getBatchSize() {
                return list.size();
            }

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, list.get(i).getId());
                ps.setString(2, list.get(i).getSubjectName());
                ps.setString(3, list.get(i).getFatherUuid());
                
            }
        });
    }

}
