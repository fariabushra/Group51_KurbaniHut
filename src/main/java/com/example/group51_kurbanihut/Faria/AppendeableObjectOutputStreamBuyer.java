package com.example.group51_kurbanihut.Faria;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppendeableObjectOutputStreamBuyer extends ObjectOutputStream {
        public AppendeableObjectOutputStreamBuyer(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException{
            //
        }
    }


