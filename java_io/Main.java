import java.lang.reflect.*;
public class Main {
    static void customer(ProxyInterface pi) {
        pi.say();
    }

    public static void main(String [] args){
        RealObject real = new RealObject();
        ProxyInterface proxy = (ProxyInterface)Proxy.newProxyInstance(ProxyInterface.class.getClassLoader(),new Class[]{ProxyInterface.class}, new ProxyObject(real));
        //ProxyInterface proxy = (ProxyInterface) Proxy.newProxyInstance(ProxyInterface.class.getClassLoader(), new Class[] {ProxyInterface.class}, new ProxyObject(real));
        customer(proxy);
    }
}

interface ProxyInterface {
    void say();
}

    //realobject
class RealObject implements ProxyInterface {
    public void say() {
        System.out.println("I'm thinking.");
    }
}

class ProxyObject implements InvocationHandler{
    private Object proxied = null;
    public ProxyObject(){

    }

    public ProxyObject(Object proxied){
        this.proxied = proxied;
    }

    public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable{
        System.out.println("hello,zyh");
        return arg1.invoke(proxied, arg2);
    };
}
