
import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;


public class JuegoPreg extends javax.swing.JFrame {
    
    static String urlpreg ="https://docs.google.com/spreadsheets/d/e/2PACX-1vTbYF_dU_mObmIIFCNtdTKq7uKM_oi8MEd1-yZ0BZWSxUya7smxiSFHJpeSNLVvfK7hd1WceCAyeAOb/pub?output=tsv"; //url hoja calculo con preguntas en formato TSV
    static String textoBase = LeerArchivo_ASCII(urlpreg);

    static String[] renglones = textoBase.split("\n");
    static int cantPreguntas = renglones.length; 
    static String[][] basePreguntas = new String[cantPreguntas][6];
     public static void main(String args[]) {
    
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
        }
          for(int i = 0; i < renglones.length; i++){
        String renglon = renglones[i];
        basePreguntas[i]=renglon.split("\t");}   
       
        new JuegoPreg();
     }
            String[] preguntaElegida; 
            String categoria;
            String pregunt; 
            String respuesta;
            ArrayList<String> opciones = new ArrayList<>(); 
            public void eligePregunta(int n){
                preguntaElegida=basePreguntas[n];
                categoria=preguntaElegida[0];
                pregunt=preguntaElegida[1];
                respuesta=preguntaElegida[5];
                opciones.clear();
                for (int i=2;i<preguntaElegida.length;i++){
                    opciones.add(preguntaElegida[i]);
                }
      
                for (int i=0 ; i<4;i++){
                Collections.shuffle(opciones);
            }
            }
            public void mostrarPregunta(){
              jLabelCategoria.setText(categoria);
              jLabel2Pregunta.setText(pregunt);
              jButtonOP1.setText(opciones.get(0));
              jButtonOP2.setText(opciones.get(1));
              jButtonOP3.setText(opciones.get(2));
             jButtonOP4.setText(opciones.get(3));
            }    
            void responder(int n){
                if(opciones.get(n).equals(respuesta)){
                JOptionPane.showMessageDialog(this,
                        "Respuesta Correcta",
                        "Eeeeeessaaa",
                        JOptionPane.INFORMATION_MESSAGE);
                } else {
                     JOptionPane.showMessageDialog(this,
                             "Respuesta Incorrecta",
                             "Tremeeendo",
                             JOptionPane.ERROR_MESSAGE);  
                        }
                   ponePley();     
            }
            int nropreg=0;
           public void ponePley(){
               if (nropreg==cantPreguntas){
                   JOptionPane.showMessageDialog(this,"Ya lo diste vuelta","So buenisimo",JOptionPane.PLAIN_MESSAGE);
               System.exit(0);
               }
             eligePregunta(nropreg);
             mostrarPregunta();
             nropreg++;
            
           }
        
    


    public JuegoPreg() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        ponePley();
    }
 public static String LeerArchivo_ASCII(String ruta){
       try{
            if (ruta == null) {
            throw new RuntimeException("Error, la URL de lectura no puede ser nula");
        }
         URL url = new URL(ruta);   
        URLConnection conexión = url.openConnection();
        InputStreamReader isr = new InputStreamReader(conexión.getInputStream());
        return LeerArchivo_ASCII(isr);
       }catch (Exception ex){ 
           System.out.print("No hay internet, no se pudo acceder a la base de datos");
           System.exit(0);
       }
       return "";
    }


    public static String LeerArchivo_ASCII(Reader reader) throws Exception {
        BufferedReader br = new BufferedReader(reader);
        String texto = "";
        String linea;
        boolean primerRenglón = true;
        while ((linea = br.readLine()) != null) {
            if (primerRenglón) {
                primerRenglón = false;
            } else {
                texto += "\n";
            }
            texto += linea;
        }
        reader.close();
        br.close();
        return texto;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelCategoria = new javax.swing.JLabel();
        jLabel2Pregunta = new javax.swing.JLabel();
        jButtonOP2 = new javax.swing.JButton();
        jButtonOP3 = new javax.swing.JButton();
        jButtonOP4 = new javax.swing.JButton();
        jButtonOP1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelCategoria.setFont(new java.awt.Font("Open Sans Semibold", 1, 18)); // NOI18N
        jLabelCategoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCategoria.setText("categoria");

        jLabel2Pregunta.setFont(new java.awt.Font("Open Sans Semibold", 1, 18)); // NOI18N
        jLabel2Pregunta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2Pregunta.setText("pregunta con img o no");

        jButtonOP2.setFont(new java.awt.Font("Open Sans Semibold", 0, 18)); // NOI18N
        jButtonOP2.setText("opcion2");
        jButtonOP2.setToolTipText("");
        jButtonOP2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonOP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOP2ActionPerformed(evt);
            }
        });

        jButtonOP3.setFont(new java.awt.Font("Open Sans Semibold", 0, 18)); // NOI18N
        jButtonOP3.setText("opcion3");
        jButtonOP3.setToolTipText("");
        jButtonOP3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonOP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOP3ActionPerformed(evt);
            }
        });

        jButtonOP4.setFont(new java.awt.Font("Open Sans Semibold", 0, 18)); // NOI18N
        jButtonOP4.setText("opcion4");
        jButtonOP4.setToolTipText("");
        jButtonOP4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonOP4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOP4ActionPerformed(evt);
            }
        });

        jButtonOP1.setFont(new java.awt.Font("Open Sans Semibold", 0, 18)); // NOI18N
        jButtonOP1.setText("opcion1");
        jButtonOP1.setToolTipText("");
        jButtonOP1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonOP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOP1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelCategoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2Pregunta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButtonOP2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButtonOP4, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
            .addComponent(jButtonOP1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
            .addComponent(jButtonOP3, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2Pregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonOP1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonOP2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonOP3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonOP4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOP1ActionPerformed
        responder(0);
    }//GEN-LAST:event_jButtonOP1ActionPerformed

    private void jButtonOP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOP2ActionPerformed
        responder(1);
    }//GEN-LAST:event_jButtonOP2ActionPerformed

    private void jButtonOP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOP3ActionPerformed
        responder(2);
    }//GEN-LAST:event_jButtonOP3ActionPerformed

    private void jButtonOP4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOP4ActionPerformed
        responder(3);
    }//GEN-LAST:event_jButtonOP4ActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonOP1;
    private javax.swing.JButton jButtonOP2;
    private javax.swing.JButton jButtonOP3;
    private javax.swing.JButton jButtonOP4;
    private javax.swing.JLabel jLabel2Pregunta;
    private javax.swing.JLabel jLabelCategoria;
    // End of variables declaration//GEN-END:variables
}
