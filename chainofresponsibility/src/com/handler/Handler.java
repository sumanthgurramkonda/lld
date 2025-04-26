package com.handler;

public interface Handler {
    void setNext(Handler handler);
    void handleRequest(String request);
    default void noHandler(String request){
        System.out.println("No handler exists with type "+request);
    }
}

class ConcreteHandler1 implements Handler{

    private Handler nextHandler;

    @Override
    public void setNext(Handler handler) {
        this.nextHandler=handler;
    }

    @Override
    public void handleRequest(String request) {
        if(request.equals("type1")){
            System.out.println("Handling request in concretehandler1");
        }else if (nextHandler!=null){
            nextHandler.handleRequest(request);
        }else{
            noHandler(request);
        }
    }
}

class ConcreteHandler2 implements Handler{

    private Handler nextHandler;

    @Override
    public void setNext(Handler handler) {
        this.nextHandler=handler;
    }

    @Override
    public void handleRequest(String request) {
        if(request.equals("type2")){
            System.out.println("Handling request in concretehandler2");
        }else if (nextHandler!=null){
            nextHandler.handleRequest(request);
        }else{
            noHandler(request);
        }
    }
}

class  Main{
    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        handler1.setNext(handler2);

        handler1.handleRequest("type1");
        handler1.handleRequest("type2");
        handler2.handleRequest("type1");
    }
}