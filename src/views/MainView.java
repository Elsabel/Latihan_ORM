/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author DELL
 */
public class MainView extends javax.swing.JFrame {

    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        dskHR = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnRegion = new javax.swing.JMenuItem();
        mnEmployee = new javax.swing.JMenuItem();
        mnJob = new javax.swing.JMenuItem();
        mnLocation = new javax.swing.JMenuItem();
        mnDepartment = new javax.swing.JMenuItem();
        mnCountry = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnReportRegion = new javax.swing.JMenuItem();
        mnReportEmployee = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        mnReportLocation = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HR SYSTEM");

        javax.swing.GroupLayout dskHRLayout = new javax.swing.GroupLayout(dskHR);
        dskHR.setLayout(dskHRLayout);
        dskHRLayout.setHorizontalGroup(
            dskHRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 705, Short.MAX_VALUE)
        );
        dskHRLayout.setVerticalGroup(
            dskHRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 542, Short.MAX_VALUE)
        );

        jMenu1.setText("File");

        mnRegion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        mnRegion.setText("Region");
        mnRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnRegionActionPerformed(evt);
            }
        });
        jMenu1.add(mnRegion);

        mnEmployee.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        mnEmployee.setText("Employee");
        mnEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnEmployeeActionPerformed(evt);
            }
        });
        jMenu1.add(mnEmployee);

        mnJob.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.CTRL_MASK));
        mnJob.setText("Job");
        mnJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnJobActionPerformed(evt);
            }
        });
        jMenu1.add(mnJob);

        mnLocation.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        mnLocation.setText("Location");
        mnLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnLocationActionPerformed(evt);
            }
        });
        jMenu1.add(mnLocation);

        mnDepartment.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        mnDepartment.setText("Department");
        mnDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnDepartmentActionPerformed(evt);
            }
        });
        jMenu1.add(mnDepartment);

        mnCountry.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        mnCountry.setText("Country");
        mnCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCountryActionPerformed(evt);
            }
        });
        jMenu1.add(mnCountry);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Report");

        mnReportRegion.setText("Region");
        mnReportRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnReportRegionActionPerformed(evt);
            }
        });
        jMenu2.add(mnReportRegion);

        mnReportEmployee.setText("Employee");
        mnReportEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnReportEmployeeActionPerformed(evt);
            }
        });
        jMenu2.add(mnReportEmployee);

        jMenuItem1.setText("Job");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Department");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        mnReportLocation.setText("Location");
        mnReportLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnReportLocationActionPerformed(evt);
            }
        });
        jMenu2.add(mnReportLocation);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dskHR)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dskHR)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnRegionActionPerformed
        // TODO add your handling code here:
        RegionsView regionsView = new RegionsView();
        regionsView.show();
        dskHR.add(regionsView);
    }//GEN-LAST:event_mnRegionActionPerformed

    private void mnEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnEmployeeActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
//        EmployeesView employeesView = new EmployeesView();
//        employeesView.show();
//        dskHR.add(employeesView);
    }//GEN-LAST:event_mnEmployeeActionPerformed

    private void mnJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnJobActionPerformed
        // TODO add your handling code here:
//        JobsView jobsView = new JobsView();
//        jobsView.show();
//        dskHR.add(jobsView);
    }//GEN-LAST:event_mnJobActionPerformed

    private void mnLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnLocationActionPerformed
        // TODO add your handling code here:
        LocationsView locations = new LocationsView();
        locations.show();
        dskHR.add(locations);
    }//GEN-LAST:event_mnLocationActionPerformed

    private void mnDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnDepartmentActionPerformed
        // TODO add your handling code here:
//        DepartmentsView dv = new DepartmentsView();
//        dv.show();
//        dskHR.add(dv);
    }//GEN-LAST:event_mnDepartmentActionPerformed

    private void mnCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCountryActionPerformed
        // TODO add your handling code here:
//        Country country = new Country();
//        country.show();
//        dskHR.add(country);
    }//GEN-LAST:event_mnCountryActionPerformed

    private void mnReportRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnReportRegionActionPerformed
        // TODO add your handling code here:
//        ReportView reportView = new ReportView("Region");
//        reportView.show();
//        dskHR.add(reportView);
    }//GEN-LAST:event_mnReportRegionActionPerformed

    private void mnReportEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnReportEmployeeActionPerformed
        // TODO add your handling code here:
//        ReportView reportView = new ReportView("Employee");
//        reportView.show();
//        dskHR.add(reportView);
    }//GEN-LAST:event_mnReportEmployeeActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
//        ReportView reportView = new ReportView("Job");
//        reportView.show();
//        dskHR.add(reportView);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
//        ReportView reportView = new ReportView("Department");
//        reportView.show();
//        dskHR.add(reportView);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void mnReportLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnReportLocationActionPerformed
            // TODO add your handling code here:
        ReportView reportView = new ReportView("Location");
        reportView.show();
        dskHR.add(reportView);
    }//GEN-LAST:event_mnReportLocationActionPerformed

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
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dskHR;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem mnCountry;
    private javax.swing.JMenuItem mnDepartment;
    private javax.swing.JMenuItem mnEmployee;
    private javax.swing.JMenuItem mnJob;
    private javax.swing.JMenuItem mnLocation;
    private javax.swing.JMenuItem mnRegion;
    private javax.swing.JMenuItem mnReportEmployee;
    private javax.swing.JMenuItem mnReportLocation;
    private javax.swing.JMenuItem mnReportRegion;
    // End of variables declaration//GEN-END:variables
}
