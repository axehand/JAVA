package com.ohgiraffers.section04.assignment.repository;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class myOutput extends ObjectOutputStream {
    public myOutput(OutputStream out) throws IOException {
        super(out);
    }

    protected void writeStreamHeader() throws IOException {
    }
}
