package com.xulei.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xl
 * @Description:  动态代理距离
 * @date: 2021-05-13 21:24
 * @since JDK 1.8
 */
public class ProxyTest {

    public static void main(String[] args) {
        SuperMan superMan =new SuperMan();
        //proxyInstance:代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        //当通过代理类对象调用方法时，会自动调用被代理类中同名的方法
        String belief = proxyInstance.getBelief();
        proxyInstance.eat("四川麻辣烫");
        System.out.println(belief);

        System.out.println("**************");
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory proxyClothFactory = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);
        proxyClothFactory.produceCloth();

    }
}


interface Human{
    /**
     * 信仰
     * @return a
     */
    String getBelief();

    /**
     * 吃
     * @param food A
     */
    void eat(String food);
}

/**
 * 被代理类
 */
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I believe I can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃"+food);
    }
}

class  HumanUtil{
    public void method1(){
        System.out.println("通用方法一");

    }

    public void method2(){
        System.out.println("通用方法二");
    }

}


class ProxyFactory{

    /**
     * 调用此方法，返回一个代理类的对象
     * @param obj  被代理类的对象
     * @return  返回代理的的对象
     */
    public static Object getProxyInstance(Object obj){//obj:被代理类的对象
        MyInvocationHandler handler =new MyInvocationHandler();
        handler.bind(obj);
        /*
        newProxyInstance()
         */
       return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);

    }

}

class MyInvocationHandler implements InvocationHandler{
    /**
     * 需要使用被代理类的对象进行赋值
     */
    private Object obj;

    public void bind(Object obj){
        this.obj=obj;
    }

    /**
     * 当我们通过代理的对象，调用方法a时，就会自动调用如下的方法：invoke()
     * 将被代理类要执行的方法a的功能就声明在invoke()中
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        HumanUtil util =new HumanUtil();
        util.method1();
        //method：即为代理类对象调用的方法，此方法也就作为被代理类对象要调用的方法
        //obj:被代理的对象
        Object returnValue = method.invoke(obj, args);
        util.method2();
        //上述方法的返回值就作为当前类中的invoke()的返回值
        return returnValue;
    }
}