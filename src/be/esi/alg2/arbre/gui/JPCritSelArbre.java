/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.alg2.arbre.gui;

import be.esi.alg2.arbre.dto.ArbreCompletDto;
import be.esi.alg2.arbre.dto.ArbreDto;
import be.esi.alg2.gui.outils.JPCritSelGenerique;

/**
 *
 * @author marty
 */
class JPCritSelArbre extends JPCritSelGenerique<ArbreDto> {

    private javax.swing.JPanel criterePanel;
    private javax.swing.JPanel jPanelId;
    private SelectArbre jTId;
    private javax.swing.JLabel labelId;

    public JPCritSelArbre() {
        initComponents();
        this.revalidate();
        this.repaint();
    }

    private void initComponents() {
        criterePanel = new javax.swing.JPanel();
        jPanelId = new javax.swing.JPanel();
        labelId = new javax.swing.JLabel();
        jTId = new SelectArbre();


        criterePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Arbre"));

        labelId.setText("nom de l'arbre :");
        jPanelId.add(labelId);


        jPanelId.add(jTId);





        javax.swing.GroupLayout criterePanelLayout = new javax.swing.GroupLayout(criterePanel);
        criterePanel.setLayout(criterePanelLayout);
        criterePanelLayout.setHorizontalGroup(
                criterePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(criterePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(criterePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(0, Short.MAX_VALUE)));
        criterePanelLayout.setVerticalGroup(
                criterePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(criterePanelLayout.createSequentialGroup()
                .addComponent(jPanelId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGap(0, 0, Short.MAX_VALUE)));

        this.add(criterePanel, java.awt.BorderLayout.CENTER);




    }

    @Override
    public void setSel(ArbreDto t) {
        
    }

@Override
        public ArbreDto getCriteres() {
            return jTId.getObjectSelected();
}

   
   

    
    
}
