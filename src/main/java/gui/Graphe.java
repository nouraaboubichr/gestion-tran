/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package gui;
import connexion.Connexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author hp
 */
public class Graphe extends javax.swing.JInternalFrame {
    private DefaultCategoryDataset dataset;
    private Connexion connexion;

    /**
     * Creates new form Graphe
     */
    public Graphe() {
        initComponents();
       connexion = Connexion.getInstance();
        this.setTitle("Répartition des abonnements par bus");
        
        dataset = new DefaultCategoryDataset();
        load();
        
        // Créer le graphique à barres
        JFreeChart barChart = ChartFactory.createBarChart(
                "Répartition des abonnements par bus",
                "Bus", // Axe des X (les bus)
                "Nombre d'abonnés", // Axe des Y (nombre d'abonnés)
                dataset
        );
        
        // Créer le panneau de graphique
        ChartPanel chartPanel = new ChartPanel(barChart);
        setContentPane(chartPanel);
    }
    
    private void load() {
        String req = "SELECT b.id AS bus_id, b.immatriculation, COUNT(a.etudiant_id) AS nb_abonnes " +
                     "FROM bus b " +
                     "LEFT JOIN abonnement_transport a ON b.id = a.bus_id " +
                     "GROUP BY b.id";
        
        try (PreparedStatement ps = connexion.getCn().prepareStatement(req);
             ResultSet rs = ps.executeQuery()) {

            dataset.clear();  // Effacer les anciennes données

            // Ajouter les données dans le dataset
            while (rs.next()) {
                String busId = rs.getString("immatriculation");
                int nbAbonnes = rs.getInt("nb_abonnes");
                dataset.addValue(nbAbonnes, "Abonnés", busId); // Ajouter les valeurs dans le graphique
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erreur de connexion à la base de données !");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 803, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
