package me.lyou.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* me.lyou.aop.service.*.*(..))") // 定义一个切点，该切点匹配me.lyou.aop.service包下的所有方法
    public void serviceMethods() {}

    @Before("serviceMethods()") // 前置通知：在切点方法执行前执行
    public void beforeAdvice() {
        System.out.println("Before method execution.");
    }

    @AfterReturning(pointcut = "serviceMethods()", returning = "result") // 返回后通知：在切点方法成功执行后执行，可以访问返回值
    public void afterReturningAdvice(Object result) {
        System.out.println("After Returning method execution. Result: " + result);
    }

    @AfterThrowing(pointcut = "serviceMethods()", throwing = "error") // 异常通知：在切点方法抛出异常后执行，可以访问异常对象
    public void afterThrowingAdvice(Throwable error) {
        System.out.println("After Throwing method execution. Error: " + error.getMessage());
    }

    @After("serviceMethods()") // 后置通知：在切点方法执行后执行，无论该方法是否成功完成
    public void afterAdvice() {
        System.out.println("After method execution.");
    }

    @Around("serviceMethods()") // 环绕通知：围绕切点方法执行，可以控制何时进入切点方法，何时退出，并可以修改返回值
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before proceeding method execution.");
        Object result = joinPoint.proceed(); // 表示调用目标对象的方法，即连接点
        System.out.println("After proceeding method execution.");
        return result;
    }
}
