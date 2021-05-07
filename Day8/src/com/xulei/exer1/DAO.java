package com.xulei.exer1;

import java.util.*;

/**
 * @author xl
 * @Description:
 * @date: 2021-05-07 18:49
 * @since JDK 1.8
 */
public class DAO<T> {

    private Map<String,T> map =new HashMap<>();

    /**
     * 保存T类型的对象到Map成员变量中
     * @param id
     * @param entity
     */
    public void save(String id ,T entity){
        map.put(id,entity);
    }

    /***
     *  从map中回去id对应的对象
     */
    public T get(String id){
        return map.get(id);
    }


    /**
     * 替换
     */

    public void update(String id,T entity){
        //判断是否有这个id
        if(map.containsKey(id)){
            map.put(id,entity);
        }
    }

    /**
     * 返回map中存放中的所有T
     */

    public List<T> list(){
        Collection<T> values = map.values();
        List<T> list = new ArrayList<>();
        Iterator<T> iterator = values.iterator();
        while(iterator.hasNext()){
            list.add(iterator.next());
        }
        return  list;

    }

    /**
     * 删除指定对象
     */
    public void delete(String id){

        map.remove(id);
    }

}
