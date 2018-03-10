package com.lgh.chinasoft.ticket.server.component;

import com.lgh.chinasoft.ticket.server.common.Response;
import com.lgh.chinasoft.ticket.server.common.ServerException;
import com.lgh.chinasoft.ticket.server.util.ResponseUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
@Aspect
@Component
public class ExceptionHandler {
    private static Log log = LogFactory.getLog(ExceptionHandler.class);

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void exceptionPointcut(){}

    /**
     * 统一处理异常
     * @param point 切点
     * @return 返回结果
     * @throws Throwable 异常
     */
    @Around("exceptionPointcut()")
    @SuppressWarnings("unchecked")
    public Response around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        log.info("[" + point.getSignature().getName() + "] started");
        Response result = ResponseUtil.failed("server error");
        try {
            Response object = (Response)point.proceed();
            long time = System.currentTimeMillis() - beginTime;
            log.info("["+ point.getSignature().getName() + "] ended, use " + time + " ms");
            return object;
        }catch (ServerException e){
            log.error("server error found: " + e.getMessage());
            result.setMessage(e.getMessage());
        }catch (Exception e){
            log.error("uncaught error: " + e.getMessage(),e);
        }
        return result;
    }
}
