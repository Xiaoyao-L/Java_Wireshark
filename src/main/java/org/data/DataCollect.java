package org.data;

/**
 * @author Xiaoyao.L
 * @date 2020/2/22 0:10
 * @project wireshark
 */
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.command.Cmd;

@SuppressWarnings("unused")
public class DataCollect {
    private ArrayList<Packet> packets = new ArrayList<>();
    public DataCollect() {
        while(true) {
            Cmd temp =new Cmd();
            ArrayList<String> list = temp.runCmd("tshark -r "+temp.getFilePath()+temp.getFilterInfo()+temp.getSpecificInfo());
            for(int i = 0; i <= list.size(); i++)
            {
                Packet e = new Packet();
                e.setSourceAddress(list.get(i));
                packets.add(e);
            }
            int res = JOptionPane.showConfirmDialog(null, "Continue?","Continue",JOptionPane.YES_NO_OPTION);

            if(res == JOptionPane.YES_OPTION) {
                break;
            }
        }
    }
    public ArrayList<Packet> getPackets() {
        return packets;
    }
    public void setPackets(ArrayList<Packet> packets) {
        this.packets = packets;
    }

    //public static void main(String args[]) {
     //   DataCollect data = new DataCollect();
    //}
}
