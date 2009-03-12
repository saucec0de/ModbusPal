/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GeneratorRenderer.java
 *
 * HISTORY:
 * - background color changes when "generatorHasStarted" or
 *   "generatorHasEnded" events occur.
 *
 * Created on 21 déc. 2008, 21:03:38
 */

package modbuspal.automation;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *
 * @author avincon
 */
public class GeneratorRenderer
extends javax.swing.JPanel
implements GeneratorListener
{
    private Generator generator;
    private JPanel customPanel;
    private AutomationEditor editor;


    /** Creates new form GeneratorRenderer */
    public GeneratorRenderer(AutomationEditor parent, Generator gen)
    {
        editor = parent;
        generator = gen;
        customPanel = gen.getPanel();
        customPanel.setOpaque(false);
        setName(gen.getGeneratorName());
        initComponents();
    }

    @Override
    public void setEnabled(boolean enabled)
    {
        super.setEnabled(enabled);
        upButton.setEnabled(enabled);
        deleteButton.setEnabled(enabled);
        downButton.setEnabled(enabled);
        customPanel.setEnabled(enabled);
        durationTextField.setEnabled(enabled);
    }

    Generator getGenerator()
    {
        return generator;
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        iconLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        upButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        downButton = new javax.swing.JButton();
        durationTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setLayout(new java.awt.BorderLayout());

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridBagLayout());

        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText(generator.getGeneratorName());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(titleLabel, gridBagConstraints);

        iconLabel.setIcon(generator.getIcon());
        jPanel1.add(iconLabel, new java.awt.GridBagConstraints());

        add(jPanel1, java.awt.BorderLayout.WEST);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.BorderLayout());
        add(jPanel2, java.awt.BorderLayout.CENTER);
        jPanel2.add( customPanel, BorderLayout.CENTER );

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.GridBagLayout());

        upButton.setText("Up");
        upButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel3.add(upButton, gridBagConstraints);

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel3.add(deleteButton, gridBagConstraints);

        downButton.setText("Down");
        downButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel3.add(downButton, gridBagConstraints);

        durationTextField.setText(String.valueOf(generator.getDuration()));
        durationTextField.setPreferredSize(new java.awt.Dimension(60, 20));
        durationTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                durationTextFieldFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        jPanel3.add(durationTextField, gridBagConstraints);

        jLabel1.setText("Duration:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        jPanel3.add(jLabel1, gridBagConstraints);

        add(jPanel3, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents

    private void durationTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_durationTextFieldFocusLost
        String exp = durationTextField.getText();
        int val = Integer.parseInt(exp);
        generator.setDuration(val);
    }//GEN-LAST:event_durationTextFieldFocusLost

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        editor.remove(this);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void downButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downButtonActionPerformed
        editor.down(this);
    }//GEN-LAST:event_downButtonActionPerformed

    private void upButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upButtonActionPerformed
        editor.up(this);
    }//GEN-LAST:event_upButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton downButton;
    private javax.swing.JTextField durationTextField;
    private javax.swing.JLabel iconLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton upButton;
    // End of variables declaration//GEN-END:variables

    public void generatorHasEnded(Generator gen)
    {
        if( gen == generator )
        {
            setBackground( UIManager.getColor("Panel.background") );
        }
    }

    public void generatorHasStarted(Generator gen)
    {
        if( gen == generator )
        {
            setBackground( UIManager.getColor("List.selectionBackground") );
        }
    }
}
