package com.creatingCustomAnnotations._SpringBoot_Annotations.aop;

import com.creatingCustomAnnotations._SpringBoot_Annotations.util.FileUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Aspect
public class SaveInFileAspect {

//    @Before()
//    @Around()
    @After("@annotation(com.creatingCustomAnnotations._SpringBoot_Annotations.aop.SaveInFile)")
    public void saveInFile(JoinPoint joinPoint){
        //Interceptar el método y su nombre
        //System.out.println(joinPoint.getSignature().getName());

        StringBuilder sb = new StringBuilder();
        String methodName = joinPoint.getSignature().getName();
        String onClass = joinPoint.getTarget().getClass().getName();
        List<Object> args = new ArrayList<>(Arrays.asList(joinPoint.getArgs()));
        LocalDateTime now = LocalDateTime.now();
        //method 'exchange', args: [USD, 10.333], at: 2022-03-03T10:09:40.669626200
        String toWrite =
                sb.append("method '"+methodName+"'")
                        .append(", ")
                        .append("on Class '" + onClass)
                        .append(", ")
                        .append("args: "+args.toString())
                        .append(", at: ")
                        .append(now.toString())
                        .toString();
        try {
            FileUtil.write(toWrite, this.getAnnotationParams(joinPoint));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getAnnotationParams(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SaveInFile myAnnotation = method.getAnnotation(SaveInFile.class);
        return myAnnotation.value();
    }
}
