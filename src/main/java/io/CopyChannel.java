package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyChannel {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        try {
            FileChannel in = new FileInputStream("data.txt").getChannel();
            FileChannel out = new FileOutputStream("out.txt").getChannel();
            ByteBuffer buff = ByteBuffer.allocate(BSIZE);

            while (in.read(buff) != -1) {
                buff.flip();
                out.write(buff);
                buff.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyChannel(String inPath, String outPath){
        try {
            FileChannel in = new FileInputStream(inPath).getChannel();
            FileChannel out = new FileOutputStream(outPath).getChannel();
            //ByteBuffer buff = ByteBuffer.allocate(BSIZE);

            in.transferTo(0, in.size(), out);
            //or
            //out.transferFrom(in, 0, in.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
