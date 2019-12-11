/*
package UtileS.DatetoFormat;

import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilDateEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        // yyyy-MM-dd yyyy-MM-dd HH:mm:ss
        Date date = null;
        if (StringUtils.hasLength(text)) {
            int lenth = text.length();
            try {
                if (lenth == 10) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    date = sdf.parse(text);
                } else {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    date = sdf.parse(text);
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        this.setValue(date);
    }
}
*/
