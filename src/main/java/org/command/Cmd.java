package org.command;

/**
 * @author Xiaoyao.L
 * @date 2020/2/19 15:05
 * @project wireshark
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.*;

//import data.Packet;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

@SuppressWarnings("unused")
public class Cmd {
    private String filePath;
    private String filterInfo;
    private String specificInfo;
    private String data;
    public Cmd() {
        String filePath = null;
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showOpenDialog(fileChooser);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            filePath= fileChooser.getSelectedFile().getAbsolutePath();
        }
        this.setFilePath(filePath);
        String s1=JOptionPane.showInputDialog("Input the filter info");
        this.setFilterInfo(" -2 -R "+"\""+s1+"\"");

        String s2=JOptionPane.showInputDialog("Input the specific info");
        this.setSpecificInfo(" -T fields -e "+s2);

        this.setData(null);


    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setFilterInfo(String filterInfo) {
        this.filterInfo = filterInfo;
    }

    public void setSpecificInfo(String specificInfo) {
        this.specificInfo = specificInfo;
    }

    public ArrayList<String> runCmd(String cmd) {
        ArrayList<String> temp = new ArrayList<>();
        try {
            Process ps = Runtime.getRuntime().exec(cmd);
            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream(), Charset.forName("GBK")));
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {

                temp.add(line);
                System.out.println(temp.get(i));
                i++;
            }

            br.close();
            ps.waitFor();

        } catch (IOException | InterruptedException ioe) {
            ioe.printStackTrace();
        }
        return temp;
    }

    public String getFilePath()
    {
        return filePath;
    }

    public String getFilterInfo() {

        return filterInfo;
    }

    public String getSpecificInfo()
    {
        return specificInfo;
    }
    public static void main(String[] args){

    Cmd command = new Cmd();
    command.runCmd("tshark -r "+command.getFilePath()+command.getFilterInfo()+command.getSpecificInfo());
    }
}

