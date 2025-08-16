package com.example.group51_kurbanihut.Redeta;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppendableObjectOutputStreamDeliveryMan extends ObjectOutputStream {
    public AppendableObjectOutputStreamDeliveryMan(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException{
        //
    }
}
