package com.az.mall.infrastructure.util;

import com.az.mall.infrastructure.annotation.WebLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StringUtils;

/**
 * @author AZ
 * @since 2021-11-02
 */
@Slf4j
public class WebLogAspect {

    @Pointcut("@annotation(com.az.mall.infrastructure.annotation.WebLog)")
    public void webLogInspect() {
    }

    @Around("webLogInspect()&&@annotation(webLog)")
    public Object aroundMethod(ProceedingJoinPoint joinPoint, WebLog webLog) throws Throwable {
        String description = StringUtils.hasLength(webLog.value()) ? webLog.value() : joinPoint.getSignature().getName();
        if (log.isInfoEnabled()) {
            Object[] args = joinPoint.getArgs();
            StringBuilder arguments = new StringBuilder();
            for (Object arg : args) {
                arguments.append(arg.toString());
            }
            log.info(description + "入参：" + arguments.toString());
        }
        Object proceed = joinPoint.proceed();
        if (log.isInfoEnabled()) {
            log.info(description + "出参：" + proceed.toString());
        }
        return proceed;
    }

    public boolean isNullOrBlank(String string) {
        StringUtils.hasText(string);
        return string == null || string.trim().length() == 0 || "null".equals(string.toLowerCase().trim());
    }
}
