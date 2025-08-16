package com.example.group51_kurbanihut.Nahien;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppendableObjectOutputStreamFeedback extends ObjectOutputStream {
    public AppendableObjectOutputStreamFeedback(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException{
        //
    }
}
