package com.xulei.java;


interface ClothFactory{
    /**
     *方法
     */
 void produceCloth();

}
/**
 * @author xl
 * @Description: 静态代理  
 * @date: 2021-05-13 21:14
 * @since JDK 1.8
 */

/**
 * 代理类
 */
class ProxyClothFactory implements ClothFactory{
    /**
     * 用被代理对象进行实例化
     */
    private ClothFactory factory;
    public ProxyClothFactory(ClothFactory factory){
        this.factory=factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工程做一些准备工作");
        factory.produceCloth();
        System.out.println("代理工厂做一些后续的收尾工作");
    }
}

class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生成一批运动服");
    }
}


/**
 *  @author xl
 *测试静态代理类
 */
public class StaticProxyTest{
    public static void main(String[] args) {
        //创建被代理类的对象
        NikeClothFactory nike = new NikeClothFactory();
        //创建代理类对象
        ProxyClothFactory proxyClothFactory  = new ProxyClothFactory(nike);

        proxyClothFactory.produceCloth();
    }
}






