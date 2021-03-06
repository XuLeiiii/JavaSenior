package com.xulei.java1

/**
 * @Description:注解的使用
 * @date: 2021-04-28 18:01
 * @author xl
 * @since JDK 1.8
 * 1.Annotation 其实就是代码里的特殊标记, 这些标记可以在编译, 类加
载, 运行时被读取, 并执行相应的处理。通过使用 Annotation, 程序员
可以在不改变原有逻辑的情况下, 在源文件中嵌入一些补充信息。代
码分析工具、开发工具和部署工具可以通过这些补充信息进行验证
或者进行部署。


 2.在JavaSE中，注解的使用目的比较简单，例如标记过时的功能，
忽略警告等。在JavaEE/Android中注解占据了更重要的角色，例如
用来配置应用程序的任何切面，代替JavaEE旧版中所遗留的繁冗
代码和XML配置等



 注解的使用：
示例一：生成文档相关的注解
示例二：在编译时进行格式检查(JDK内置的三个基本注解)
@Override: 限定重写父类方法, 该注解只能用于方法
@Deprecated: 用于表示所修饰的元素(类, 方法等)已过时。通常是因为
所修饰的结构危险或存在更好的选择
@SuppressWarnings: 抑制编译器警告
 */
class AnnotationTest {

}