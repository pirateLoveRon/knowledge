package com.demo.knowledge.demo;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIODemo {

    public static void main(String args[]) throws Exception {
//        testChannel();
        testBuffer();
    }

    private static void testBuffer() throws Exception {
        RandomAccessFile readFile = new RandomAccessFile("D:\\FILE\\测试文件\\测试文件.txt", "r");
        FileChannel readChannel = readFile.getChannel();

        File file = new File("D:\\FILE\\测试文件\\测试文件2.txt");
        if (!file.exists()) {
            boolean result = file.createNewFile();
        }
        RandomAccessFile writeFile = new RandomAccessFile(file, "rw");
        FileChannel writeChannel = writeFile.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(2);
        int r = 0;
        while ((r = readChannel.read(buffer)) > -1) {
            buffer.flip();
            writeChannel.write(buffer);
            buffer.clear();
        }

        writeChannel.close();
        writeFile.close();
        readChannel.close();
        readFile.close();
    }

    private static void testChannel() throws Exception {
        //读取文件
        RandomAccessFile readFile = new RandomAccessFile("D:\\FILE\\测试文件\\测试文件.txt", "r");
        FileChannel readChannel = readFile.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int r = readChannel.read(buffer);

        buffer.flip();

        File file = new File("D:\\FILE\\测试文件\\测试文件2.txt");
        if (!file.exists()) {
            boolean result = file.createNewFile();
        }
        RandomAccessFile writeFile = new RandomAccessFile(file, "rw");
        FileChannel writeChannel = writeFile.getChannel();
        int w = writeChannel.write(buffer);

        writeChannel.close();
        writeFile.close();
        readChannel.close();
        readFile.close();
    }

}
