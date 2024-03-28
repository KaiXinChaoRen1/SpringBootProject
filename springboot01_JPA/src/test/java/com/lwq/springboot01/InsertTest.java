package com.lwq.springboot01;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.lwq.springboot01.dao.treeRepository.SubjectRepository;
import com.lwq.springboot01.entity.treeUtils.Subject;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.IdUtil;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class InsertTest {

    @Autowired
    private SubjectRepository sr;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PersistenceContext
    private EntityManager entityManager;

    // 雪花算法生成uuid的Hutool工具类
    private static Snowflake snowflake = IdUtil.getSnowflake(1, 1);

    public void batchInsert(List<Subject> list) {
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

    public void batchInsert2(List<Subject> list) {
        String sql = "insert ignore into tree_subject(uuid, subject_name , father_uuid) values(?, ?, ?)";
        ArrayList<Object[]> objectList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Object[] objects = new Object[] { list.get(i).getId(), null, "001" };
            objectList.add(objects);
        }

        jdbcTemplate.batchUpdate(sql, objectList);
    }

    public void batchInsert3(List<Subject> list) {
        for (Subject s : list) {
            entityManager.persist(s);// insert插入操作
        }
        entityManager.flush();
        entityManager.clear();
    }

    @Test
    @Transactional
    @Commit
    public void name1111() {
        ArrayList<Subject> arrayList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(Subject.builder().uuid(UUID.randomUUID().toString()).build());
        }
        long begin = System.currentTimeMillis();
        this.batchInsert3(arrayList);
        long end = System.currentTimeMillis();
        System.out.println("用时" + (end - begin) / 1000 + "秒");
        long count = sr.count();
        System.out.println("表里共" + count + "条数据");
    }


    
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
        System.out.println("用时" + (end - begin) / 1000 + "秒");
        long count = sr.count();
        System.out.println("表里共" + count + "条数据");
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
        System.out.println("用时" + (end - begin) / 1000 + "秒");
        long count = sr.count();
        System.out.println("表里共" + count + "条数据");
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
        System.out.println("用时" + (end - begin) / 1000 + "秒");
        long count = sr.count();
        System.out.println("表里共" + count + "条数据");
    }

    @Test
    public void name55() {
        ArrayList<Subject> arrayList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(Subject.builder().uuid("11").build());
        }
        long begin = System.currentTimeMillis();
        batchInsert(arrayList);
        // batchInsert2(arrayList);
        long end = System.currentTimeMillis();
        System.out.println("用时" + (end - begin) / 1000 + "秒");
        long count = sr.count();
        System.out.println("表里共" + count + "条数据");
    }

}
