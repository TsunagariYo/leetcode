package UtileS.ExportToExcel.CommonUtile;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 实体类方法注解类
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomTagMethod {
    //字段的描述注解
    String name();
}