package io;

import sun.awt.windows.WBufferStrategy;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class BufferToText {
    private static final int BSIZE = 1024;

        public static void main(String[] args) throws IOException {
        FileChannel fc = new FileOutputStream("data1.txt").getChannel();
        fc.write(ByteBuffer.wrap("some text".getBytes()));
        fc.close();
        fc = new FileInputStream("data1.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        while(buff.hasRemaining()){
            System.out.print((char)buff.get());
        }
        System.out.println();
        buff.rewind();
        //not work
        System.out.println(buff.asCharBuffer());
        //one way
        buff.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println(Charset.forName(encoding).decode(buff));
        fc.close();
        // another
        fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("some text".getBytes("UTF-16BE")));
        fc.close();
        buff.clear();
        fc = new FileInputStream("data2.txt").getChannel();
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());
        fc.close();
    }
//    public static void main(String[] args) throws IOException{
//        FileChannel fc = new RandomAccessFile("data.txt", "rw").getChannel();
//        fc.position(fc.size());
//        fc.write(ByteBuffer.wrap("nihao ".getBytes()));
//        fc.close();
//        fc = new FileInputStream("data.txt").getChannel();
//        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
//        fc.read(buff);
//        buff.flip();
//        System.out.println(Charset.forName(System.getProperty("file.encoding")).decode(buff));
//    }
}
