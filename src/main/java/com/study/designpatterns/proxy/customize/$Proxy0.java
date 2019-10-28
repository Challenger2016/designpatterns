package com.study.designpatterns.proxy.customize;
import java.lang.reflect.Method;
import com.study.designpatterns.proxy.customize.DInvocationHandler;
public class $Proxy0 implements com.study.designpatterns.proxy.House{
    private DInvocationHandler h;

    public $Proxy0(DInvocationHandler h) {
        this.h = h;
    }

    @Override
    public java.lang.String getAddress() {
        try{
            Method m = com.study.designpatterns.proxy.House.class.getMethod("getAddress");
            return (java.lang.String)this.h.invoke(this,m);
         }catch(Throwable e){
             e.printStackTrace();
         }
        return null;
    }

    @Override
    public java.lang.String getPhone() {
        try{
            Method m = com.study.designpatterns.proxy.House.class.getMethod("getPhone");
            return (java.lang.String)this.h.invoke(this,m);
         }catch(Throwable e){
             e.printStackTrace();
         }
        return null;
    }

}
