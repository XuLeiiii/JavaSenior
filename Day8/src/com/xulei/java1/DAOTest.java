package com.xulei.java1;

import org.junit.Test;

/**
 * @author xl
 * @Description:
 * @date: 2021-05-07 17:58
 * @since JDK 1.8
 */
public class DAOTest {


    @Test
    public void test1(){
        CustomerDAO dao1 =new CustomerDAO();

        dao1.add(new Customer());

    }
}
