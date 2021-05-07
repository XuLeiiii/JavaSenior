package com.xulei.java1;

/**
 * @author xl
 * @Description:
 * @date: 2021-05-07 17:51
 * @since JDK 1.8
 */
public class DAO<T> {

    /**
     * 增加
     */
    public void add(T t){};

    /**
     * 删除
     */
    public boolean remove(int index){
        return false;
    }

    /**
     * 修改
     */
    public void  update(int index,T t){

    }

    /**
     * 查询
     */
    public T get(int index){
        return null;
    }

    /**
     * 泛型方法
     */
    public <E>  E getValue(){
        return null;
    }

}
