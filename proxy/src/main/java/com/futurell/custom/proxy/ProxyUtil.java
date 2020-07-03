package com.futurell.custom.proxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @description: 自己实现动态代理
 * @author: Mr.Li
 * @date: Created in 2020/7/1 13:19
 * @version: 1.0
 * @modified By:
 */
public class ProxyUtil {

    /**
     * content --->string
     * .java  io
     * .class
     * <p>
     * .new   反射----》class
     *
     * @return
     */
    public static Object newInstance(Object target) {

        // 定义代理对象
        Object proxy = null;
        // getClass(): Returns the runtime class of this {@code Object}.
        // getInterfaces(): Determines the interfaces implemented by the class or interface represented by this object.
        Class targetInf = target.getClass().getInterfaces()[0];
        Method methods[] = targetInf.getDeclaredMethods();
        String line = "\n";
        String tab = "\t";
        // getSimpleName(): Returns the simple name of the underlying class as given in the source code.
        // infName = "FutureDao";
        String infName = targetInf.getSimpleName();
        String content = "";
        String packageContent = "package com.google;" + line;
        // Returns the name of the entity represented by this {@code Class} object, as a {@code String}.
        // targetInf.getName() = "com.futurell.dao.FutureDao"
        String importContent = "import " + targetInf.getName() + ";" + line;
        String clazzFirstLineContent = "public class $Proxy implements " + infName + "{" + line;
        String filedContent = tab + "private " + infName + " target;" + line;
        String constructorContent = tab + "public $Proxy (" + infName + " target){" + line
                + tab + tab + "this.target = target;"
                + line + tab + "}" + line;
        String methodContent = "";
        for (Method method : methods) {
            // getReturnType(): Returns a Class object that represents the formal return type of the method represented by this {@code Method} object.
            String returnTypeName = method.getReturnType().getSimpleName();
            // getName(): Returns the name of the method represented by this {@code Method} object, as a {@code String}.
            String methodName = method.getName();
            // Sting.class String.class
            Class args[] = method.getParameterTypes();
            String argsContent = "";
            String paramsContent = "";
            int flag = 0;
            for (Class arg : args) {
                //getSimpleName(): Returns the simple name of the underlying class as given in the source code.
                String temp = arg.getSimpleName();
                // String
                // String p0,Sting p1,
                argsContent += temp + " p" + flag + ",";
                paramsContent += "p" + flag + ",";
                flag ++;
            }
            if (argsContent.length() > 0) {
                // lastIndexOf(): Returns the index within this string of the last occurrence of the specified substring.
                argsContent = argsContent.substring(0, argsContent.lastIndexOf(",") - 1);
                paramsContent = paramsContent.substring(0, paramsContent.lastIndexOf(",") - 1);
            }

            methodContent += tab + "public " + returnTypeName + " " + methodName + "(" + argsContent + ") {" + line
                    + tab + tab + "System.out.println(\" Log \");" + line;

            if (returnTypeName.equals("void")) {
                methodContent += tab + tab + "target." + methodName + "(" + paramsContent + ");" + line
                        + tab + "}" + line;
            } else {
                methodContent += tab + tab + "return target." + methodName + "(" + paramsContent + ");" + line
                        + tab + "}" + line;
            }
        }

        content = packageContent + importContent + clazzFirstLineContent + filedContent + constructorContent + methodContent + "}";

        File file = new File("e:\\com\\google\\$Proxy.java");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            fw.write(content);
            fw.flush();
            fw.close();

            /**
             * 编译过程如下:
             */
            // getSystemJavaCompiler(): Gets the Java; programming language compiler provided with this platform.
            // 得到编译类,可以动态的编译一些文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

            // getStandardFileManager(): Gets a new instance of the standard file manager implementation for this tool.
            // 编译文件需要文件管理器
            StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
            // getJavaFileObjects(): Gets file objects representing the given files.
            // 把文件放到文件管理器中
            Iterable units = fileMgr.getJavaFileObjects(file);

            // getTask(): Creates a future for a compilation task with the given components and arguments.
            // JavaCompiler.CompilationTask: Interface representing a future for a compilation task.
            // 把文件管理器当成一个任务来执行
            JavaCompiler.CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
            // call(): Performs this compilation task.
            t.call();
            fileMgr.close();

            // URL[]: Class {@code URL} represents a Uniform Resource Locator, a pointer to a "resource" on the World Wide Web.
            URL[] urls = new URL[]{new URL("file:E:\\\\")};
            // URLClassLoader: This class loader(类加载器) is used to load classes and resources from a search path of URLs
            //                 referring(引用) to both JAR files(Java Archive, Java归档) and directories(目录).
            // JAR: 通常用于聚合大量的Java类文件、相关的元数据和资源（文本、图片等）文件到一个文件,以便开发Java平台应用软件或库。
            URLClassLoader urlClassLoader = new URLClassLoader(urls);
            // loadClass(): Loads the class with the specified <a href="#name">binary name</a>.
            Class clazz = urlClassLoader.loadClass("com.google.$Proxy");
            // getConstructor(): Returns a {@code Constructor} object that reflects(反应) the specified
            //                   public constructor of the class represented by this {@code Class} object.
            // clazz这个类它有构造方法,只能以构造方法来new这个类的实例,所以需要先得到该类的构造方法
            Constructor constructor = clazz.getConstructor(targetInf);

            // newInstance(): Uses the constructor represented by this {@code Constructor} object to
            //                create and initialize a new instance of the constructor's
            //                declaring class, with the specified initialization parameters.
            // 通过构造方法来创建实例
            proxy = constructor.newInstance(target);
            // clazz.newInstance();
            // Class.forName()
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * public UserDaoLog(UserDao target){
         *     this.target = target;
         * }
         */
        return proxy;
    }
}
