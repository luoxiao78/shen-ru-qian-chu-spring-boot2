package net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.typehandler;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.model.Sex;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-16
 */
@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes(Sex.class)
public class SexTypeHandler extends BaseTypeHandler<Sex> {

  @Override
  public void setNonNullParameter(PreparedStatement preparedStatement, int index, Sex sex, JdbcType jdbcType) throws SQLException {
    preparedStatement.setInt(index, sex.getId());
  }

  @Override
  public Sex getNullableResult(ResultSet resultSet, String colName) throws SQLException {
    int setId = resultSet.getInt(colName);
    return Sex.getSexById(setId);
  }

  @Override
  public Sex getNullableResult(ResultSet resultSet, int colIndex) throws SQLException {
    int setId = resultSet.getInt(colIndex);
    return Sex.getSexById(setId);
  }

  @Override
  public Sex getNullableResult(CallableStatement callableStatement, int paramIndex) throws SQLException {
    final int sexId = callableStatement.getInt(paramIndex);
    return Sex.getSexById(sexId);
  }

}
