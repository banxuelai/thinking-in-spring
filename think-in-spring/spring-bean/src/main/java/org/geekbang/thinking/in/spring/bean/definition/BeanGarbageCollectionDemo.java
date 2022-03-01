package org.geekbang.thinking.in.spring.bean.definition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Bean 垃圾回收 [GC] 示例
 * @author bxl
 * @date 2022/3/1
 */
public class BeanGarbageCollectionDemo {

    public static void main(String[] args) throws InterruptedException {
        // 创建beanFactory容器
        AnnotationConfigApplicationContext applicationContext  = new AnnotationConfigApplicationContext();

        // 注册 Configuration Class （配置类）
        applicationContext.register(BeanInitializationDemo.class);

        // spring应用上下文启动
        applicationContext.refresh();

        // spring应用上下文关闭
        applicationContext.close();

        Thread.sleep(5000L);
        // 强制GC
        System.gc();
        Thread.sleep(5000L);
    }
}
