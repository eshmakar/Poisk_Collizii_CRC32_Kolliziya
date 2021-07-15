package com.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.zip.CRC32;

public class Main {

    public static void main(String[] args) throws IOException {
        FileWriter b = new FileWriter(new File("C:/hello_collizii.txt"), true);
        char[] symbols = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~".toCharArray();

        String input = "hello";
        CRC32 crc32 = new CRC32();
        crc32.update(input.getBytes());
        long crcInput = crc32.getValue();

        long start = System.currentTimeMillis();

        String s = "";
        for (char i = 0; i < 95; i++) {
            for (char j = 0; j < 95; j++) {
                for (char k = 0; k < 95; k++) {
                    for (char l = 0; l < 95; l++) {
                        for (char m = 0; m < 95; m++) {
                            s = String.format("%c%c%c%c%c", symbols[i], symbols[j], symbols[k], symbols[l], symbols[m]);

                            CRC32 crcGenerated = new CRC32();
                            crcGenerated.update(s.getBytes());
                            long crcGenerate = crcGenerated.getValue();

                            if (crcInput == crcGenerate) {
                                long stop = System.currentTimeMillis();
                                System.out.println("Найдено!!!");
                                System.out.println(input + " = " + s);
                                b.write(s+"\n");
                                b.flush();
                                System.out.println("Выполнено за " + (double) (stop - start) / 1000 + " секунды, или за " + (double) (stop - start) / 1000 / 60 + " минут");
                                System.out.println();
                                new ProcessBuilder().command("D:\\TCTitan17\\AddOn\\Daum PotPlayer\\PotPlayer.exe").start();//при успехе запустить плеер)
                            }
                        }
                    }
                }
            }
        }
    }
}
