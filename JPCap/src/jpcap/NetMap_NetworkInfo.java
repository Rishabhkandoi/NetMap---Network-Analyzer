/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpcap;

import javax.swing.*;
import java.net.*;
import java.util.*;
import java.net.NetworkInterface;
import java.net.InetAddress;

public class NetMap_NetworkInfo
{
	public NetworkInterface NETINT;
	Enumeration <NetworkInterface> ALL_INTERFACES ;
	Enumeration <InetAddress> ALL_ADDRESSES;
	public int InterfaceCount = 0;
	public int InterfaceNumber = 0;

	private JFrame MainWindow = new JFrame ("NetMap v1.0 2017");
	private JLabel L_Title = new JLabel ("Network Interface Information");
	private JLabel L_TotalInterfaces = new JLabel ("Total % Interfaces on this Host:");
	private JLabel L_TotalInterfaces_Box = new JLabel ();
	private JLabel L_InterfaceNumber = new JLabel ("Interface no.:");
	private JLabel L_InterfaceNumber_Box = new JLabel ();
	private JLabel L_InterfaceName = new JLabel ("Interface name:");
	private JLabel L_InterfaceName_Box = new JLabel ();
	private JLabel L_InterfaceID = new JLabel ("Interface ID:");
	private JLabel L_InterfaceID_Box = new JLabel ();
	private JLabel L_MAC = new JLabel ("MAC Address:");
	private JLabel L_MAC_Box = new JLabel ();
	private JLabel L_IP = new JLabel ("IP Address:");
	private JLabel L_IP_Box = new JLabel ();
	private JLabel L_HostName = new JLabel ("Host Name:");
	private JLabel L_HostName_Box = new JLabel ();
	private JLabel L_MTU = new JLabel ("MTU:");
	private JLabel L_MTU_Box = new JLabel ();
	private JLabel L_Status = new JLabel ("Status:");
	private JLabel L_Status_Box = new JLabel ();
	private JLabel L_PointToPoint = new JLabel ("Point To Point:");
	private JLabel L_PointToPoint_Box = new JLabel ();
	private JLabel L_MultiCast = new JLabel ("Multicast");
	private JLabel L_MultiCast_Box = new JLabel ();
	private JLabel L_Loopback = new JLabel ("Loopback:");
	private JLabel L_Loopback_Box = new JLabel ();
	private JLabel L_Virtual = new JLabel ("Virtual:");
	private JLabel L_Virtual_Box = new JLabel ();
	private JButton B_NEXT = new JButton ("NEXT");
	private JButton B_PREVIOUS = new JButton ("PREV");
	private JButton B_QUIT = new JButton ("QUIT");

	public static void main (String[] args)
	{
		new NetMap_NetworkInfo ();
	}

	public NetMap_NetworkInfo ()
	{
		BuildGUI ();
		GetInterfaces ();
		DisplayInterfaceInfo (InterfaceNumber);
	}

	public void GetInterfaces ()
	{
		try
		{
			ALL_INTERFACES = NetworkInterface.getNetworkInterfaces();
			InterfaceCount = Collections.list (ALL_INTERFACES).size();
		}
		catch (SocketException X)
		{
			System.out.println (X);
		}
	}

	public void DisplayInterfaceInfo (int INT_NUM)
	{
		try
		{
			ALL_INTERFACES = NetworkInterface.getNetworkInterfaces();
			NETINT = Collections.list (ALL_INTERFACES).get(INT_NUM);
			L_TotalInterfaces_Box.setText (Integer.toString (InterfaceCount));
			L_InterfaceNumber_Box.setText (Integer.toString (INT_NUM+1));
			L_InterfaceName_Box.setText (NETINT.getDisplayName());
			L_InterfaceID_Box.setText (NETINT.getName());
			L_MAC_Box.setText (Arrays.toString (NETINT.getHardwareAddress()));

			ALL_ADDRESSES = NETINT.getInetAddresses ();

			for (InetAddress X: Collections.list (ALL_ADDRESSES))
			{
				L_IP_Box.setText (X.getHostAddress());
				L_HostName_Box.setText (X.getHostName());
			}

			L_MTU_Box.setText (Integer.toString (NETINT.getMTU()));

			String STATUS;
			if (NETINT.isUp ()) { STATUS = "Up"; }
			else { STATUS = "Down"; }
			L_Status_Box.setText (STATUS);

			String POINTTOPOINT;
                       
                        if (NETINT.isPointToPoint ()) { POINTTOPOINT = "Yes!"; }
			else { POINTTOPOINT = "No"; }
			L_PointToPoint_Box.setText(POINTTOPOINT);
                        
                        String MULTICAST;
                       
                        if (NETINT.supportsMulticast ()) { MULTICAST = "Yes!"; }
			else { MULTICAST = "No"; }
			L_PointToPoint_Box.setText(MULTICAST);

			String LOOPBACK;
			if (NETINT.isLoopback()) { LOOPBACK = "Yes"; }
			else { LOOPBACK = "No"; }
			L_Loopback_Box.setText (LOOPBACK);

			String ISVIRTUAL;
			if (NETINT.isVirtual()) { ISVIRTUAL = "Yes"; }
			else { ISVIRTUAL = "No"; }
			L_Virtual_Box.setText (ISVIRTUAL);

		}
		catch (SocketException X)
		{
			System.out.println (X);
		}
	}

	public void BuildGUI ()
	{
		MainWindow.setDefaultCloseOperation (
				javax.swing.WindowConstants.EXIT_ON_CLOSE);
		MainWindow.setSize (380, 380);
		MainWindow.setLayout (null);

		MainWindow.add (L_Title);
		L_Title.setBounds (112, 0, 172, 16);

		MainWindow.add (L_TotalInterfaces);
		L_TotalInterfaces.setBounds (12, 23, 181, 16);

		L_TotalInterfaces_Box.setForeground (new java.awt.Color (255, 0, 0));
		L_TotalInterfaces_Box.setHorizontalAlignment (javax.swing.SwingConstants.CENTER);
                L_TotalInterfaces_Box.setBorder (javax.swing.BorderFactory.createLineBorder (new java.awt.Color (0, 0, 0)));
		MainWindow.add (L_TotalInterfaces_Box);
		L_TotalInterfaces_Box.setBounds (224, 23, 136, 16);

		MainWindow.add (L_InterfaceNumber);
		L_InterfaceNumber.setBounds (12, 46, 69, 16);

		L_InterfaceNumber_Box.setForeground (new java.awt.Color (255, 0, 0));
		L_InterfaceNumber_Box.setHorizontalAlignment (javax.swing.SwingConstants.CENTER);
		L_InterfaceNumber_Box.setBorder (javax.swing.BorderFactory.createLineBorder (new java.awt.Color (0, 0, 0)));
		MainWindow.add (L_InterfaceNumber_Box);
		L_InterfaceNumber_Box.setBounds (112, 46, 248, 16);

		MainWindow.add (L_InterfaceName);
		L_InterfaceName.setBounds (12, 69, 93, 16);

		L_InterfaceName_Box.setForeground (new java.awt.Color (255, 0, 0));
		L_InterfaceName_Box.setHorizontalAlignment (javax.swing.SwingConstants.CENTER);
		L_InterfaceName_Box.setBorder (javax.swing.BorderFactory.createLineBorder (new java.awt.Color (0, 0, 0)));
		MainWindow.add (L_InterfaceName_Box);
		L_InterfaceName_Box.setBounds (112, 69, 248, 16);


		MainWindow.add (L_InterfaceID);
		L_InterfaceID.setBounds (12, 92, 72, 16);

		L_InterfaceID_Box.setForeground (new java.awt.Color (255, 0, 0));
		L_InterfaceID_Box.setHorizontalAlignment (javax.swing.SwingConstants.CENTER);
		L_InterfaceID_Box.setBorder (javax.swing.BorderFactory.createLineBorder (new java.awt.Color (0, 0, 0)));
		MainWindow.add (L_InterfaceID_Box);
		L_InterfaceID_Box.setBounds (112, 92, 248, 16);


		MainWindow.add (L_MAC);
		L_MAC.setBounds (12, 115, 81, 16);

		L_MAC_Box.setForeground (new java.awt.Color (255, 0, 0));
		L_MAC_Box.setHorizontalAlignment (javax.swing.SwingConstants.CENTER);
		L_MAC_Box.setBorder (javax.swing.BorderFactory.createLineBorder (new java.awt.Color (0, 0, 0)));
		MainWindow.add (L_MAC_Box);
		L_MAC_Box.setBounds (112, 115, 248, 16);


		MainWindow.add (L_IP);
		L_IP.setBounds (12, 138, 82, 16);

		L_IP_Box.setForeground (new java.awt.Color (255, 0, 0));
		L_IP_Box.setHorizontalAlignment (javax.swing.SwingConstants.CENTER);
		L_IP_Box.setBorder (javax.swing.BorderFactory.createLineBorder (new java.awt.Color (0, 0, 0)));
		MainWindow.add (L_IP_Box);
		L_IP_Box.setBounds (112, 138, 248, 16);


		MainWindow.add (L_HostName);
		L_HostName.setBounds (12, 161, 82, 16);

		L_HostName_Box.setForeground (new java.awt.Color (255, 0, 0));
		L_HostName_Box.setHorizontalAlignment (javax.swing.SwingConstants.CENTER);
		L_HostName_Box.setBorder (javax.swing.BorderFactory.createLineBorder (new java.awt.Color (0, 0, 0)));
		MainWindow.add (L_HostName_Box);
		L_HostName_Box.setBounds (112, 161, 248, 16);


		MainWindow.add (L_MTU);
		L_MTU.setBounds (12, 184, 31, 16);

		L_MTU_Box.setForeground (new java.awt.Color (255, 0, 0));
		L_MTU_Box.setHorizontalAlignment (javax.swing.SwingConstants.CENTER);
		L_MTU_Box.setBorder (javax.swing.BorderFactory.createLineBorder (new java.awt.Color (0, 0, 0)));
		MainWindow.add (L_MTU_Box);
		L_MTU_Box.setBounds (112, 184, 248, 16);


		MainWindow.add (L_Status);
		L_Status.setBounds (12, 207, 41, 16);

		L_Status_Box.setForeground (new java.awt.Color (255, 0, 0));
		L_Status_Box.setHorizontalAlignment (javax.swing.SwingConstants.CENTER);
		L_Status_Box.setBorder (javax.swing.BorderFactory.createLineBorder (new java.awt.Color (0, 0, 0)));
		MainWindow.add (L_Status_Box);
		L_Status_Box.setBounds (112, 207, 248, 16);


		MainWindow.add (L_PointToPoint);
		L_PointToPoint.setBounds (12, 230, 100, 16);

		L_PointToPoint_Box.setForeground (new java.awt.Color (255, 0, 0));
		L_PointToPoint_Box.setHorizontalAlignment (javax.swing.SwingConstants.CENTER);
		L_PointToPoint_Box.setBorder (javax.swing.BorderFactory.createLineBorder (new java.awt.Color (0, 0, 0)));
		MainWindow.add (L_PointToPoint_Box);
		L_PointToPoint_Box.setBounds (112, 230, 248, 16);


		MainWindow.add (L_MultiCast);
		L_MultiCast.setBounds (12, 253, 100, 16);

		L_MultiCast_Box.setForeground (new java.awt.Color (255, 0, 0));
		L_MultiCast_Box.setHorizontalAlignment (javax.swing.SwingConstants.CENTER);
		L_MultiCast_Box.setBorder (javax.swing.BorderFactory.createLineBorder (new java.awt.Color (0, 0, 0)));
		MainWindow.add (L_MultiCast_Box);
		L_MultiCast_Box.setBounds (112, 253, 248, 16);


		MainWindow.add (L_Loopback);
		L_Loopback.setBounds (12, 276, 100, 16);

		L_Loopback_Box.setForeground (new java.awt.Color (255, 0, 0));
		L_Loopback_Box.setHorizontalAlignment (javax.swing.SwingConstants.CENTER);
		L_Loopback_Box.setBorder (javax.swing.BorderFactory.createLineBorder (new java.awt.Color (0, 0, 0)));
		MainWindow.add (L_Loopback_Box);
		L_Loopback_Box.setBounds (112, 276, 248, 16);


		MainWindow.add (L_Virtual);
		L_Virtual.setBounds (12, 299, 100, 16);

		L_Virtual_Box.setForeground (new java.awt.Color (255, 0, 0));
		L_Virtual_Box.setHorizontalAlignment (javax.swing.SwingConstants.CENTER);
		L_Virtual_Box.setBorder (javax.swing.BorderFactory.createLineBorder (new java.awt.Color (0, 0, 0)));
		MainWindow.add (L_Virtual_Box);
		L_Virtual_Box.setBounds (112, 299, 248, 16);


		B_PREVIOUS.setBackground (new java.awt.Color (0, 0, 0));
		B_PREVIOUS.setBackground (new java.awt.Color (255, 255, 255));
		B_PREVIOUS.setText ("PREV");
		B_PREVIOUS.setToolTipText ("Previous");
		MainWindow.add (B_PREVIOUS);
		B_PREVIOUS.setBounds (112, 322, 65, 25);


		B_NEXT.setBackground (new java.awt.Color (0, 0, 0));
		B_NEXT.setBackground (new java.awt.Color (255, 255, 255));
		B_NEXT.setText ("NEXT");
		B_NEXT.setToolTipText ("Next");
		MainWindow.add (B_NEXT);
		B_NEXT.setBounds (184, 322, 65, 25);


		B_QUIT.setBackground (new java.awt.Color (0, 0, 0));
		B_QUIT.setBackground (new java.awt.Color (255, 255, 255));
		B_QUIT.setText ("QUIT");
		B_QUIT.setToolTipText ("Quit");
		MainWindow.add (B_QUIT);
		B_QUIT.setBounds (297, 322, 63, 25);


		Add_Listeners ();

		MainWindow.setVisible (true);
	}

	public void Add_Listeners ()
	{
		B_PREVIOUS.addActionListener (
			new java.awt.event.ActionListener ()
			{
				public void actionPerformed (java.awt.event.ActionEvent evt)
				{
					ACTION_B_PREVIOUS();
				}
			}
		);

		B_NEXT.addActionListener (
			new java.awt.event.ActionListener ()
			{
				public void actionPerformed (java.awt.event.ActionEvent evt)
				{
					ACTION_B_NEXT();
				}
			}
		);


		B_QUIT.addActionListener (
			new java.awt.event.ActionListener ()
			{
				public void actionPerformed (java.awt.event.ActionEvent evt)
				{
					ACTION_B_QUIT();
				}
			}
		);
	}


	public void ACTION_B_PREVIOUS ()
	{
		if (InterfaceNumber > 0)
		{
			InterfaceNumber --;
			DisplayInterfaceInfo (InterfaceNumber);
		}
	}

	public void ACTION_B_NEXT ()
	{
		if (InterfaceNumber < (InterfaceCount-1))
		{
			InterfaceNumber ++;
			DisplayInterfaceInfo (InterfaceNumber);
		}
	}

	public void ACTION_B_QUIT ()
	{
		MainWindow.setVisible (false);
		MainWindow.dispose();
	}
}