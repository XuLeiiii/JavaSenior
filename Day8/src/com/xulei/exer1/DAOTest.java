package com.xulei.exer1;

import java.util.List;

/**
 * @author xl
 * @Description:
 * @date: 2021-05-07 18:59
 * @since JDK 1.8
 */
public class DAOTest {

    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();

        dao.save("1001",new User(1001,18,"何小玲"));
        dao.save("1002",new User(1002,17,"徐磊"));
        dao.save("1003",new User(1003,28,"石磊"));
        dao.save("1004",new User(1004,38,"何宝玲"));
        dao.save("1005",new User(1005,19,"宝宝"));


        dao.update("1003",new User(1003,35,"徐磊1"));
        dao.delete("1003");

        List<User> list = dao.list();
        list.forEach(System.out::println);
    }
}
