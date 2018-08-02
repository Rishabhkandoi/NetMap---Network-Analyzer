/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpcap;

/**
 *
 * @author John
 */
import jpcap.PacketReceiver;
import jpcap.packet.Packet;

public class NetMap_PacketContents implements PacketReceiver
{
	public void receivePacket (Packet packet)
	{
		mainGui.TA_OUTPUT.append (packet.toString() +"\n----------------------------------"+"---------------------------------\n\n");
	}
}
