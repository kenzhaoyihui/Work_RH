public class StaticProxy{
    public static void consumer(ProxyInterface pi){
        pi.say();
    }
    public static void main(String [] args){
        consumer(new ProxyObject());

    }
}

interface ProxyInterface{
    public void say();
}

//realobject
class RealObject implements ProxyInterface{
    @Override
    public void say(){
        System.out.println("say");
    }
}

class ProxyObject implements ProxyInterface{
    @Override
    public void say(){
        System.out.println("hello proxy");
        RealObject a = new RealObject();
        a.say();
        System.out.println("this is method end");
    }
}