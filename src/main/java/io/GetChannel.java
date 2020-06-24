package io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//three io class can get channel
public class GetChannel {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        try {
            //write the file via FileInputStream
            FileChannel fc = new FileOutputStream("data.txt").getChannel();
            fc.write(ByteBuffer.wrap("some text".getBytes()));
            fc.close();

            //write the file via RandomAccessFile
            fc = new RandomAccessFile("data.txt", "rw").getChannel();
            fc.position(fc.size());//move to the end of the file
            fc.write(ByteBuffer.wrap(" another text".getBytes()));
            fc.close();

            //read the file
            fc = new FileInputStream("data.txt").getChannel();
//            fc.position(4);
            ByteBuffer buff = ByteBuffer.allocate(BSIZE);
            fc.read(buff);
            buff.flip();
            while(buff.hasRemaining())
                System.out.print((char)buff.get());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
