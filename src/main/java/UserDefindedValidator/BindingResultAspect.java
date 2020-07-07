package UserDefindedValidator;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * @ClassName BindingResultAspect
 * @Description
 * @Author Administrator
 * @Date 2020/7/7 0007 10:40
 */
@Aspect
@Component
@Order(2)    // 加载bean的顺序
public class BindingResultAspect {
    @Pointcut("execution(public * *.*.*(..))")
    public void BindingResult() {
    }

    @Around("BindingResult()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof BindingResult) {
                BindingResult result = (BindingResult) arg;
                if (result.hasErrors()) {
                    FieldError fieldError = result.getFieldError();
                    if(fieldError!=null){
                        return fieldError.getDefaultMessage();
                    }else{
                        return fieldError.getDefaultMessage();
                    }
                }
            }
        }
        return joinPoint.proceed();
    }
}
