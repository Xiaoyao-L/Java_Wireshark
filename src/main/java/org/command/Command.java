package org.command;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * @author Xiaoyao.L
 * @date 2020/2/25 1:37
 * @project wireshark
 */
public class Command {
    public static void Pcap2Json(String cmd) {
        try {
            Process ps = Runtime.getRuntime().exec(cmd);
            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream(), Charset.forName("GBK")));
            String line;
            int i = 0;

            File writename = new File("E:\\aboutTUD\\IoT\\wiresharkProject\\WiresharkProject\\src\\main\\java\\org\\testData\\output.txt");
            writename.createNewFile(); // 创建新文件
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                i++;
                out.write(line+"\r\n"); // \r\n即为换行
                out.flush(); // 把缓存区内容压入文件
            }

            out.close(); // 关闭文件
            br.close();
            ps.waitFor();

        } catch (IOException | InterruptedException ioe) {
            ioe.printStackTrace();
        }

    }
    public static void main(String[] args)
    {
        //Pcap2Json("tshark -2 -Y \"wlan.fc.type_subtype eq 8\" -r E:\\aboutTUD\\IoT\\wiresharkProject\\WiresharkProject\\src\\main\\java\\org\\testData\\test.pcap -T fields -e wlan.ta_resolved -e wlan.da_resolved -T json >E:\\aboutTUD\\IoT\\wiresharkProject\\WiresharkProject\\src\\main\\java\\org\\testData\\temp.json");
        Pcap2Json("tshark -2 -Y \"wlan.fc.type_subtype eq 8\" -r E:\\aboutTUD\\IoT\\wiresharkProject\\WiresharkProject\\src\\main\\java\\org\\testData\\test.pcap -T fields -e wlan.ta_resolved -e wlan.da_resolved -T json");
    }
}
