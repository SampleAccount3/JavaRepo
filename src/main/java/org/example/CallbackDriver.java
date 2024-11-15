package org.example;

public class CallbackDriver<T> {
    ICallbackAble<T> callbackAble;
    private T value;
    public CallbackDriver(ICallbackAble<T> callbackAble, T value) {
        this.callbackAble = callbackAble;
        this.value = value;
    }
    public T executeCallback(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return callbackAble.onComplete(this.value);
    }
}
