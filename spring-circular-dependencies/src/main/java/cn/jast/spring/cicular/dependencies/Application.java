package cn.jast.spring.cicular.dependencies;

import cn.jast.spring.cicular.dependencies.config.CircularDependenciesBySetterInjectContext;
import cn.jast.spring.cicular.dependencies.config.ConstructorInjectContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        circularDependenciesBySetterInjectContext();
    }

    /**
     * /Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=56888:/Applications/IntelliJ IDEA CE.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home/jre/lib/charsets.jar:/Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home/jre/lib/ext/cldrdata.jar:/Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home/jre/lib/ext/dnsns.jar:/Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home/jre/lib/ext/jaccess.jar:/Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home/jre/lib/ext/localedata.jar:/Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home/jre/lib/ext/nashorn.jar:/Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home/jre/lib/ext/sunec.jar:/Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home/jre/lib/ext/sunjce_provider.jar:/Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home/jre/lib/ext/sunpkcs11.jar:/Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home/jre/lib/ext/zipfs.jar:/Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home/jre/lib/jce.jar:/Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home/jre/lib/jsse.jar:/Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home/jre/lib/management-agent.jar:/Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home/jre/lib/resources.jar:/Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home/jre/lib/rt.jar:/Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home/lib/dt.jar:/Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home/lib/jconsole.jar:/Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home/lib/sa-jdi.jar:/Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home/lib/tools.jar:/Users/zhangzhiwen/github/java-tutorial/spring-circular-dependencies/target/classes:/Users/zhangzhiwen/.m2/repository/org/springframework/spring-context/4.3.26.RELEASE/spring-context-4.3.26.RELEASE.jar:/Users/zhangzhiwen/.m2/repository/org/springframework/spring-aop/4.3.26.RELEASE/spring-aop-4.3.26.RELEASE.jar:/Users/zhangzhiwen/.m2/repository/org/springframework/spring-beans/4.3.26.RELEASE/spring-beans-4.3.26.RELEASE.jar:/Users/zhangzhiwen/.m2/repository/org/springframework/spring-core/4.3.26.RELEASE/spring-core-4.3.26.RELEASE.jar:/Users/zhangzhiwen/.m2/repository/commons-logging/commons-logging/1.2/commons-logging-1.2.jar:/Users/zhangzhiwen/.m2/repository/org/springframework/spring-expression/4.3.26.RELEASE/spring-expression-4.3.26.RELEASE.jar:/Users/zhangzhiwen/.m2/repository/org/springframework/spring-test/4.3.26.RELEASE/spring-test-4.3.26.RELEASE.jar cn.jast.spring.cicular.dependencies.Application
     * 十月 23, 2020 9:16:47 上午 org.springframework.context.annotation.AnnotationConfigApplicationContext prepareRefresh
     * 信息: Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@4d405ef7: startup date [Fri Oct 23 09:16:47 CST 2020]; root of context hierarchy
     * 十月 23, 2020 9:16:47 上午 org.springframework.context.annotation.AnnotationConfigApplicationContext refresh
     * 警告: Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'beanA' defined in file [/Users/zhangzhiwen/github/java-tutorial/spring-circular-dependencies/target/classes/cn/jast/spring/cicular/dependencies/component/BeanA.class]: Unsatisfied dependency expressed through constructor parameter 0; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'beanB' defined in file [/Users/zhangzhiwen/github/java-tutorial/spring-circular-dependencies/target/classes/cn/jast/spring/cicular/dependencies/component/BeanB.class]: Unsatisfied dependency expressed through constructor parameter 0; nested exception is org.springframework.beans.factory.BeanCurrentlyInCreationException: Error creating bean with name 'beanA': Requested bean is currently in creation: Is there an unresolvable circular reference?
     * Exception in thread "main" org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'beanA' defined in file [/Users/zhangzhiwen/github/java-tutorial/spring-circular-dependencies/target/classes/cn/jast/spring/cicular/dependencies/component/BeanA.class]: Unsatisfied dependency expressed through constructor parameter 0; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'beanB' defined in file [/Users/zhangzhiwen/github/java-tutorial/spring-circular-dependencies/target/classes/cn/jast/spring/cicular/dependencies/component/BeanB.class]: Unsatisfied dependency expressed through constructor parameter 0; nested exception is org.springframework.beans.factory.BeanCurrentlyInCreationException: Error creating bean with name 'beanA': Requested bean is currently in creation: Is there an unresolvable circular reference?
     * 	at org.springframework.beans.factory.support.ConstructorResolver.createArgumentArray(ConstructorResolver.java:749)
     * 	at org.springframework.beans.factory.support.ConstructorResolver.autowireConstructor(ConstructorResolver.java:189)
     * 	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.autowireConstructor(AbstractAutowireCapableBeanFactory.java:1196)
     * 	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1098)
     * 	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:511)
     * 	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:481)
     * 	at org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:312)
     * 	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:230)
     * 	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:308)
     * 	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:197)
     * 	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:757)
     * 	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:867)
     * 	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:542)
     * 	at org.springframework.context.annotation.AnnotationConfigApplicationContext.<init>(AnnotationConfigApplicationContext.java:84)
     * 	at cn.jast.spring.cicular.dependencies.Application.constructorInjectContext(Application.java:13)
     * 	at cn.jast.spring.cicular.dependencies.Application.main(Application.java:9)
     * Caused by: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'beanB' defined in file [/Users/zhangzhiwen/github/java-tutorial/spring-circular-dependencies/target/classes/cn/jast/spring/cicular/dependencies/component/BeanB.class]: Unsatisfied dependency expressed through constructor parameter 0; nested exception is org.springframework.beans.factory.BeanCurrentlyInCreationException: Error creating bean with name 'beanA': Requested bean is currently in creation: Is there an unresolvable circular reference?
     * 	at org.springframework.beans.factory.support.ConstructorResolver.createArgumentArray(ConstructorResolver.java:749)
     * 	at org.springframework.beans.factory.support.ConstructorResolver.autowireConstructor(ConstructorResolver.java:189)
     * 	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.autowireConstructor(AbstractAutowireCapableBeanFactory.java:1196)
     * 	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1098)
     * 	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:511)
     * 	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:481)
     * 	at org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:312)
     * 	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:230)
     * 	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:308)
     * 	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202)
     * 	at org.springframework.beans.factory.config.DependencyDescriptor.resolveCandidate(DependencyDescriptor.java:211)
     * 	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1132)
     * 	at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1060)
     * 	at org.springframework.beans.factory.support.ConstructorResolver.resolveAutowiredArgument(ConstructorResolver.java:835)
     * 	at org.springframework.beans.factory.support.ConstructorResolver.createArgumentArray(ConstructorResolver.java:741)
     * 	... 15 more
     * Caused by: org.springframework.beans.factory.BeanCurrentlyInCreationException: Error creating bean with name 'beanA': Requested bean is currently in creation: Is there an unresolvable circular reference?
     * 	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.beforeSingletonCreation(DefaultSingletonBeanRegistry.java:347)
     * 	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:223)
     * 	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:308)
     * 	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202)
     * 	at org.springframework.beans.factory.config.DependencyDescriptor.resolveCandidate(DependencyDescriptor.java:211)
     * 	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1132)
     * 	at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1060)
     * 	at org.springframework.beans.factory.support.ConstructorResolver.resolveAutowiredArgument(ConstructorResolver.java:835)
     * 	at org.springframework.beans.factory.support.ConstructorResolver.createArgumentArray(ConstructorResolver.java:741)
     * 	... 29 more
     *
     * Process finished with exit code 1
     */
    private static void constructorInjectContext(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConstructorInjectContext.class);
        context.destroy();
    }

    private static void circularDependenciesBySetterInjectContext(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CircularDependenciesBySetterInjectContext.class);
        context.destroy();
    }
}
