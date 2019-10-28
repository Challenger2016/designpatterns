/**
 * @(#)DClassLoader.java
 *
 * @author Challenger
 * @version 1.0 2019年8月5日
 *
 * Copyright (C) 2000,2019 , TeamSun, Inc.
 */
package com.study.designpatterns.proxy.customize;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 
 * Purpose:
 * 
 * @author Challenger
 * @see	    
 * @since   6.1.0
 */
public class DClassLoader extends ClassLoader {

    private File classPathFile;

    public DClassLoader() {
        String classPath = this.getClass().getResource("").getPath();
        this.classPathFile = new File(classPath);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = this.getClass().getPackage().getName() + "." + name;
        if (classPathFile != null) {
            //创建同名的class文件
            File classFile = new File(classPathFile, name.replaceAll("\\.", "/") + ".class");
            if (classFile.exists()) {//如果class文件已经存在
                FileInputStream fis = null;
                ByteArrayOutputStream out = null;
                try {
                    fis = new FileInputStream(classFile);
                    out = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int len;
                    while ((len = fis.read(buff)) != -1) {
                        out.write(buff, 0, len);
                    }
                    return defineClass(className, out.toByteArray(), 0, out.size());//将字节转换为class
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {//关闭流操作
                    try {
                        if (null != out) {
                            out.close();
                        }
                        if (null != fis) {
                            fis.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
        return super.findClass(name);
    }
}



/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2019年8月5日 Challenger 创建版本
 */