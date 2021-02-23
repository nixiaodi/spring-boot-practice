package org.jiang.model;

public class MyBody {
    private byte[] bodys;

    public MyBody(byte[] bodys){
        this.bodys = bodys;
    }

    @Override
    public String toString() {
        return new String(bodys);
    }
}
