import java.lang.reflect.*;

public class DynamicProxy {
    public static void customer(ProxyInterface pi){
        pi.say();
    }
    public static void main(String[] args) throws Exception{
        RealObject real = new RealObject();
        //1. First Method
        //ProxyInterface proxy = (ProxyInterface)Proxy.newProxyInstance(ProxyInterface.class.getClassLoader(),new Class[]{ProxyInterface.class}, new ProxyObject(real));
        //2. Second Method
        ProxyInterface proxy = (ProxyInterface)Proxy.getProxyClass(ProxyInterface.class.getClassLoader(), ProxyInterface.class).getConstructor(InvocationHandler.class).newInstance(new ProxyObject(real));
        customer(proxy);
    }
}


interface ProxyInterface{
    public void say();
}

//被代理类
class RealObject implements ProxyInterface{
    public void say(){
        System.out.println("i'm talking");
    }
}

//代理类，实现InvocationHandler 接口
class ProxyObject implements InvocationHandler{
    private Object proxied = null;
    public ProxyObject(){
        
    }
    public ProxyObject(Object proxied){
        this.proxied  = proxied;
    }
    public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
        System.out.println("hello1");
        return arg1.invoke(proxied, arg2);
    }
}

