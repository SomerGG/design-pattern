package cn.xysomer.behavior.template.jdbc;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

/**
 * @Description 数据库操作类
 * @Author Somer
 * @Date 2020-02-13 17:04
 */
public class MemberDao extends JdbcTemplate {

    public MemberDao(DataSource dataSource) {
        super(dataSource);
    }

    public List<?> selectAll() {
        String sql = "select * from t_member";
        return super.executeQuery(sql, new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet resultSet, int rowNumber) throws Exception {
                Member member = new Member();
                member.setUsername(resultSet.getString("username"));
                member.setPassword(resultSet.getString("password"));
                member.setNickname(resultSet.getString("nickname"));
                member.setAge(resultSet.getInt("age"));
                member.setAddress(resultSet.getString("address"));
                return member;
            }
        }, null);
    }
}
