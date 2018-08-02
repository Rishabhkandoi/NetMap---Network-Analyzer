/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpcap;

import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import jpcap.*;
import java.io.*;
import jpcap.JpcapCaptor;

/**
 *
 * @author John
 */
public class mainGui extends javax.swing.JFrame {

    /**
     * Creates new form mainGui
     */
    //public static JTextArea TA_OUTPUT;
    NetworkInterface[] NETWORK_INTERFACES;
    JpcapCaptor CAP;
    NetMap_CaptureThread CAPTAIN;
    int INDEX = 0;
    int COUNTER = 0;
    
    boolean CaptureState = false;
    //static{
      //System.loadLibrary("JpcapCaptor.dll");
    //}
    
    public mainGui() {
        initComponents();
    }
public void ListNetworkInterfaces()
{
      NETWORK_INTERFACES= JpcapCaptor.getDeviceList();
      TA_OUTPUT.setText("");
   for(int i=0;i<NETWORK_INTERFACES.length;i++)
    {
      TA_OUTPUT.append("\n- - - - - - - - - - - - - Interface "+i+" Info - - - - - - - - - - - - - - - \n");
      TA_OUTPUT.append("Interface Number :  " +i);
      TA_OUTPUT.append("\nDescription :  "+ NETWORK_INTERFACES[i].name +"("+ NETWORK_INTERFACES[i].description+")");
      TA_OUTPUT.append("\nDatalink Name :  "+ NETWORK_INTERFACES[i].datalink_name +"(" + NETWORK_INTERFACES[i].datalink_description+ ")\n");
      byte[] R = NETWORK_INTERFACES[i].mac_address;
      TA_OUTPUT.append("MAC address : ");
      for(int A=0;A<=NETWORK_INTERFACES.length;A ++)
      {
      TA_OUTPUT.append(Integer.toHexString(R[A] & 0xff)+ " : ");
      }
      TA_OUTPUT.append("\n");

      NetworkInterfaceAddress [] INT = NETWORK_INTERFACES[i].addresses;

      TA_OUTPUT.append("IP address : " + INT[0].address+"\n");
      TA_OUTPUT.append("Subnet Mask : "+ INT[0].subnet+"\n");
      TA_OUTPUT.append("Broadcast Address : " + INT[0].broadcast+"\n");
      COUNTER++;
    }
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TA_OUTPUT = new javax.swing.JTextArea();
        B_CAPTURE = new javax.swing.JButton();
        B_STOP = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        TF_SelectInterface = new javax.swing.JTextField();
        B_SAVE = new javax.swing.JButton();
        B_LOAD = new javax.swing.JButton();
        B_SELECT = new javax.swing.JButton();
        B_HELP = new javax.swing.JButton();
        B_ABOUT = new javax.swing.JButton();
        B_LIST = new javax.swing.JButton();
        B_INFO = new javax.swing.JButton();
        B_EXIT = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        RB_Port_Special = new javax.swing.JRadioButton();
        TF_SpecialPort = new javax.swing.JTextField();
        B_FILTER = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        RB_Port_HTTP = new javax.swing.JRadioButton();
        RB_Port_SMTP = new javax.swing.JRadioButton();
        RB_Port_NetBIOS = new javax.swing.JRadioButton();
        RB_Port_SSL = new javax.swing.JRadioButton();
        RB_Port_POP3 = new javax.swing.JRadioButton();
        RB_Port_SAMBA = new javax.swing.JRadioButton();
        RB_Port_FTP = new javax.swing.JRadioButton();
        RB_Port_IMAP = new javax.swing.JRadioButton();
        RB_Port_AD = new javax.swing.JRadioButton();
        RB_Port_SSH = new javax.swing.JRadioButton();
        RB_Port_IMAPS = new javax.swing.JRadioButton();
        RB_Port_SQL = new javax.swing.JRadioButton();
        RB_Port_Telnet = new javax.swing.JRadioButton();
        RB_Port_DNS = new javax.swing.JRadioButton();
        RB_Port_LDAP = new javax.swing.JRadioButton();
        RB_Filter_Enable = new javax.swing.JRadioButton();
        RB_Filter_Disable = new javax.swing.JRadioButton();
        L_FilterStatusBox = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("NetMap v1.0");

        TA_OUTPUT.setColumns(20);
        TA_OUTPUT.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        TA_OUTPUT.setForeground(new java.awt.Color(0, 102, 255));
        TA_OUTPUT.setRows(5);
        jScrollPane1.setViewportView(TA_OUTPUT);

        B_CAPTURE.setBackground(new java.awt.Color(255, 0, 0));
        B_CAPTURE.setText("CAPTURE");
        B_CAPTURE.setEnabled(false);
        B_CAPTURE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_CAPTUREActionPerformed(evt);
            }
        });

        B_STOP.setText("STOP");
        B_STOP.setEnabled(false);
        B_STOP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_STOPActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel2.setText("INTERFACE");

        B_SAVE.setText("SAVE");
        B_SAVE.setEnabled(false);
        B_SAVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_SAVEActionPerformed(evt);
            }
        });

        B_LOAD.setText("LOAD");
        B_LOAD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_LOADActionPerformed(evt);
            }
        });

        B_SELECT.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        B_SELECT.setText("SELECT");
        B_SELECT.setEnabled(false);
        B_SELECT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_SELECTActionPerformed(evt);
            }
        });

        B_HELP.setText("HELP");
        B_HELP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_HELPActionPerformed(evt);
            }
        });

        B_ABOUT.setText("ABOUT");
        B_ABOUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_ABOUTActionPerformed(evt);
            }
        });

        B_LIST.setText("LIST");
        B_LIST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_LISTActionPerformed(evt);
            }
        });

        B_INFO.setText("INFO");
        B_INFO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_INFOActionPerformed(evt);
            }
        });

        B_EXIT.setText("EXIT");
        B_EXIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_EXITActionPerformed(evt);
            }
        });

        jLabel3.setText("PORT FILTER STATUS");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel4.setText("SPECIAL PORT #");

        RB_Port_Special.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        RB_Port_Special.setText("SPECIAL");

        B_FILTER.setText("FILTER");
        B_FILTER.setEnabled(false);
        B_FILTER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_FILTERActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(0, 153, 0));
        jLabel5.setText("PORT FILTER PRESETS");

        buttonGroup2.add(RB_Port_HTTP);
        RB_Port_HTTP.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        RB_Port_HTTP.setText("HTTP (80)");

        buttonGroup2.add(RB_Port_SMTP);
        RB_Port_SMTP.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        RB_Port_SMTP.setText("SMTP (25)");

        buttonGroup2.add(RB_Port_NetBIOS);
        RB_Port_NetBIOS.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        RB_Port_NetBIOS.setText("NetBIOS (139)");

        buttonGroup2.add(RB_Port_SSL);
        RB_Port_SSL.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        RB_Port_SSL.setText("HTTP_SSL (443)");
        RB_Port_SSL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB_Port_SSLActionPerformed(evt);
            }
        });

        buttonGroup2.add(RB_Port_POP3);
        RB_Port_POP3.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        RB_Port_POP3.setText("POP 3 (110)");

        buttonGroup2.add(RB_Port_SAMBA);
        RB_Port_SAMBA.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        RB_Port_SAMBA.setText("Samba (137)");

        buttonGroup2.add(RB_Port_FTP);
        RB_Port_FTP.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        RB_Port_FTP.setText("FTP (20+21)");

        buttonGroup2.add(RB_Port_IMAP);
        RB_Port_IMAP.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        RB_Port_IMAP.setText("IMAP (143)");

        buttonGroup2.add(RB_Port_AD);
        RB_Port_AD.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        RB_Port_AD.setText("AD (445)");

        buttonGroup2.add(RB_Port_SSH);
        RB_Port_SSH.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        RB_Port_SSH.setText("SSH (22)");

        buttonGroup2.add(RB_Port_IMAPS);
        RB_Port_IMAPS.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        RB_Port_IMAPS.setText("IMAPS (993)");

        buttonGroup2.add(RB_Port_SQL);
        RB_Port_SQL.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        RB_Port_SQL.setText("SQL (118)");

        buttonGroup2.add(RB_Port_Telnet);
        RB_Port_Telnet.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        RB_Port_Telnet.setText("Telnet (23)");

        buttonGroup2.add(RB_Port_DNS);
        RB_Port_DNS.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        RB_Port_DNS.setText("DNS (53)");

        buttonGroup2.add(RB_Port_LDAP);
        RB_Port_LDAP.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        RB_Port_LDAP.setText("LDAP (389)");

        buttonGroup1.add(RB_Filter_Enable);
        RB_Filter_Enable.setText("Enable");
        RB_Filter_Enable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB_Filter_EnableActionPerformed(evt);
            }
        });

        buttonGroup1.add(RB_Filter_Disable);
        RB_Filter_Disable.setText("Disable");
        RB_Filter_Disable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB_Filter_DisableActionPerformed(evt);
            }
        });

        L_FilterStatusBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_FilterStatusBox.setForeground(new java.awt.Color(255, 0, 0));
        L_FilterStatusBox.setText("DISABLED (All Ports)");
        L_FilterStatusBox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(326, 326, 326)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(B_LIST, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(B_INFO, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(B_EXIT, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TF_SpecialPort, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(B_FILTER))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TF_SelectInterface, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addComponent(B_SAVE, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B_LOAD, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(B_CAPTURE, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B_STOP, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel3)
                                .addGap(9, 9, 9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(L_FilterStatusBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(RB_Filter_Enable)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(RB_Port_Special)
                                            .addComponent(RB_Filter_Disable)))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(B_SELECT, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(B_HELP, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(B_ABOUT, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(RB_Port_HTTP)
                                    .addComponent(RB_Port_SSL))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(RB_Port_SMTP)
                                        .addGap(18, 18, 18)
                                        .addComponent(RB_Port_NetBIOS))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(RB_Port_POP3)
                                        .addGap(12, 12, 12)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(RB_Port_AD)
                                            .addComponent(RB_Port_SQL)
                                            .addComponent(RB_Port_SAMBA)
                                            .addComponent(RB_Port_LDAP)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(RB_Port_FTP)
                                    .addComponent(RB_Port_SSH)
                                    .addComponent(RB_Port_Telnet))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(RB_Port_DNS)
                                    .addComponent(RB_Port_IMAP)
                                    .addComponent(RB_Port_IMAPS)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel5)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(L_FilterStatusBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(B_CAPTURE)
                                    .addComponent(B_STOP))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TF_SelectInterface, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B_SAVE)
                            .addComponent(B_LOAD)
                            .addComponent(RB_Filter_Enable)
                            .addComponent(RB_Filter_Disable))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(B_SELECT)
                            .addComponent(B_HELP)
                            .addComponent(B_ABOUT)
                            .addComponent(jLabel4)
                            .addComponent(RB_Port_Special))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(B_LIST)
                            .addComponent(B_INFO)
                            .addComponent(B_EXIT)
                            .addComponent(TF_SpecialPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B_FILTER)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RB_Port_HTTP)
                            .addComponent(RB_Port_SMTP)
                            .addComponent(RB_Port_NetBIOS))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RB_Port_SSL)
                            .addComponent(RB_Port_POP3)
                            .addComponent(RB_Port_SAMBA))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RB_Port_FTP)
                            .addComponent(RB_Port_IMAP)
                            .addComponent(RB_Port_AD))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RB_Port_SSH)
                            .addComponent(RB_Port_IMAPS)
                            .addComponent(RB_Port_SQL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RB_Port_Telnet)
                            .addComponent(RB_Port_DNS)
                            .addComponent(RB_Port_LDAP))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RB_Port_SSLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB_Port_SSLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RB_Port_SSLActionPerformed

    private void B_LISTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_LISTActionPerformed
        // TODO add your handling code here:
        ListNetworkInterfaces();
        B_SELECT.setEnabled(true);
        TF_SelectInterface.requestFocus();
    }//GEN-LAST:event_B_LISTActionPerformed

    private void B_SELECTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_SELECTActionPerformed
        // TODO add your handling code here:
        ChooseInterface();
    }//GEN-LAST:event_B_SELECTActionPerformed

    private void B_CAPTUREActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_CAPTUREActionPerformed
        // TODO add your handling code here:
        TA_OUTPUT.setText("");
        TF_SelectInterface.setText("");
        CaptureState = true;
        CapturePackets();
    }//GEN-LAST:event_B_CAPTUREActionPerformed

    private void B_STOPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_STOPActionPerformed
        // TODO add your handling code here:
        CaptureState = false;
        CAPTAIN.finished();
    }//GEN-LAST:event_B_STOPActionPerformed

    private void B_SAVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_SAVEActionPerformed
        // TODO add your handling code here:
        SaveCaptureData();
    }//GEN-LAST:event_B_SAVEActionPerformed

    private void B_LOADActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_LOADActionPerformed
        // TODO add your handling code here:
        LoadCaptureData();
    }//GEN-LAST:event_B_LOADActionPerformed

    private void B_HELPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_HELPActionPerformed
        // TODO add your handling code here:
        String MESSAGE = "NetMap is a Java packet capturing application.\n"+
                "\n CAPTURE = Start Capturing packets on selected Interface\n"+
               "\n STOP = Stop Capturing packets.\n"+
                "\nLIST = List Network interfaces on HOST.\n"+
                "\nSELECT = Selects interface to capture packets with .\n"+
                "\nFILTER = Filter on a selected port when filtering is Enabled.\n"+
                "\nEnable = Enables port filtering (only captures traffic on that port).\n"+
                "\nDisable = Disables port filtering (Captures traffic on All Ports).\n"+
                "\nINFO = Detailed information for each network interface on host.\n"+
                "\nHELP = Displays this help screen.\n"+
                "\nABOUT = Displays application about information.\n"+
                "\n\n NetMap v1.0";
        JOptionPane.showMessageDialog(null, MESSAGE);

    }//GEN-LAST:event_B_HELPActionPerformed

    private void B_ABOUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_ABOUTActionPerformed
        // TODO add your handling code here:
        String MESSAGE = "NetMap v1.0";
        JOptionPane.showMessageDialog(null, MESSAGE);
    }//GEN-LAST:event_B_ABOUTActionPerformed

    private void B_INFOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_INFOActionPerformed
        // TODO add your handling code here:
        NetMap_NetworkInfo INFO = new NetMap_NetworkInfo();
    }//GEN-LAST:event_B_INFOActionPerformed

    private void B_EXITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_EXITActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_B_EXITActionPerformed

    private void B_FILTERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_FILTERActionPerformed
        // TODO add your handling code here:
        try
        {
            if(RB_Filter_Enable.isSelected())
            {
                if(RB_Port_Special.isSelected())
                    {
                       String PORT = TF_SpecialPort.getText();
                       CAP.setFilter("port " + PORT, true);
                    }
                
                else if(RB_Port_HTTP.isSelected())
                      { 
                      CAP.setFilter("port 80", true);

                      }
                else if(RB_Port_SSL.isSelected())
                      { 
                      CAP.setFilter("port 443", true);

                      }
                else if(RB_Port_FTP.isSelected())
                      { 
                      CAP.setFilter("port 21", true);
                      }
                else if(RB_Port_SSH.isSelected())
                      { 
                      CAP.setFilter("port 22", true);

                      }
                else if(RB_Port_Telnet.isSelected())
                      { 
                      CAP.setFilter("port 23", true);

                      }
                else if(RB_Port_SMTP.isSelected())
                      { 
                      CAP.setFilter("port 25", true);

                      }
                else if(RB_Port_POP3.isSelected())
                      { 
                      CAP.setFilter("port 110", true);

                      }
                else if(RB_Port_IMAP.isSelected())
                      { 
                      CAP.setFilter("port 143", true);

                      }
                else if(RB_Port_IMAPS.isSelected())
                      { 
                      CAP.setFilter("port 993", true);

                      }
                else if(RB_Port_DNS.isSelected())
                      { 
                      CAP.setFilter("port 53", true);

                      }
                else if(RB_Port_NetBIOS.isSelected())
                      { 
                      CAP.setFilter("port 139", true);

                      }
                else if(RB_Port_SAMBA.isSelected())
                      { 
                      CAP.setFilter("port 137", true);

                      }
                else if(RB_Port_AD.isSelected())
                      { 
                      CAP.setFilter("port 445", true);

                      }
                else if(RB_Port_SQL.isSelected())
                      { 
                      CAP.setFilter("port 118", true);

                      }
                else if(RB_Port_LDAP.isSelected())
                      { 
                      CAP.setFilter("port 389", true);

                      }
            }
            else
            {
             JOptionPane.showMessageDialog(null,"Filtering is disabled");
            }
        }
    catch(Exception X)
        {System.out.print(X);}

    }//GEN-LAST:event_B_FILTERActionPerformed

    private void RB_Filter_EnableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB_Filter_EnableActionPerformed
        // TODO add your handling code here:
            L_FilterStatusBox.setText("Enabled (selected port)");

    }//GEN-LAST:event_RB_Filter_EnableActionPerformed

    private void RB_Filter_DisableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB_Filter_DisableActionPerformed
        // TODO add your handling code here:
            L_FilterStatusBox.setText("Disabled (ALL PORTS)");

    }//GEN-LAST:event_RB_Filter_DisableActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        //System.out.println(System.getProperty("java.library.path"));
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainGui().setVisible(true);
            }
        });
        
    }
    
     public void ACTION_B_CAPTURE(ActionEvent X)
    {
        TA_OUTPUT.setText("");
        CaptureState = true;
        CapturePackets();
        
    }
    
  //------------------------------------------------------
     public void ACTION_B_STOP(ActionEvent X)
    {
        
        CaptureState= false;
        CAPTAIN.finished();
        
    }
      //------------------------------------------------------
     public void ACTION_B_SELECT(ActionEvent X)
    {
        
        ChooseInterface();
        
    }
    //------------------------------------------------------
     public void ACTION_B_LIST(ActionEvent X)
    {
        
       ListNetworkInterfaces();
       B_SELECT.setEnabled(true);
       TF_SelectInterface.requestFocus();
        
    }
     
      public void ACTION_B_FILTER(ActionEvent X)
    {
        try
        {
            if(RB_Filter_Enable.isSelected())
            {
                if(RB_Port_Special.isSelected())
                {
                    String PORT = TF_SpecialPort.getText();
                    CAP.setFilter("port" + PORT, true);
                }
                else if(RB_Port_HTTP.isSelected())
                {
           
                    CAP.setFilter("port so",true);
                    
                }
                else if(RB_Port_HTTP.isSelected())
                { 
                    CAP.setFilter("port 80", true);
      
                }
                else if(RB_Port_HTTP.isSelected())
                      { 
                      CAP.setFilter("port 443", true);

                      }
                else if(RB_Port_HTTP.isSelected())
                      { 
                      CAP.setFilter("port 21", true);
                      }
                else if(RB_Port_HTTP.isSelected())
                      { 
                      CAP.setFilter("port 22", true);

                      }
                else if(RB_Port_HTTP.isSelected())
                      { 
                      CAP.setFilter("port 23", true);

                      }
                else if(RB_Port_HTTP.isSelected())
                      { 
                      CAP.setFilter("port 25", true);

                      }
                else if(RB_Port_HTTP.isSelected())
                      { 
                      CAP.setFilter("port 110", true);

                      }
                else if(RB_Port_HTTP.isSelected())
                      { 
                      CAP.setFilter("port 143", true);

                      }
                else if(RB_Port_HTTP.isSelected())
                      { 
                      CAP.setFilter("port 993", true);

                      }
                else if(RB_Port_HTTP.isSelected())
                      { 
                      CAP.setFilter("port 53", true);

                      }
                else if(RB_Port_HTTP.isSelected())
                      { 
                      CAP.setFilter("port 139", true);

                      }
                else if(RB_Port_HTTP.isSelected())
                      { 
                      CAP.setFilter("port 137", true);

                      }
                else if(RB_Port_HTTP.isSelected())
                      { 
                      CAP.setFilter("port 445", true);

                      }
                else if(RB_Port_HTTP.isSelected())
                      { 
                      CAP.setFilter("port 118", true);

                      }
                else if(RB_Port_HTTP.isSelected())
                      { 
                      CAP.setFilter("port 389", true);

                      }
}
else
{

      JOptionPane.showMessageDialog(null,"Filtering is disabled");
}
}
catch(Exception Y)
{System.out.print(Y);}
}
      
      public void Action_B_INFO(ActionEvent X)
{
            NetMap_NetworkInfo INFO = new NetMap_NetworkInfo();

}
public void Action_B_SAVE(ActionEvent X)
{
            SaveCaptureData();
}
public void Action_B_Load(ActionEvent X)
{
            LoadCaptureData();
}
public void Action_B_ABOUT(ActionEvent X)
{
String MESSAGE= "NetMap";
JOptionPane.showMessageDialog(null,MESSAGE);

}
public void Action_B_HELP(ActionEvent X)
{
String MESSAGE="something";
JOptionPane.showMessageDialog (null,MESSAGE);
}
//------------------------
public void Action_B_EXIT(ActionEvent X)
{
       // MainWindow.setVisible(false);
        //MainWindow.dispose();
}
//-------------------------
public void Action_B_ENABLE(ActionEvent X)
{
    L_FilterStatusBox.setText("Enabled (selected port)");
}
//--------------------------
public void Action_B_DISABLE(ActionEvent X)
{
    L_FilterStatusBox.setText("Disabled (All ports)");

}

 public void CapturePackets()
{
    CAPTAIN =new NetMap_CaptureThread()
      {
      //----------------
    public Object construct()
    {
      TA_OUTPUT.setText("\nNow Capturing on Interface" + INDEX + "...."+"\n - - - - - - - - - - - - - - - - - - -" +
              " - - - - - - - - - - \n\n");
    try
      {
      CAP = JpcapCaptor.openDevice(
      NETWORK_INTERFACES[INDEX],65535,false,20);
            while(CaptureState)
            {
            CAP.processPacket(1, new NetMap_PacketContents());
            }
                  CAP.close();
      }
      catch(Exception X)
      {
      System.out.print(X);
      }

      return 0;
    }
      public void finished()
      {
            this.interrupt();
      }
};

 CAPTAIN.start();
}
public void DisableButtons()
{
      B_CAPTURE.setEnabled(false);
      B_STOP.setEnabled(false);
      B_SELECT.setEnabled(false);
      B_FILTER.setEnabled(false);
      B_SAVE.setEnabled(false);

}


public void EnableButtons()
{
      B_CAPTURE.setEnabled(true);
      B_STOP.setEnabled(true);
      B_SELECT.setEnabled(true);
      B_FILTER.setEnabled(true);
      B_SAVE.setEnabled(true);
      B_LOAD.setEnabled(true);

}





public void ChooseInterface(){
    int Temp = Integer.parseInt(TF_SelectInterface.getText());
    if(Temp>-1&& Temp< COUNTER)
    {
    INDEX =Temp;
    EnableButtons();
    }
    else
    {

        JOptionPane.showMessageDialog (null, "out of range"+ (COUNTER-1) + ".");
    }

    //TF_SelectInterface.setText("");
}


public static void SaveCaptureData()
{
    String CaptureData= TA_OUTPUT.getText();
    try
    {
    File DATA = new File("CaptureData.txt");
    FileOutputStream DATASTREAM = new FileOutputStream(DATA);
    PrintStream OUT = new PrintStream(DATASTREAM);
    OUT.print(CaptureData);
    OUT.close();
    DATASTREAM.close();
    JOptionPane.showMessageDialog(null, "Data SAVED sccesfully");
    }
          catch(Exception X)
          {
          JOptionPane.showMessageDialog(null,"File Access error: could not save");
    }
}
        
        
 public static void LoadCaptureData()
{

String CaptureData ="";
try
{
      File DATA = new File("CaptureData.txt");
      FileInputStream DATASTREAM = new FileInputStream(DATA);
      InputStreamReader INPUT = new InputStreamReader(DATASTREAM);
      BufferedReader IN = new BufferedReader(INPUT);
      while(IN.read() != -1)
                  {
                  CaptureData = CaptureData +"\n"+IN.readLine();
                  }
            IN.close();
            INPUT.close();
            DATASTREAM.close();
            TA_OUTPUT.setText(CaptureData);
            JOptionPane.showMessageDialog(null,"Data loaded succesfully");
}
catch(IOException X)
      {
            JOptionPane.showMessageDialog(null,"File Access Error! could not Load Data");
      }

}  
 
 
 
    
     
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_ABOUT;
    private javax.swing.JButton B_CAPTURE;
    private javax.swing.JButton B_EXIT;
    private javax.swing.JButton B_FILTER;
    private javax.swing.JButton B_HELP;
    private javax.swing.JButton B_INFO;
    private javax.swing.JButton B_LIST;
    private javax.swing.JButton B_LOAD;
    private javax.swing.JButton B_SAVE;
    private javax.swing.JButton B_SELECT;
    private javax.swing.JButton B_STOP;
    private javax.swing.JLabel L_FilterStatusBox;
    private javax.swing.JRadioButton RB_Filter_Disable;
    private javax.swing.JRadioButton RB_Filter_Enable;
    private javax.swing.JRadioButton RB_Port_AD;
    private javax.swing.JRadioButton RB_Port_DNS;
    private javax.swing.JRadioButton RB_Port_FTP;
    private javax.swing.JRadioButton RB_Port_HTTP;
    private javax.swing.JRadioButton RB_Port_IMAP;
    private javax.swing.JRadioButton RB_Port_IMAPS;
    private javax.swing.JRadioButton RB_Port_LDAP;
    private javax.swing.JRadioButton RB_Port_NetBIOS;
    private javax.swing.JRadioButton RB_Port_POP3;
    private javax.swing.JRadioButton RB_Port_SAMBA;
    private javax.swing.JRadioButton RB_Port_SMTP;
    private javax.swing.JRadioButton RB_Port_SQL;
    private javax.swing.JRadioButton RB_Port_SSH;
    private javax.swing.JRadioButton RB_Port_SSL;
    private javax.swing.JRadioButton RB_Port_Special;
    private javax.swing.JRadioButton RB_Port_Telnet;
    public static javax.swing.JTextArea TA_OUTPUT;
    private javax.swing.JTextField TF_SelectInterface;
    private javax.swing.JTextField TF_SpecialPort;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
