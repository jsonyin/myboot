package com.iny.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by zcy on 2018/1/22.
 */
public class IOReadAndWrite {
    public static void main(String args[]){
        try {
            //fileIO();
            channelTest();
        }catch (Exception e){

        }
    }

    private static void fileIO()throws IOException{
        File rfile  = new File("/Users/zcy/Desktop/read1");
        File ofile  = new File("/Users/zcy/Desktop/write1");
        if(!ofile.exists()){
            System.out.print("can not get the file");
            ofile.createNewFile();
        }

        BufferedReader br = new BufferedReader(new FileReader(rfile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(ofile));
        try{
            String line = br.readLine();

            while(line != null){
                bw.write(line,0,line.length());
                bw.newLine();
                System.out.println(line);
                line = br.readLine();
            }
            bw.flush();
        }catch (IOException e){

        }finally {
            br.close();
            bw.close();
        }
    }

    private static void channelTest() throws Exception {
        RandomAccessFile file = new RandomAccessFile("/Users/zcy/Desktop/read1","rw");
        FileChannel channel = file.getChannel();

        ByteBuffer bb = ByteBuffer.allocate(48);
         int byteRead = channel.read(bb);

        while(byteRead !=-1){
            System.out.println("read"+ byteRead);
            bb.flip();
            while(bb.hasRemaining()){
                System.out.print((char) bb.get());
            }
            bb.clear();
            byteRead=channel.read(bb);
        }
        file.close();
    }
}
