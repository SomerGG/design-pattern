package cn.xysomer.behavior.template;

import cn.xysomer.behavior.template.jdbc.MemberDao;

import java.util.List;

/**
 * @Description 模板模式测试
 * @Author Somer
 * @Date 2020-02-13 17:10
 */
public class JdbcTemplateTest {

    public static void main(String[] args) {
        MemberDao memberDao = new MemberDao(null);
        List<?> result = memberDao.selectAll();
        System.out.println(result);
    }
}
