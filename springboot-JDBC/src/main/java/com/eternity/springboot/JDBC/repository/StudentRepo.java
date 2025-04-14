package com.eternity.springboot.JDBC.repository;

import com.eternity.springboot.JDBC.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student st)
    {
        String sql = "INSERT INTO student(rollno, name, marks) VALUES (?,?,?) ";
        int rows = jdbc.update(sql, st.getRollNo(), st.getName(), st.getMarks());

        System.out.println(rows+ " effected ");
    }

    public List<Student> findAll()
    {
        String sql = "SELECT * FROM student";
        RowMapper<Student> mapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

                Student st = new Student();
                st.setRollNo(rs.getInt(1));
                st.setName(rs.getString(2));
                st.setMarks(rs.getInt(3));

                return st;
            }
        };
        return jdbc.query(sql,mapper);
    }
}
