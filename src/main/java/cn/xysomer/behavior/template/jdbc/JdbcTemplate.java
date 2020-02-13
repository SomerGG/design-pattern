package cn.xysomer.behavior.template.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author Somer
 * @Date 2020-02-13 16:05
 */
public abstract class JdbcTemplate {

    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<?> executeQuery(String sql, RowMapper<?> rowMapper, Object[] values) {
        try {
            // 1、获取连接
            Connection connection = this.getConnection();
            // 2、创建语句集
            PreparedStatement statement = this.createPrepareStatement(connection, sql);
            // 3、执行语句集
            ResultSet resultSet = this.executeQuery(statement, values);
            // 4、处理结果集
            List<?> result = this.parseResultSet(resultSet, rowMapper);
            // 6、关闭结果集
            this.closeResultSet(resultSet);
            // 7、关闭语句集
            this.closeStatement(statement);
            // 8、连接池回收连接
            this.closeConnection(connection);
            // 返回结果
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取连接
     *
     * @return
     * @throws Exception
     */
    public Connection getConnection() throws Exception {
        return this.dataSource.getConnection();
    }

    /**
     * 创建语句集
     *
     * @param connection
     * @param sql
     */
    protected PreparedStatement createPrepareStatement(Connection connection, String sql) throws Exception {
        return connection.prepareStatement(sql);
    }

    /**
     * 执行语句集
     *
     * @param statement
     * @param values
     * @return
     * @throws Exception
     */
    protected ResultSet executeQuery(PreparedStatement statement, Object[] values) throws Exception {
        for (int i = 0; i < values.length; i++) {
            statement.setObject(i, values[i]);
        }
        return statement.executeQuery();
    }

    /**
     * 处理结果集
     *
     * @param resultSet
     * @param rowMapper
     * @return
     * @throws Exception
     */
    protected List<?> parseResultSet(ResultSet resultSet, RowMapper<?> rowMapper) throws Exception {
        List<Object> result = new ArrayList<>();
        int rowNum = 0;
        while (resultSet.next()) {
            result.add(rowMapper.mapRow(resultSet, rowNum++));
        }
        return result;
    }

    /**
     * 关闭结果集
     *
     * @param resultSet
     * @throws Exception
     */
    protected void closeResultSet(ResultSet resultSet) throws Exception {
        resultSet.close();
    }

    /**
     * 关闭语句集
     *
     * @param statement
     * @throws Exception
     */
    public void closeStatement(PreparedStatement statement) throws Exception {
        statement.close();
    }

    /**
     * 连接池回收连接
     *
     * @param connection
     * @throws Exception
     */
    public void closeConnection(Connection connection) throws Exception {
        connection.close();
    }
}
