package Knowledge.IOConclusion.File;


import java.io.File;
import java.io.FilenameFilter;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @ClassName TreeInfo
 * @Description
 * @Author Administrator
 * @Date 2020/1/6 0006 15:43
 */
public final class Directory {
    public static File[] local(File dir, final String regex) {
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);

            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(new File(name).getName()).matches();
            }
        });
    }

    public static File[] local(String path, final String regex) {
        return local(new File(path), regex);
    }

    public static class TreeInfo implements Iterable<File> {
        public List<File> files = new ArrayList<File>();
        public List<File> dirs = new ArrayList<File>();

        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo other) {
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        @Override
        public String toString() {
            return "dirs" + PPrint.Pformat(dirs)
                    + "\n\nfiles" + PPrint.Pformat(files);
        }
    }

    public static TreeInfo walk(String start, String regex) {
        return recurseDirs(new File(start), regex);
    }

    public static TreeInfo walk(File start, String regex) {
        return recurseDirs(start, regex);
    }

    public static TreeInfo walk(String start) {
        return recurseDirs(new File(start), ".*");
    }

    static TreeInfo recurseDirs(File startDir, String regex) {
        TreeInfo result = new TreeInfo();
        for (File file : startDir.listFiles()) {
            if (file.isDirectory()) {
                result.dirs.add(file);
                result.addAll(recurseDirs(file, regex));
            } else if (file.getName().matches(regex)) {
                result.files.add(file);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println(walk("."));
        } else {
            for (String arg : args) {
                System.out.println(walk(arg));
            }
        }
    }
}

class PPrint {
    public static String Pformat(Collection<?> c) {
        if (c.size() == 0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        for (Object elem : c) {
            if (c.size() != 1) builder.append("\n  ");
            builder.append(elem);
        }
        if (c.size() != 1) builder.append("\n");
        builder.append("]");
        return builder.toString();
    }

    public static void pprint(Collection<?> c) {
        System.out.println(Pformat(c));
    }

    public static void pprint(Object[] c) {
        System.out.println(Pformat(Arrays.asList(c)));
    }
}
