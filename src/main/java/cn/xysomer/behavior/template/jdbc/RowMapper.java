package cn.xysomer.behavior.template.jdbc;

import java.sql.ResultSet;

/**
 * @Description orm 映射定制化接口
 * @Author Somer
 * @Date 2020-02-13 16:04
 */
public interface RowMapper<T> {

    T mapRow(ResultSet resultSet, int rowNumber) throws Exception;
}
