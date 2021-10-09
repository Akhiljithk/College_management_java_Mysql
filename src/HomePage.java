import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HomePage extends javax.swing.JFrame {

    public HomePage(){
        initComponents();
        connect();
        getAllStudentDetails();
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void connect(){
        try { 
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","Akhiljith@My112");
        } catch (SQLException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void refreshStudentTable(){
            DefaultTableModel dm = (DefaultTableModel)student_table.getModel();
            dm.getDataVector().removeAllElements();
            dm.fireTableDataChanged(); // notifies the JTable that the model has changed
            getAllStudentDetails();
    }
    public void clearStudentTextFeild(){
        sname.setText("");
        roll_no.setText("");
        address.setText("");
        Phone_no.setText("");
        e_mail.setText("");
    }
    public void getAllStudentDetails(){
    
        try {

            pst = con.prepareStatement("select roll_no,sname,address,Phone_no,e_mail from student");
            rs = pst.executeQuery();
            
            while(rs.next()){
                String roll_no = String.valueOf(rs.getInt("roll_no"));
                String sname = rs.getString("sname");
                String adderss = rs.getString("address");
                String phone_no = rs.getString("Phone_no");
                String e_mail = rs.getString("e_mail");
                
                String tableData[] = {roll_no,sname,adderss,phone_no,e_mail};
                DefaultTableModel studentDataModel = (DefaultTableModel)student_table.getModel();
                studentDataModel.addRow(tableData);
            }
            
           // student_table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (SQLException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        student_table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        sname = new javax.swing.JTextField();
        roll_no = new javax.swing.JTextField();
        Phone_no = new javax.swing.JTextField();
        e_mail = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        address = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        dep = new javax.swing.JComboBox<>();
        jButton9 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home Page");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel1.setText("Student Management");

        jButton1.setText("Teachers");
        jButton1.setFocusable(false);

        jButton2.setText("Marks");
        jButton2.setFocusable(false);

        jButton3.setText("Student");
        jButton3.setFocusable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jLabel1))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        student_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Roll No", "Name", "Address", "Phone No", "E-mail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        student_table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        student_table.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                student_tableFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(student_table);
        student_table.getAccessibleContext().setAccessibleName("student_table");

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel2.setText("Student details table");

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel3.setText("Name");

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel4.setText("Roll No");

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel5.setText("Address");

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel6.setText("Phone No");

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel7.setText("E-maiil");

        sname.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        sname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                snameActionPerformed(evt);
            }
        });

        roll_no.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N

        Phone_no.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N

        e_mail.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N

        address.setColumns(20);
        address.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        address.setRows(5);
        jScrollPane2.setViewportView(address);

        jButton4.setBackground(new java.awt.Color(0, 204, 153));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Save");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 204, 51));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Update");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 102, 102));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Clear All");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Student filters"));

        jLabel8.setText("Dsiplay students name starts with:");

        jLabel9.setText("Display the mark of student has roll No:");

        jButton7.setText("Apply filter");

        jLabel10.setText("Displat the students in the stream");

        jButton8.setText("Cleear all");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IT", "EC", "EEE", "CE", "ME" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(jTextField5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addContainerGap())
        );

        jLabel11.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel11.setText("Department");

        dep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ME", "EC", "IT", "CE" }));
        dep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(255, 102, 102));
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Delete");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel12.setText("Table settings");

        jButton10.setBackground(jButton5.getBackground());
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Edit");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 59, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(sname)
                                    .addComponent(roll_no)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7))
                                    .addGap(17, 17, 17)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Phone_no)
                                        .addComponent(e_mail)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(33, 33, 33)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(27, 27, 27)
                                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(dep, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(317, 317, 317))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(sname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(roll_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Phone_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(e_mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(dep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton5)
                            .addComponent(jButton6))
                        .addContainerGap(55, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton9)
                            .addComponent(jLabel12)
                            .addComponent(jButton10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        sname.getAccessibleContext().setAccessibleName("sname");
        roll_no.getAccessibleContext().setAccessibleName("roll_no");
        roll_no.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void snameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_snameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_snameActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String depId = null;
        try {
            String snametxt = sname.getText();
            int rollno = Integer.parseInt(roll_no.getText());
            String addresstxt = address.getText();
            String phno = Phone_no.getText();
            String emailtxt = e_mail.getText();
            String departmenttxt = dep.getSelectedItem().toString();
            
            pst = con.prepareStatement("select dep_id from department where dep_name = ?");
            pst.setString(1, departmenttxt);
            rs = pst.executeQuery();
            
            while(rs.next()){
               depId = rs.getString(1);
            }
            
            pst = con.prepareStatement("INSERT INTO student values(?,?,?,?,?,?)");
            pst.setInt(1, rollno);
            pst.setString(2, snametxt);
            pst.setString(3, addresstxt);
            pst.setString(4, phno);
            pst.setString(5, emailtxt);
            pst.setString(6, depId);
            
            int k = pst.executeUpdate();
            
            if(k==1){
                sname.setText("");
                roll_no.setText("");
                address.setText("");
                Phone_no.setText("");
                e_mail.setText("");
                DefaultTableModel dm = (DefaultTableModel)student_table.getModel();
                dm.getDataVector().removeAllElements();
                dm.fireTableDataChanged(); // notifies the JTable that the model has changed
                getAllStudentDetails();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void student_tableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_student_tableFocusGained
        // TODO add your handling code here:
//         InputMap im = student_table.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
//         System.out.println(im);
    }//GEN-LAST:event_student_tableFocusGained

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        DefaultTableModel tbModel = (DefaultTableModel) student_table.getModel();
        
        if(student_table.getSelectedRowCount()==1){
            try {
                int selectedRow = student_table.getSelectedRow();
                String rollno = student_table.getModel().getValueAt(selectedRow, 0).toString();
                
                pst = con.prepareStatement("delete from student where roll_no = ?");
                pst.setString(1, rollno);
                int k = pst.executeUpdate();
                if(k==1){
                    JOptionPane.showMessageDialog(this, "Delete aayi ketto");
                }
                tbModel.removeRow(student_table.getSelectedRow());
            } catch (SQLException ex) {
                Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(student_table.getSelectedRowCount()>1){
                JOptionPane.showMessageDialog(this, "agane select cheyth delete aakan ninte achan kond query ezhuthuvooda!!"); 
        }else{
            JOptionPane.showMessageDialog(this, "select a item to delete");
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        try {
           DefaultTableModel tbModel = (DefaultTableModel) student_table.getModel();
        
           if(student_table.getSelectedRowCount()==1){
    
//                jButton10.setEnabled(false);
//                jButton9.setEnabled(false);
//                jButton4.setEnabled(false);
                
                int selectedRow = student_table.getSelectedRow();
                String rollno = student_table.getModel().getValueAt(selectedRow, 0).toString();
                
                pst = con.prepareStatement("select student.sname,student.roll_no,student.address,student.phone_no,student.e_mail, department.dep_name from student join department on student.dep_id = department.dep_id where roll_no = ?;");
                pst.setInt(1, Integer.parseInt(rollno));
                rs = pst.executeQuery();
            
                while(rs.next()){
                    String roll_not = String.valueOf(rs.getInt("student.roll_no"));
                    String snamet = rs.getString("student.sname");
                    String addersst = rs.getString("student.address");
                    String phone_not = rs.getString("student.Phone_no");
                    String e_mailt = rs.getString("student.e_mail");
                    String depnamet = rs.getString("department.dep_name");
                    
                    sname.setText(snamet);
                    roll_no.setText(roll_not);
                    address.setText(addersst);
                    Phone_no.setText(phone_not);
                    e_mail.setText(e_mailt);
                    dep.setSelectedItem(depnamet);
                    
                }
                
               // refreshStudentTable();

        }else if(student_table.getSelectedRowCount()>1){
                JOptionPane.showMessageDialog(this, "agane select cheyth delete aakan ninte achan kond query ezhuthuvooda!!"); 
        }else{
            JOptionPane.showMessageDialog(this, "select a item to update");
        }
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
                sname.setText("");
                roll_no.setText("");
                address.setText("");
                Phone_no.setText("");
                e_mail.setText("");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String depId = null;
        try {
            String nametxt = sname.getText();
            int rollnotxt = Integer.parseInt(roll_no.getText());
            String addresstxt = address.getText();
            String phnotxt = Phone_no.getText();
            String emailtxt = e_mail.getText();
            String departmenttxt = dep.getSelectedItem().toString();

            pst = con.prepareStatement("select dep_id from department where dep_name = ?");
            pst.setString(1, departmenttxt);
            rs = pst.executeQuery();

        while(rs.next()){
           depId = rs.getString(1);
        }
        pst = con.prepareStatement("update student set roll_no=?, sname=?, address=?, phone_no=?,e_mail=?, dep_id=? where roll_no = ?");
        pst.setInt(1, rollnotxt);
        pst.setString(2, nametxt);
        pst.setString(3, addresstxt);
        pst.setString(4, phnotxt);
        pst.setString(5, emailtxt);
        pst.setString(6, depId);
        pst.setInt(7, rollnotxt);
        
        int k = pst.executeUpdate();
        
        if(k==1){
            JOptionPane.showMessageDialog(this, "Details updated");
            clearStudentTextFeild();
            refreshStudentTable();
        }else{
            JOptionPane.showMessageDialog(this, "error on update");
        }
        
        } catch (SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void depActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_depActionPerformed

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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Phone_no;
    private javax.swing.JTextArea address;
    private javax.swing.JComboBox<String> dep;
    private javax.swing.JTextField e_mail;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField roll_no;
    private javax.swing.JTextField sname;
    private javax.swing.JTable student_table;
    // End of variables declaration//GEN-END:variables
}
