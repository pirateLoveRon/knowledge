package com.demo.knowledge.demo;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIODemo {

    public static void main(String args[]) throws Exception {
        testChannel();
//        System.out.println(new String(new byte[]{-28,-67,-96},"UTF-8"));
    }

    private static void testChannel() throws Exception {
        //获取文件
        RandomAccessFile file = new RandomAccessFile("D:\\FILE\\测试文件\\测试文件.txt", "r");
        try {
            System.out.println(file.length());
            //读取文件
            FileChannel channel = file.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(50000);
            int byteRead = channel.read(buffer);
            while (byteRead != -1) {
                System.out.println("Read:" + byteRead);
                buffer.flip();
                while (buffer.hasRemaining()) {
                    byte b = buffer.get();
//                    System.out.print(new String(new byte[]{b}, "UTF-8"));
                    System.out.print(b);
                }
                buffer.clear();
                byteRead = channel.read(buffer);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            file.close();
        }
    }

}
