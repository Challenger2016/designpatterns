/*
 * Copyright (c) 1999, 2013, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package com.study.designpatterns.proxy.customize;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicLong;

public class DProxy implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    public static final String ln = "\r\n";

    public static Object getProxyInstance(DClassLoader classLoader, Class<?> interfaces[],
                                          DInvocationHandler invocationHandler) throws Exception {
        AtomicLong proxyNum = new AtomicLong(0);
        String className = "$Proxy" + proxyNum.getAndIncrement();//存储生成的类名

        //1.动态生成源代码
        String src = generateCode(interfaces, className);
        //2.Java文件输出到磁盘
        String filePath = DProxy.class.getResource("").getPath();
        //System.out.println(filePath); //查看Java文件
        File f = new File(filePath + className + ".java");
        FileWriter fw = new FileWriter(f);
        fw.write(src);
        fw.flush();
        fw.close();
        //3.将生成的Java文件编译成.class文件 JavaComiler  since 1.6
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
        Iterable iterable = manager.getJavaFileObjects(f);
        JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
        task.call();
        manager.close();
        //4.将编译生成的.class文件加载到jvm中
        Class proxyClass = classLoader.findClass(className);
        Constructor constructor = proxyClass.getConstructor(DInvocationHandler.class);

        //删除文件
        //f.delete(),这里为了方便看到Java代码就没有删除

        //5.返回字节码重组后的代理对象
        return constructor.newInstance(invocationHandler);
    }

    //生成代理类的源代码
    private static String generateCode(Class<?> interfaces[], String className) {
        StringBuffer sb = new StringBuffer();
        sb.append(DProxy.class.getPackage() + ";" + ln)
                .append("import java.lang.reflect.Method;" + ln)
                .append("public class "+className+" implements ");

        for (int i = 0; i < interfaces.length; i++) {//实现多个接口
            Class<?> interf = interfaces[i];
            if (i == 0) {
                sb.append(interf.getName());
            } else {
                sb.append("," + interf.getName());
            }
        }

        sb.append("{" + ln)
                .append("    DInvocationHandler h;" + ln + ln)
                .append("    public " + className + "(DInvocationHandler h) {" + ln)//构造方法
                .append("        this.h = h;" + ln)
                .append("    }" + ln + ln);

        for (Class interf : interfaces) {
            for (Method m : interf.getMethods()) {
                //判断返回值是否为空
                boolean isVoid = "void".equals(m.getReturnType().getName());
                //方法的所有参数类型
                Class<?>[] parameterTypes = m.getParameterTypes();
                //方法的参数类型集合
                StringBuffer paramTypeStr = new StringBuffer();
                //方法的变量名集合
                StringBuffer paramNameStr = new StringBuffer();
                //存储参数类型+变量名
                StringBuffer args = new StringBuffer();
                for (int i = 0; i < parameterTypes.length; i++) {
                    String parameterName = parameterTypes[i].getName();
                    String arg = "arg" + i;
                    if (i == 0) {
                        paramTypeStr.append(parameterName + ".class");
                        paramNameStr.append(arg);
                        args.append(parameterName + " " + arg);
                    } else {
                        paramTypeStr.append("," + parameterName + ".class");
                        paramNameStr.append("," + arg);
                        args.append("," + parameterName + " " + arg);
                    }
                }

                sb.append("    @Override" + ln)
                        .append("    public " + m.getReturnType().getName() + " " + m.getName() + "(" + args + ") {" + ln)
                        .append("        try{" + ln)
                        .append("            Method m = " + interf.getName() + ".class.getMethod(\"" + m.getName() + "\"");

                if (!"".equals(paramTypeStr.toString())) {
                    sb.append("," + paramTypeStr.toString());
                }
                sb.append(");" + ln + "            ");

                if (!isVoid) {
                    sb.append("return (" + m.getReturnType().getName() + ")");
                }
                //关键所在，就是这里调用了InvocationHandler的invoke方法。
                sb.append("this.h.invoke(this,m");
                if (!"".equals(paramNameStr.toString())) {
                    sb.append("," + paramNameStr);
                }
                sb.append(");" + ln)
                        .append("         }catch(Throwable e){" + ln)
                        .append("             e.printStackTrace();" + ln)
                        .append("         }" + ln);
                if (!isVoid) {
                    sb.append("        return null;" + ln);
                }
                sb.append("    }" + ln + ln);
            }
        }

        sb.append("}" + ln);
        return sb.toString();
    }
    
}
