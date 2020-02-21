package org.data;

/**
 * @author Xiaoyao.L
 * @date 2020/2/22 0:08
 * @project wireshark
 */
public class Packet {
    private String sourceAddress;
    private String destinationAddress;
    private String frameTime;
    public Packet(String address, int type)
    {
        if(type == 1)
        {
            this.sourceAddress = address;
        }
        else
        {
            this.destinationAddress = address;
        }
    }
    public Packet() {
    }
    public String getSourceAddress() {
        return sourceAddress;
    }
    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
    }
    public String getDestinationAddress() {
        return destinationAddress;
    }
    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }
    public String getFrameTime() {
        return frameTime;
    }
    public void setFrameTime(String frameTime) {
        this.frameTime = frameTime;
    }
}
