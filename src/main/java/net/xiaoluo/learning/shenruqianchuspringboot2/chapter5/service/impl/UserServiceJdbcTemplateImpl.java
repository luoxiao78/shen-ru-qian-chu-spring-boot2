package net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.service.impl;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.model.Sex;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.model.User;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.service.UserServiceJdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.text.MessageFormat;
import java.util.List;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-15
 */
@Service
public class UserServiceJdbcTemplateImpl implements UserServiceJdbcTemplate {

  @Autowired
  private JdbcTemplate jdbcTemplate;


  @Override
  public int insertUser(User user) {
    String sql = " insert into chapter5_user (user_name, sex, note) values (?, ?, ?)";
    return jdbcTemplate.update(sql,
                               user.getUserName(),
                               user.getSex().getId(),
                               user.getNote());
  }

  @Override
  public User getUser(Long id) {
    String sql = String.format("select id, user_name, sex, note from chapter5_user where id = %d", id);
    return jdbcTemplate.queryForObject(sql, getUserMapper());
  }

  @Override
  public List<User> findAll(String userName, String note) {
    String sql = MessageFormat.format("select id, user_name, sex, note from chapter5_user " +
                                      "where user_name like concat(''%'', ''{0}'', ''%'') " +
                                      "and note like concat(''%'', ''{1}'', ''%'')",
                                      userName,
                                      note);
    return jdbcTemplate.query(sql,getUserMapper());
  }

  @Override
  public int updateUser(User user) {
    final String sql = "update chapter5_user set user_name = ?, sex = ?, note = ? where id = ?";
    return jdbcTemplate.update(sql,
                               user.getUserName(),
                               user.getSex().getId(),
                               user.getNote(),
                               user.getId());
  }

  @Override
  public int deleteUser(Long id) {
    final String sql = "delete from chapter5_user where id = ?";
    return jdbcTemplate.update(sql, id);
  }

  private RowMapper<User> getUserMapper() {
    return (ResultSet rs, int rowNum) -> {
      User user = new User();
      user.setId(rs.getLong("id"));
      user.setUserName(rs.getString("user_name"));
      final int sexId = rs.getInt("sex");
      final Sex sex = Sex.getSexById(sexId);
      user.setSex(sex);
      user.setNote(rs.getString("note"));
      return user;
    };
  }

}
