package UtileS.ExportToExcel.CommonUtile;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * list数据导出到excel表格中工具类
 * @author xgf
 *
 */
public class ExportExcel
{
    private static Logger logger = LoggerFactory.getLogger(ExportExcel.class);
    /**
     * 数据转换
     * @param list 数据
     * @param fileName 文件地址
     * @param type 是否需要排序：1需要排序，2不需要排序
     * @param headersNew 排序字段
     */
    public static void exportExcelUtil(List<?> list,String fileName,String type,String[] headersNew,Object obj) {
        try {
            //List<Model>转List<Map>
            List<Map> dataset=new ArrayList<Map>();

            Map<String,String> mapPx=new HashMap<String,String>();//获取排序数组下标
            for (int i = 0; i < headersNew.length; i++) {
                mapPx.put(headersNew[i], i+"");
            }

            for (int i = 0; i < list.size(); i++) {
                if(type.equals("1")){
                    Map map=transBean2Map(list.get(i));
                    Map mapNew=new HashMap<>();
                    for (Object key : map.keySet()) {
                        mapNew.put(mapPx.get(key.toString()), map.get(key));
                    }
                    mapNew=MapKeyComparator.sortMapByKey(mapNew);
                    dataset.add(mapNew);
                }else{
                    dataset.add(transBean2Map(list.get(i)));
                }
            }

            //获取表头
            Map<String,String> map = ClassUtil.getAllDesc(obj);

            //设置excel表头
            //String[] headers={"mc","rq","sj"};
            String[] headers=null;

            Object[] keys  =  map.keySet().toArray();//从实体类中取字段
            String[]  headersZd=new String[keys.length];
            for (int i = 0; i < keys.length; i++) {
                headersZd[i]=keys[i].toString();
            }
            if(type.equals("1")){
                headers=headersNew;
            }else{
                headers=headersZd;
            }

            String[] headersTitle=null;

            Object[] keysTitle  =  map.values().toArray();//从实体类中取字段注释
            String[] headersTitleZs=new String[keysTitle.length];
            for (int i = 0; i < keysTitle.length; i++) {
                headersTitleZs[i]=keysTitle[i].toString();
            }

            if(type.equals("1")){
                Map<String,String> mapZs=new HashMap<String,String>();
                for (int i = 0; i < headersZd.length; i++) {
                    mapZs.put(headersZd[i], headersTitleZs[i]);
                }
                headersTitle=new String[headersTitleZs.length];
                for (int i = 0; i < headers.length; i++) {
                    headersTitle[i]=mapZs.get(headers[i]);
                }

            }else{
                headersTitle=headersTitleZs;
            }


            //获取类上的注解值
            String title=ClassUtil.getClassName(obj.getClass());
            if(StringUtils.isNotBlank(title)==false){
                title="Sheet1";
            }

            exportExcel(fileName,title,headers,headersTitle,dataset,"yyyy-MM-dd","2");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 把内容写入excel表格中
     * @param fileName 文件地址
     * @param title excel表格工作空间名称
     * @param headers 表格列字段
     * @param headersTitle 表格表头中文字段
     * @param dataset 数据
     * @param pattern 日期、时间格式化输出
     * @param type 表格表头展示方式：1实体类字段名，2实体类字段名注释
     * @return
     */
    public static boolean exportExcel(String fileName, String title, String[] headers,String[] headersTitle, List<Map> dataset, String pattern,String type)
    {
        boolean flag = false;
        Workbook workbook = null;
        if (fileName.endsWith("xlsx"))
        {
            workbook = new XSSFWorkbook();
        } else if (fileName.endsWith("xls"))
        {
            workbook = new HSSFWorkbook();
        } else
        {
            try
            {
                throw new Exception("invalid file name, should be xls or xlsx");
            } catch (Exception e)
            {
                logger.info("必须是xls或者xlsx结尾的文件.");
                e.printStackTrace();
            }

        }

        Sheet sheet = workbook.createSheet(title);
        XSSFCellStyle style = (XSSFCellStyle) workbook.createCellStyle();

        // 列名
        Row row = sheet.createRow(0);
        switch (type) {
            case "1":
                for (int i = 0; i < headers.length; i++)
                {
                    Cell cell = row.createCell(i);
                    sheet.setColumnWidth(i, 5000);
                    style.setAlignment(HorizontalAlignment.CENTER);
                    cell.setCellValue(headers[i]);
                }
                break;
            case "2":
                for (int i = 0; i < headersTitle.length; i++)
                {
                    Cell cell = row.createCell(i);
                    sheet.setColumnWidth(i, 5000);
                    style.setAlignment(HorizontalAlignment.CENTER);
                    cell.setCellValue(headersTitle[i]);
                }
                break;
        }


        Iterator<Map> it = dataset.iterator();
        int index = 0;
        while (it.hasNext())
        {
            index++;
            row = sheet.createRow(index);

            Map map = it.next();
            logger.info(map.toString());
            Set<String> mapKey = (Set<String>)map.keySet();
            logger.info(mapKey.toString());
            Iterator<String> iterator = mapKey.iterator();
            logger.info(iterator.toString());
            int num  = 0;
            while(iterator.hasNext()){
                Cell cell = row.createCell(num);
                num++;
                String key = iterator.next();
                logger.info(key);
                Object obj = map.get(key);
                if (obj instanceof Date || obj instanceof Timestamp)
                {
                    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                    cell.setCellValue(sdf.format(obj));
                } else if (obj instanceof Integer)
                {
                    cell.setCellValue((Integer) obj);
                } else if (obj instanceof Double)
                {
                    cell.setCellValue((Double) obj);
                }else
                {
                    cell.setCellValue((String) obj);
                }
            }
        }

        FileOutputStream fos;
        try
        {
            fos = new FileOutputStream(fileName);
            workbook.write(fos);
            fos.close();
            flag = true;
        } catch (FileNotFoundException e)
        {
            logger.info("文件不存在");
            flag = false;
            e.printStackTrace();
        } catch (IOException e)
        {
            logger.info("文件写入错误");
            flag = false;
            e.printStackTrace();

        }
        return flag;
    }
    /**
     * 实体类转map
     * @param obj
     * @return
     */
    public static Map<String, Object> transBean2Map(Object obj) {
        if (obj == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                // 过滤class属性
                if (!key.equals("class")) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(obj);

                    map.put(key, value);
                }

            }
        } catch (Exception e) {
            logger.error("transBean2Map Error {}" ,e);
        }
        return map;

    }
}