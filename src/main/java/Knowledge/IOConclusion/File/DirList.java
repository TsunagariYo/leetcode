package Knowledge.IOConclusion.File;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @ClassName DirList
 * @Description 文件目录
 * @Author Administrator
 * @Date 2020/1/6 0006 15:12
 */

public class DirList {
    public static void main(String[] args) {
        File file = new File(".");
        String[] list;
        if (args.length == 0) list = file.list();
        else list = file.list(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(args[0]);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
        Arrays.sort(list);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
