/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdtssp.hospitalUI;

import com.sdtssp.DBConnect;
import com.sdtssp.SortedComboBoxModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.sdtssp.Validators;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author nilesh
 */
public class Menu extends javax.swing.JFrame{
    Validators v;
    Statement stmt = null;
    Connection con = null;
    ResultSet rs  = null;
    String [] spec = { "None", "SUKHAYU ANTICANCER THERAPY (SAT)", "PANCHAVED UNIQUE TREATMENT FOR VARICOSE VEINS" };
    String [] panch = { "None", "Relaxation Course (3-21 days)", "Sinus Care Course (7-14days)", "Spine Care Course (7-14 days)", "Joint Care Course (5-21 days)", "Slimming Course (14-45 days)", "Panchved Wellness Course (3-5 days)" };
    String [] pt = { "None", "SNEHAN", "ABHYANG", "SWEDAN", "VAMAN", "VIRECHAN", "NASYAM", "RAKTAMOKSHAN" }; 
    String [] kt = { "None", "PIZHICHIL", "NAVARKIZHI", "SHIRODHARA", "UDWARTANAM", "KATIBASTI", "HRUDAYBASTI", "GREEVABASTI", "THALAM", "LEPANAM", "PATRA POTTALI" };
    String [] prepm = { "None", "Churna", "Bharad", "Bhasma", "Guti/Vati", "Rasakalpa", "Capsules", "Aasav", "Arishta", "Oil", "Ghrut", "Lep", "Mixtures" };
    String [] prop = {"None", "Churna", "Bhasma","Sukshma Aushadhi","Syrup","Lotion","Cream","Ointment","Lintment","Oil","Eye-Drops","Ear-Drops","Lep", "Capsules", "Aasav", "Arishta","Tablets","Others"};
    /*
    **
     * Creates new form Menu
     */
    public Menu() { 
        v = new Validators();
        con = DBConnect.Connect();
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.getHSBColor(1, 1, 0.38f));
        initComponents();
        generateID();
    }
    
    public void generateID(){
        
        try {
            String patid = Integer.toString(new Random().nextInt(51)+1);
            String docid = Integer.toString(new Random().nextInt(5)+1);
            Statement stmt1 = con.createStatement();
            Statement stmt2 = con.createStatement();
            P_id.setText(patid);
            //System.out.println(patid);
            txtId.setText(docid);
            String sqlpat = "select PatientID from patientreg;";
            String sqldoc = "select DoctorID from doctor;";
            ResultSet pat , doc;
            
            pat = stmt1.executeQuery(sqlpat);
            doc = stmt2.executeQuery(sqldoc);
//            System.out.println(pat.getInt("PatientID"));
            while(pat.next()){
                
                if(pat.getInt(1) == Integer.parseInt(patid))
                { 
                    generateID();
                    break;
                }
            }
            while(doc.next()){
                if(doc.getInt(1) == Integer.parseInt(docid))
                {
                    generateID();
                    break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }       
        
    }
    
    public void resetF() {
        txtName.setText("");
        txtFname.setText("");
        txtId.setText("");
        txtC.setText("");
        txtE.setText("");
        txtQ.setText("");
        AddArea.setText("");
        Date date = new Date();         
        jDateChooser1.setDate(date);
        P_id.setText("");
        Name.setText("");
        F_Name.setText("");
        Age.setText("");
        Email.setText("");
        Contact.setText("");
        Remarks.setText("Remarks if any");
        Add2.setText(""); 
        generateID();
    }

    public boolean manFields(String s)
    {
        int flag = 1;
        if(s.equals("Doc")){
          if (txtId.getText().equals("") || txtName.getText().equals("") || txtC.getText().equals("") || AddArea.getText().equals("") || BldGrp1.getSelectedItem() == null || jDateChooser1.getDate() == null) 
                flag = 0;
        }
        else
            if (Name.getText().equals("") || P_id.getText().equals("") || Contact.getText().equals("") || Add2.getText().equals("") || BldGrp.getSelectedItem() == null) 
              flag = 0;
        
        if(flag == 0)
            {
                JOptionPane.showMessageDialog(rootPane,"(*)Fields cannot be Empty","Error", 1);
                return false;
            }
        return true;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Add2 = new javax.swing.JTextArea();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        State2 = new javax.swing.JComboBox<>();
        City2 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Remarks = new javax.swing.JTextArea();
        Name = new javax.swing.JTextField();
        F_Name = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();
        Contact = new javax.swing.JTextField();
        Age = new javax.swing.JTextField();
        Male = new javax.swing.JRadioButton();
        Female = new javax.swing.JRadioButton();
        AddBtn = new javax.swing.JButton();
        BldGrp = new javax.swing.JComboBox<>();
        ResetBtn = new javax.swing.JButton();
        ViewBtn = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        AlttDoc = new javax.swing.JComboBox<>();
        ErrLabel = new javax.swing.JLabel();
        P_id = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtFname = new javax.swing.JTextField();
        txtE = new javax.swing.JTextField();
        txtC = new javax.swing.JTextField();
        txtQ = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        AddArea = new javax.swing.JTextArea();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        FemaleD = new javax.swing.JRadioButton();
        Add_Doc = new javax.swing.JButton();
        MaleD = new javax.swing.JRadioButton();
        BldGrp1 = new javax.swing.JComboBox<>();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel52 = new javax.swing.JLabel();
        ErrLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        ResetBtnD = new javax.swing.JButton();
        txtId = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>(new SortedComboBoxModel(this.panch));
        jComboBox2 = new javax.swing.JComboBox<>(new SortedComboBoxModel(this.spec));
        jLabel7 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>(new SortedComboBoxModel(this.pt));
        jLabel8 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>(new SortedComboBoxModel(this.kt));
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>(new SortedComboBoxModel(this.prepm));
        jLabel3 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>(new SortedComboBoxModel(this.prop));
        GenBillBtn = new javax.swing.JButton();
        LogoutBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Menu");
        setBackground(Color.RED);

        jTabbedPane4.setFont(new java.awt.Font("Chilanka", 2, 24)); // NOI18N

        jPanel8.setMaximumSize(new java.awt.Dimension(32767, 32000));
        jPanel8.setPreferredSize(new java.awt.Dimension(851, 620));

        jLabel27.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel27.setText("Patient  Registration");

        jLabel28.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel28.setText("<html>Patient ID<font color=\"red\">*</font>");

        jLabel29.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel29.setText("<html>Patient Name<font color=red>*</font></html>");

        jLabel30.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel30.setText("Father's Name");

        jLabel31.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel31.setText("Email");

        jLabel32.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel32.setText("<html>Contact No<font color=\"red\">*</font>");

        jLabel33.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel33.setText("Age");

        jLabel34.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel34.setText("Gender");

        jLabel35.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel35.setText("<html>Blood Group<font color=\"red\">*</font>");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Address", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("TlwgTypewriter", 1, 18))); // NOI18N

        jLabel36.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel36.setText("<html>Address<font color=\"red\">*</font>");

        Add2.setColumns(20);
        Add2.setLineWrap(true);
        Add2.setRows(5);
        Add2.setToolTipText("Address");
        Add2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Add2KeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(Add2);

        jLabel37.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel37.setText("State");

        jLabel38.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel38.setText("City");

        State2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Maharashtra" }));
        State2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                State2FocusGained(evt);
            }
        });

        City2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pune", "Karad", "Satara", "Sangli", "Kolhapur", "Islampur", "Mumbai" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37)
                            .addComponent(jLabel38))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(State2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(City2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(State2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(City2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setText("Remarks");

        Remarks.setColumns(20);
        Remarks.setLineWrap(true);
        Remarks.setRows(5);
        Remarks.setText("Remarks if any");
        Remarks.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                RemarksFocusGained(evt);
            }
        });
        jScrollPane2.setViewportView(Remarks);

        Email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                EmailFocusLost(evt);
            }
        });

        Contact.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ContactFocusLost(evt);
            }
        });

        buttonGroup2.add(Male);
        Male.setText("Male");

        buttonGroup2.add(Female);
        Female.setSelected(true);
        Female.setText("Female");
        Female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FemaleActionPerformed(evt);
            }
        });

        AddBtn.setFont(new java.awt.Font("Chilanka", 1, 18)); // NOI18N
        AddBtn.setText("Add");
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });

        BldGrp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-" }));

        ResetBtn.setFont(new java.awt.Font("Chilanka", 1, 18)); // NOI18N
        ResetBtn.setText("Reset");
        ResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtnActionPerformed(evt);
            }
        });

        ViewBtn.setFont(new java.awt.Font("Chilanka", 1, 18)); // NOI18N
        ViewBtn.setText("VIew");
        ViewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewBtnActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setText("Doctor");

        AlttDoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dr. Mihir", "Dr. Nachiket", "Dr. Neha" }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(297, 297, 297)
                .addComponent(jLabel27))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 829, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(P_id, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addComponent(jLabel33)
                .addGap(82, 82, 82)
                .addComponent(Age, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addComponent(jLabel34)
                .addGap(86, 86, 86)
                .addComponent(Male))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel30)
                .addGap(44, 44, 44)
                .addComponent(F_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(238, 238, 238)
                .addComponent(Female))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel31)
                .addGap(117, 117, 117)
                .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(BldGrp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(Contact, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addComponent(jLabel14)
                .addGap(50, 50, 50)
                .addComponent(AlttDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(AddBtn)))
                        .addGap(83, 83, 83)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(ViewBtn))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(ResetBtn))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ErrLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(409, 409, 409))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel27)
                .addGap(6, 6, 6)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(P_id, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel33))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(Age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel34))
                    .addComponent(Male))
                .addGap(6, 6, 6)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel30))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(F_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Female))
                .addGap(34, 34, 34)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel31))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BldGrp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(Contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel14))
                    .addComponent(AlttDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(ViewBtn))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel13))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(ErrLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(AddBtn))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(ResetBtn))))))
        );

        jTabbedPane4.addTab("PATIENT", jPanel8);

        jLabel39.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel39.setText("<html>Doctor ID<font color=\"red\">*</font>");

        jLabel40.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel40.setText("<html>Full Name<font color=\"red\">*</font>");

        jLabel41.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel41.setText("Father's / Husband's Name");

        jLabel42.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel42.setText("<html>Email-id<font color=\"red\">*</font>");

        jLabel43.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel43.setText("<html>Contact no<font color=\"red\">*</font>");

        jLabel44.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel44.setText("<html>Address<font color=\"red\">*</font>");

        jLabel45.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel45.setText("Qualifications");

        jLabel46.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel46.setText("Gender");

        jLabel47.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel47.setText("Blood Group");

        jLabel51.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel51.setText("<html><font>Date Of Joining<font color=\"red\">*</font></html>");

        txtE.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEFocusLost(evt);
            }
        });

        txtC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCFocusLost(evt);
            }
        });
        txtC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCActionPerformed(evt);
            }
        });

        AddArea.setColumns(20);
        AddArea.setRows(5);
        AddArea.setToolTipText("Address");
        jScrollPane5.setViewportView(AddArea);

        jDateChooser1.setToolTipText("");

        buttonGroup1.add(FemaleD);
        FemaleD.setText("Female");

        Add_Doc.setFont(new java.awt.Font("Chilanka", 1, 18)); // NOI18N
        Add_Doc.setText("Add Doctor");
        Add_Doc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_DocActionPerformed(evt);
            }
        });

        buttonGroup1.add(MaleD);
        MaleD.setSelected(true);
        MaleD.setText("Male");

        BldGrp1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-" }));

        jLabel52.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("Doctor Registration");

        jButton1.setFont(new java.awt.Font("Chilanka", 1, 18)); // NOI18N
        jButton1.setText("View");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ResetBtnD.setFont(new java.awt.Font("Chilanka", 1, 18)); // NOI18N
        ResetBtnD.setText("Reset");
        ResetBtnD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtnDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel45)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtQ, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Add_Doc, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtFname, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtE, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(28, 28, 28))
                                        .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(117, 117, 117)
                                    .addComponent(txtC, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(45, 45, 45)
                        .addComponent(jButton1))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(ErrLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jSeparator4)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(83, 83, 83)
                                        .addComponent(ResetBtnD))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(228, 228, 228)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel46)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel47)
                                        .addGap(68, 68, 68)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(BldGrp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(FemaleD)
                                            .addComponent(MaleD)))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(33, 33, 33))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel52)
                .addGap(302, 302, 302))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel52)
                .addGap(39, 39, 39)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(FemaleD)
                        .addGap(18, 18, 18)
                        .addComponent(MaleD))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel46)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(BldGrp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(txtFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(36, 36, 36)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel45)
                        .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ErrLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add_Doc)
                    .addComponent(jButton1)
                    .addComponent(ResetBtnD))
                .addGap(65, 65, 65))
        );

        jTabbedPane4.addTab("DOCTOR", jPanel6);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Treatments", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("TlwgTypewriter", 1, 18))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Panchakarma");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Special");

        jComboBox1.setMaximumRowCount(4);
        jComboBox1.setSelectedItem("None");

        jComboBox2.setMaximumRowCount(4);
        jComboBox2.setToolTipText("");
        jComboBox2.setSelectedItem("None");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Panchakarma Therapies");

        jComboBox3.setMaximumRowCount(4);
        jComboBox3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBox3.setSelectedItem("None");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Kerela Treatments");

        jComboBox4.setMaximumRowCount(4);
        jComboBox4.setSelectedItem("None");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox3, 0, 147, Short.MAX_VALUE)
                            .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68))
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Selected Treatments");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextArea1FocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        jButton2.setFont(new java.awt.Font("Chilanka", 1, 18)); // NOI18N
        jButton2.setText("Confirm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(89, 89, 89))))
        );

        jTabbedPane4.addTab("PANCHAKARMA", jPanel1);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Medicines", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("TlwgTypewriter", 1, 18))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Prepared Meds");

        jComboBox5.setMaximumRowCount(4);
        jComboBox5.setSelectedItem("None");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Imported");

        jComboBox6.setMaximumRowCount(4);
        jComboBox6.setSelectedItem("None");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(262, Short.MAX_VALUE))
        );

        GenBillBtn.setFont(new java.awt.Font("Chilanka", 1, 18)); // NOI18N
        GenBillBtn.setText("Generate Bill");
        GenBillBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenBillBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(283, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(GenBillBtn)
                .addGap(57, 57, 57))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(GenBillBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(178, Short.MAX_VALUE))
        );

        jPanel5.getAccessibleContext().setAccessibleName("");

        jTabbedPane4.addTab("MEDICINES", jPanel4);
        jTabbedPane4.setEnabledAt(3, false);

        LogoutBtn.setFont(new java.awt.Font("Chilanka", 1, 18)); // NOI18N
        LogoutBtn.setText("Logout");
        LogoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 853, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LogoutBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LogoutBtn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTabbedPane4))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ViewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewBtnActionPerformed
        // TODO add your handling code here:
        new View("Patient").setVisible(true);
    }//GEN-LAST:event_ViewBtnActionPerformed

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        // TODO add your handling code here:
        ImageIcon icon = new ImageIcon("src/images/icons8-task-completed-48.png");
        String gender;
        if(!manFields("Patient"))
            return;
        if(Male.isSelected())
        gender = "M";
        else
        gender = "F";
        try {
            stmt = con.createStatement();
            String sql = "insert into patientreg values("+P_id.getText()+",'"+Name.getText()+"','"+F_Name.getText()+"','"+Email.getText()+"','"+Contact.getText()+"',"+Age.getText()+",'"+Remarks.getText()+"','"+gender+"','"+BldGrp.getSelectedItem()+"','"+AlttDoc.getSelectedItem()+"','"+Add2.getText()+"','"+State2.getSelectedItem()+"','"+City2.getSelectedItem()+"');";
            System.out.println(sql);
            if(stmt.executeUpdate(sql)==1)
            {
                JOptionPane.showMessageDialog(rootPane, "User added Successfully!", "User",JOptionPane.INFORMATION_MESSAGE, icon);
                resetF();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_AddBtnActionPerformed

    private void FemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FemaleActionPerformed

    private void ContactFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ContactFocusLost
        // TODO add your handling code here:
        if (!v.valPhn(Contact.getText())) {
            ErrLabel.setText(v.contactErr);
            return;
        }
        else
        ErrLabel.setText("");
    }//GEN-LAST:event_ContactFocusLost

    private void EmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmailFocusLost
        // TODO add your handling code here:
        if (!v.valEmail(Email.getText())) {
            ErrLabel.setText(v.emailErr);
            return;
        }
        else
        ErrLabel.setText("");
    }//GEN-LAST:event_EmailFocusLost

    private void Add_DocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_DocActionPerformed
        // TODO add your handling code here:
        ImageIcon icon = new ImageIcon("src/images/icons8-task-completed-48.png");
        if(!manFields("Doc"))
            return;
        Date d = jDateChooser1.getDate();
        String strDate =  new SimpleDateFormat("yyyy-MM-dd").format(d);
        System.out.println(strDate);
        String gender;
        if(MaleD.isSelected())
        gender = "M";
        else
        gender = "F";
        
        try {
            //con = DBConnect.Connect();
            stmt = con.createStatement();
            String sql = "insert into doctor values("+txtId.getText()+",'"+txtName.getText()+"','"+txtFname.getText()+"','"+txtE.getText()+"',"+txtC.getText()+",'"+txtQ.getText()+"','"+gender+"','"+BldGrp1.getSelectedItem()+"','"+strDate+"','"+AddArea.getText()+"');";
            System.out.println(sql);
            if(stmt.executeUpdate(sql)==1)
            {
                JOptionPane.showMessageDialog(rootPane, "User added Successfully!", "User",JOptionPane.INFORMATION_MESSAGE, icon);
                resetF();
            }
        } catch (Exception e) {
            System.err.println(e);
        }

    }//GEN-LAST:event_Add_DocActionPerformed

    private void txtCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCActionPerformed

    private void txtEFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEFocusLost
        // TODO add your handling code here:
        if (!v.valEmail(txtE.getText())) {
            ErrLabel1.setText(v.emailErr);
            return;
        }
        else
            ErrLabel1.setText("");
    }//GEN-LAST:event_txtEFocusLost

    private void txtCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCFocusLost
        // TODO add your handling code here:
        if(!v.valPhn(txtC.getText())){
            ErrLabel1.setText(v.contactErr);
            return;
        }
        else
            ErrLabel1.setText("");
    }//GEN-LAST:event_txtCFocusLost

    private void ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnActionPerformed
//        try {
//            // TODO add your handling code here:
//            if(Name.getText().equals("") || Contact.getText().equals("")){
//                JOptionPane.showMessageDialog(rootPane,"Enter Name and Contact to get Info", "Err", 1);
//                return;
//            }
//            con = DBConnect.Connect();
//            stmt = con.createStatement();
//            String sql = "select * from patientreg where PatientName = '"+Name.getText()+"' and ContactNo = "+Contact.getText()+"";
//            System.out.println(sql);
//            rs = stmt.executeQuery(sql);
//            rs.next();
//            P_id.setText(Integer.toString(rs.getInt("PatientID")));
//            F_Name.setText(rs.getString("FathersName"));
//            Email.setText(rs.getString("Email"));
//            Age.setText(Integer.toString(rs.getInt("Age")));
//            Remarks.setText(rs.getString("Remarks"));
//            Add2.setText(rs.getString("Address"));
//            ButtonModel m;
//            if(rs.getString("Gender").equals("M"))
//                m = Male.getModel();
//            else
//                m = Female.getModel();
//            buttonGroup1.setSelected(m, true);
//            BldGrp.setSelectedItem(rs.getString("BG"));
//            AlttDoc.setSelectedItem(rs.getString("Doctor"));
//            State2.setSelectedItem(rs.getString("State"));
//            City2.setSelectedItem(rs.getString("City"));
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//       
       resetF();
    }//GEN-LAST:event_ResetBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new View("Doc").setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ResetBtnDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnDActionPerformed
        // TODO add your handling code here:
        resetF();
    }//GEN-LAST:event_ResetBtnDActionPerformed

    private void LogoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new LoginPharmcy().setVisible(true);
    }//GEN-LAST:event_LogoutBtnActionPerformed

    private void Add2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Add2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Add2KeyPressed

    private void State2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_State2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_State2FocusGained

    private void GenBillBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenBillBtnActionPerformed
        // TODO add your handling code here:
        new Billing().setVisible(true);
    }//GEN-LAST:event_GenBillBtnActionPerformed

    private void jTextArea1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea1FocusGained
        // TODO add your handling code here:
        jTextArea1.setText(jComboBox1.getSelectedItem().toString()+"\n"+jComboBox2.getSelectedItem().toString()+"\n"+jComboBox3.getSelectedItem().toString()+"\n"+jComboBox4.getSelectedItem().toString());
    }//GEN-LAST:event_jTextArea1FocusGained

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       if(JOptionPane.showConfirmDialog(rootPane, "Are you sure???") == 0)
       {
           jTabbedPane4.setEnabledAt(3,true);
           jTabbedPane4.setSelectedIndex(3);
           
       }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void RemarksFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_RemarksFocusGained
        // TODO add your handling code here:
        Remarks.setText("");
    }//GEN-LAST:event_RemarksFocusGained

    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Add2;
    private javax.swing.JTextArea AddArea;
    private javax.swing.JButton AddBtn;
    private javax.swing.JButton Add_Doc;
    private javax.swing.JTextField Age;
    private javax.swing.JComboBox<String> AlttDoc;
    private javax.swing.JComboBox<String> BldGrp;
    private javax.swing.JComboBox<String> BldGrp1;
    private javax.swing.JComboBox<String> City2;
    private javax.swing.JTextField Contact;
    private javax.swing.JTextField Email;
    private javax.swing.JLabel ErrLabel;
    private javax.swing.JLabel ErrLabel1;
    private javax.swing.JTextField F_Name;
    private javax.swing.JRadioButton Female;
    private javax.swing.JRadioButton FemaleD;
    private javax.swing.JButton GenBillBtn;
    private javax.swing.JButton LogoutBtn;
    private javax.swing.JRadioButton Male;
    private javax.swing.JRadioButton MaleD;
    private javax.swing.JTextField Name;
    private javax.swing.JLabel P_id;
    private javax.swing.JTextArea Remarks;
    private javax.swing.JButton ResetBtn;
    private javax.swing.JButton ResetBtnD;
    private javax.swing.JComboBox<String> State2;
    private javax.swing.JButton ViewBtn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTextArea jTextArea1;
    public javax.swing.JTextField txtC;
    public javax.swing.JTextField txtE;
    public javax.swing.JTextField txtFname;
    private javax.swing.JLabel txtId;
    public javax.swing.JTextField txtName;
    public javax.swing.JTextField txtQ;
    // End of variables declaration//GEN-END:variables
}
