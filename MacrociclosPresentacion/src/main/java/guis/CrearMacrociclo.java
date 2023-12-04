/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package guis;

import control.ControlCrearMacrociclo;
import entidades.Macrociclo;
import enumeradores.Operacion;
import enumeradores.Rama;
import fachadas.FachadaNegocio;
import interfaces.INegocio;
import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.table.DefaultTableModel;
import org.bson.types.ObjectId;

/**
 *
 * @author dany3
 */
public class CrearMacrociclo extends javax.swing.JFrame {

    private final ControlCrearMacrociclo control;
    private final INegocio fachada = new FachadaNegocio();
    private final Operacion operacion;
    private Macrociclo macrociclo;
    
    /**
     * Creates new form crearMacrociclo
     * @param operacion
     */
    public CrearMacrociclo(Operacion operacion) {
        initComponents();
        
        this.control = new ControlCrearMacrociclo(this.fachada);
        this.control.cargarComboRamas(comboBoxRamas);
        this.control.crearListeners(this, (DefaultTableModel) this.tablaMesociclosGeneral.getModel(), (DefaultTableModel) this.tablaMesociclosEspecial.getModel(), (DefaultTableModel) this.tablaMesociclosCompetitiva.getModel());
        this.operacion = operacion;
        
        switch (operacion) {
            case CREAR:
                break;
            case ACTUALIZAR:
                Macrociclo macrocicloA = this.fachada.obtenerMacrociclo(new ObjectId("65655db3b901340538654e9a"));
                this.macrociclo = macrocicloA;
                
                this.control.cargarElementosActualizar(macrocicloA, comboBoxDeportes, comboBoxRamas,
                        comboBoxJefesRamas, comboBoxRamas, comboBoxMetodologos,
                        campoTextoStatus, pickerInicio, pickerFin, campoTextoTotalSemanas,
                        campoTextoPorcentajePreparativo, campoTextoSemanasPreparativo,
                        campoTextoPorcentajeCompetitivo, campoTextoSemanasCompetitivo,
                        campoTextoPorcentajeGeneral, campoTextoSemanasGeneral,
                        campoTextoPorcentajeEspecial, campoTextoSemanasEspecial,
                        campoTextoPorcentajePrecompetitiva,
                        campoTextoSemanasPrecompetitiva,
                        campoTextoPorcentajeCompetitivoB,
                        campoTextoSemanasCompetitivoB,
                        (DefaultTableModel) tablaMesociclosGeneral.getModel(), (DefaultTableModel) tablaMesociclosEspecial.getModel(),
                        (DefaultTableModel) tablaMesociclosCompetitiva.getModel());
                this.btnGuardar.setText("Actualizar macrociclo");
                break;
            case MOSTRAR:
                // TODO: lógica de mostrar
                break;
        }
        
        this.tablaMesociclosGeneral.getTableHeader().setReorderingAllowed(false);
        this.tablaMesociclosEspecial.getTableHeader().setReorderingAllowed(false);
        this.tablaMesociclosCompetitiva.getTableHeader().setReorderingAllowed(false);
    }
    
    public CrearMacrociclo(Macrociclo macrociclo) {
        initComponents();
        
        this.control = new ControlCrearMacrociclo(this.fachada);
        this.control.cargarComboRamas(comboBoxRamas);
        this.control.crearListeners(this, (DefaultTableModel) this.tablaMesociclosGeneral.getModel(), (DefaultTableModel) this.tablaMesociclosEspecial.getModel(), (DefaultTableModel) this.tablaMesociclosCompetitiva.getModel());
        this.operacion = Operacion.ACTUALIZAR;
        this.macrociclo = macrociclo;
                
        this.control.cargarElementosActualizar(macrociclo, comboBoxDeportes, comboBoxRamas,
                comboBoxJefesRamas, comboBoxRamas, comboBoxMetodologos,
                campoTextoStatus, pickerInicio, pickerFin, campoTextoTotalSemanas,
                campoTextoPorcentajePreparativo, campoTextoSemanasPreparativo,
                campoTextoPorcentajeCompetitivo, campoTextoSemanasCompetitivo,
                campoTextoPorcentajeGeneral, campoTextoSemanasGeneral,
                campoTextoPorcentajeEspecial, campoTextoSemanasEspecial,
                campoTextoPorcentajePrecompetitiva,
                campoTextoSemanasPrecompetitiva,
                campoTextoPorcentajeCompetitivoB,
                campoTextoSemanasCompetitivoB,
                (DefaultTableModel) tablaMesociclosGeneral.getModel(), (DefaultTableModel) tablaMesociclosEspecial.getModel(),
                (DefaultTableModel) tablaMesociclosCompetitiva.getModel());
        this.btnGuardar.setText("Actualizar macrociclo");
        
        this.tablaMesociclosGeneral.getTableHeader().setReorderingAllowed(false);
        this.tablaMesociclosEspecial.getTableHeader().setReorderingAllowed(false);
        this.tablaMesociclosCompetitiva.getTableHeader().setReorderingAllowed(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboBoxEntrenadoresAuxiliares = new javax.swing.JComboBox<>();
        comboBoxDeportes = new javax.swing.JComboBox<>();
        comboBoxRamas = new javax.swing.JComboBox<>();
        comboBoxJefesRamas = new javax.swing.JComboBox<>();
        comboBoxMetodologos = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        campoTextoPorcentajePreparativo = new javax.swing.JTextField();
        campoTextoSemanasPreparativo = new javax.swing.JTextField();
        campoTextoPorcentajeCompetitivo = new javax.swing.JTextField();
        campoTextoSemanasCompetitivo = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        campoTextoPorcentajeGeneral = new javax.swing.JTextField();
        campoTextoSemanasGeneral = new javax.swing.JTextField();
        campoTextoPorcentajeEspecial = new javax.swing.JTextField();
        campoTextoSemanasEspecial = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        pickerInicio = new com.github.lgooddatepicker.components.DatePicker();
        pickerFin = new com.github.lgooddatepicker.components.DatePicker();
        campoTextoTotalSemanas = new javax.swing.JTextField();
        scrollPaneTablaGeneral = new javax.swing.JScrollPane();
        tablaMesociclosGeneral = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        campoTextoPorcentajePrecompetitiva = new javax.swing.JTextField();
        campoTextoSemanasPrecompetitiva = new javax.swing.JTextField();
        campoTextoPorcentajeCompetitivoB = new javax.swing.JTextField();
        campoTextoSemanasCompetitivoB = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        scrollPaneTablaEspecial = new javax.swing.JScrollPane();
        tablaMesociclosEspecial = new javax.swing.JTable();
        scrollPaneTablaCompetitiva = new javax.swing.JScrollPane();
        tablaMesociclosCompetitiva = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        campoTextoStatus = new javax.swing.JTextField();
        btnCalcularSemanas = new javax.swing.JButton();
        btnAnadirGeneral = new javax.swing.JButton();
        btnEliminarGeneral = new javax.swing.JButton();
        btnAnadirEspecial = new javax.swing.JButton();
        btnEliminarEspecial = new javax.swing.JButton();
        btnAnadirCompetitiva = new javax.swing.JButton();
        btnEliminarCompetitiva = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nuevo Macro");
        setAutoRequestFocus(false);

        jLabel1.setText("Crear Nuevo Macrociclo");
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel2.setText("Deporte");

        jLabel3.setText("Rama");

        jLabel4.setText("Jefe de rama");

        jLabel5.setText("Ent.Aux./Prep. Fis.");

        jLabel6.setText("Metodólogo");

        comboBoxEntrenadoresAuxiliares.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aaron Leal", "Abraham Torres", "Adrian Romero", "Alfredo Osuna", "Alfredo Sillas", "Ana Nayeli Leon", "Benjamin Murrieta", "Carlos Lara", "Carlos Lugo", "Cristian Arreola", "Cristian Garcia", "Francisco Amavizca", "Francisco Solis", "Hugo Avendaño", "Ivan Bracamontes", "Jesús Borquez", "Jorge Aguilar", "Juan Cardenas", "Luis Andres Cuadras Alaniz", "Luis Lopez", "Mario Cardona", "Miguel Ayon", "Moises Soto", "Oscar Marquina", "Rafael Felix", "Ramon Andres Romero", "Raul Hernandez", "Raul Velazquez", "Rene Molina", "Ricardo Saavedra", "Luis Gerardo Miranda", "Rosa Guzman", "Sergio Alejandro Castro Félix", "Victor Ortiz", "Wendy Guizar" }));

        comboBoxDeportes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Beisbol", "Softbol", "Tenis", "Tenis de Mesa", "Voleibol Playa", "Ajedrez", "Atletismo Lanzamiento", "Atletismo Pista", "Atletismo Saltos", "Baloncesto", "Balonmano", "Boxeo Universitario", "Escalada Deportiva", "Esgrima", "Natación", "Gimnasia aerobica", "Halterofilia", "Judo", "Karate do", "Lucha Universitaria", "Rugby Seven", "Futbol Americano", "Tae Kwon Do", "Futbol Bardas", "Tochito", "Triatlon", "Voleibol Sala", "Futbol Soccer" }));

        comboBoxJefesRamas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aaron Leal", "Abraham Torres", "Adrian Romero", "Alfredo Osuna", "Alfredo Sillas", "Ana Nayeli Leon", "Benjamin Murrieta", "Carlos Lara", "Carlos Lugo", "Cristian Arreola", "Cristian Garcia", "Francisco Amavizca", "Francisco Solis", "Hugo Avendaño", "Ivan Bracamontes", "Jesús Borquez", "Jorge Aguilar", "Juan Cardenas", "Luis Andres Cuadras Alaniz", "Luis Lopez", "Mario Cardona", "Miguel Ayon", "Moises Soto", "Oscar Marquina", "Rafael Felix", "Ramon Andres Romero", "Raul Hernandez", "Raul Velazquez", "Rene Molina", "Ricardo Saavedra", "Luis Gerardo Miranda", "Rosa Guzman", "Sergio Alejandro Castro Félix", "Victor Ortiz", "Wendy Guizar" }));

        comboBoxMetodologos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Benjamin Murrieta", "Jesus Borquez" }));

        jLabel7.setText("Inicio del plan:");

        jLabel8.setText("Fin del plan:");

        jLabel9.setText("Total de semanas:");

        jLabel13.setText("Periodo preparatorio");

        jLabel14.setText("Periodo competitivo");

        jLabel15.setText("%");

        jLabel16.setText("Semanas");

        campoTextoSemanasCompetitivo.setToolTipText("");

        jLabel17.setText("Periodo prep.");

        jLabel18.setText("%");

        jLabel19.setText("Semanas");

        jLabel20.setText("Etapa general");

        jLabel21.setText("Etapa especial");

        btnGuardar.setText("Guardar Nuevo Macrociclo");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        campoTextoTotalSemanas.setEditable(false);

        tablaMesociclosGeneral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Semanas", "Ciclicidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPaneTablaGeneral.setViewportView(tablaMesociclosGeneral);

        jLabel22.setText("Periodo comp.");

        jLabel23.setText("Precompetitivo");

        jLabel24.setText("Competitivo");

        jLabel25.setText("%");

        jLabel26.setText("Semanas");

        tablaMesociclosEspecial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Semanas", "Ciclicidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPaneTablaEspecial.setViewportView(tablaMesociclosEspecial);

        tablaMesociclosCompetitiva.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Semanas", "Ciclicidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPaneTablaCompetitiva.setViewportView(tablaMesociclosCompetitiva);

        jLabel10.setText("Mesociclos General");

        jLabel11.setText("Mesociclos Especial");

        jLabel12.setText("Mesociclos Competitiva");

        jLabel27.setText("Status");

        campoTextoStatus.setEditable(false);
        campoTextoStatus.setText("En tránsito");

        btnCalcularSemanas.setText("Calcular semanas");
        btnCalcularSemanas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularSemanasActionPerformed(evt);
            }
        });

        btnAnadirGeneral.setText("Añadir mesociclo");
        btnAnadirGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirGeneralActionPerformed(evt);
            }
        });

        btnEliminarGeneral.setText("Eliminar mesociclo");
        btnEliminarGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarGeneralActionPerformed(evt);
            }
        });

        btnAnadirEspecial.setText("Añadir mesociclo");
        btnAnadirEspecial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirEspecialActionPerformed(evt);
            }
        });

        btnEliminarEspecial.setText("Eliminar mesociclo");
        btnEliminarEspecial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEspecialActionPerformed(evt);
            }
        });

        btnAnadirCompetitiva.setText("Añadir mesociclo");
        btnAnadirCompetitiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirCompetitivaActionPerformed(evt);
            }
        });

        btnEliminarCompetitiva.setText("Eliminar mesociclo");
        btnEliminarCompetitiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCompetitivaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addComponent(jLabel15))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(campoTextoPorcentajePreparativo)
                                    .addComponent(campoTextoPorcentajeCompetitivo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(campoTextoSemanasPreparativo)
                                .addComponent(campoTextoSemanasCompetitivo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel16)))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoTextoPorcentajeGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoTextoPorcentajeEspecial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboBoxDeportes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBoxRamas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBoxJefesRamas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBoxEntrenadoresAuxiliares, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBoxMetodologos, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoTextoSemanasEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoTextoSemanasGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel19)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel22))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel24)
                                .addComponent(jLabel23)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(campoTextoPorcentajePrecompetitiva)
                                    .addComponent(campoTextoPorcentajeCompetitivoB, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoTextoSemanasPrecompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoTextoSemanasCompetitivoB, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCalcularSemanas)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel25)
                                        .addGap(92, 92, 92)
                                        .addComponent(jLabel26)))))
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoTextoTotalSemanas, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(pickerFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel27)
                                        .addComponent(jLabel7))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pickerInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(campoTextoStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(275, 275, 275))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(scrollPaneTablaEspecial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(425, 425, 425)
                        .addComponent(jLabel10))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(400, 400, 400)
                        .addComponent(jLabel12))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(414, 414, 414)
                        .addComponent(jLabel11))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(386, 386, 386)
                        .addComponent(jLabel1))
                    .addComponent(scrollPaneTablaGeneral, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneTablaCompetitiva))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnadirGeneral)
                    .addComponent(btnEliminarGeneral)
                    .addComponent(btnAnadirEspecial)
                    .addComponent(btnEliminarEspecial)
                    .addComponent(btnAnadirCompetitiva)
                    .addComponent(btnEliminarCompetitiva))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(385, 385, 385)
                    .addComponent(btnGuardar)
                    .addContainerGap(588, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(campoTextoStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(pickerInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(pickerFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(campoTextoTotalSemanas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCalcularSemanas)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1)
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(comboBoxDeportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(comboBoxRamas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(comboBoxJefesRamas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(comboBoxEntrenadoresAuxiliares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(comboBoxMetodologos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(campoTextoPorcentajePreparativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(campoTextoPorcentajeCompetitivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(campoTextoPorcentajeGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoTextoPorcentajeEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoTextoSemanasPreparativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoTextoSemanasCompetitivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel25)
                                .addComponent(jLabel26))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(campoTextoPorcentajePrecompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(campoTextoSemanasPrecompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(campoTextoPorcentajeCompetitivoB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(campoTextoSemanasCompetitivoB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel22)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel23)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoTextoSemanasGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(campoTextoSemanasEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollPaneTablaGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAnadirGeneral)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarGeneral)))
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollPaneTablaEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAnadirEspecial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarEspecial)))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollPaneTablaCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAnadirCompetitiva)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarCompetitiva)))
                .addGap(68, 68, 68))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap(771, Short.MAX_VALUE)
                    .addComponent(btnGuardar)
                    .addContainerGap()))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1121, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        LocalDate lcInicio = this.pickerInicio.getDate();
        LocalDate lcFin = this.pickerFin.getDate();
        
        Date fechaInicio = new GregorianCalendar(lcInicio.getYear(), lcInicio.getMonthValue() - 1, lcInicio.getDayOfMonth()).getTime();
        Date fechaFin = new GregorianCalendar(lcFin.getYear(), lcFin.getMonthValue() - 1, lcFin.getDayOfMonth()).getTime();
        
        if (operacion.equals(Operacion.CREAR)) {
            this.control.guardarMacrociclo(this, new ObjectId("65415812c421fde5b6f9cc9b"), comboBoxDeportes,
                comboBoxRamas, comboBoxJefesRamas,
                comboBoxEntrenadoresAuxiliares, comboBoxMetodologos,
                campoTextoStatus, campoTextoTotalSemanas, campoTextoSemanasPreparativo,
                campoTextoSemanasCompetitivo, campoTextoSemanasGeneral, campoTextoSemanasEspecial,
                campoTextoSemanasPrecompetitiva, campoTextoSemanasCompetitivoB,
                (DefaultTableModel) tablaMesociclosGeneral.getModel(),
                (DefaultTableModel) tablaMesociclosEspecial.getModel(),
                (DefaultTableModel) tablaMesociclosCompetitiva.getModel(), fechaInicio, fechaFin);
        } else if (operacion.equals(Operacion.ACTUALIZAR)) {
            this.control.actualizarMacrociclo(this, comboBoxDeportes, comboBoxRamas,
                    comboBoxJefesRamas, comboBoxEntrenadoresAuxiliares,
                    comboBoxMetodologos, campoTextoStatus, campoTextoTotalSemanas,
                    campoTextoSemanasPreparativo, campoTextoSemanasCompetitivo, campoTextoSemanasGeneral,
                    campoTextoSemanasEspecial, campoTextoSemanasPrecompetitiva, campoTextoSemanasCompetitivoB,
                    (DefaultTableModel) tablaMesociclosGeneral.getModel(), (DefaultTableModel) tablaMesociclosEspecial.getModel(),
                    (DefaultTableModel) tablaMesociclosCompetitiva.getModel(), fechaInicio, fechaFin, macrociclo);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCalcularSemanasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularSemanasActionPerformed
        this.control.calcularSemanas(this, this.pickerInicio, this.pickerFin, this.campoTextoTotalSemanas);
    }//GEN-LAST:event_btnCalcularSemanasActionPerformed

    private void btnAnadirGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirGeneralActionPerformed
        this.control.agregarFilaTabla((DefaultTableModel) this.tablaMesociclosGeneral.getModel());
    }//GEN-LAST:event_btnAnadirGeneralActionPerformed

    private void btnEliminarGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarGeneralActionPerformed
        this.control.eliminarFilaTabla(this, this.tablaMesociclosGeneral);
    }//GEN-LAST:event_btnEliminarGeneralActionPerformed

    private void btnAnadirEspecialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirEspecialActionPerformed
        this.control.agregarFilaTabla((DefaultTableModel) this.tablaMesociclosEspecial.getModel());
    }//GEN-LAST:event_btnAnadirEspecialActionPerformed

    private void btnEliminarEspecialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEspecialActionPerformed
        this.control.eliminarFilaTabla(this, tablaMesociclosEspecial);
    }//GEN-LAST:event_btnEliminarEspecialActionPerformed

    private void btnAnadirCompetitivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirCompetitivaActionPerformed
        this.control.agregarFilaTabla((DefaultTableModel) this.tablaMesociclosCompetitiva.getModel());
    }//GEN-LAST:event_btnAnadirCompetitivaActionPerformed

    private void btnEliminarCompetitivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCompetitivaActionPerformed
        this.control.eliminarFilaTabla(this, tablaMesociclosCompetitiva);
    }//GEN-LAST:event_btnEliminarCompetitivaActionPerformed

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
            java.util.logging.Logger.getLogger(CrearMacrociclo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearMacrociclo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearMacrociclo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearMacrociclo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearMacrociclo(Operacion.ACTUALIZAR).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnadirCompetitiva;
    private javax.swing.JButton btnAnadirEspecial;
    private javax.swing.JButton btnAnadirGeneral;
    private javax.swing.JButton btnCalcularSemanas;
    private javax.swing.JButton btnEliminarCompetitiva;
    private javax.swing.JButton btnEliminarEspecial;
    private javax.swing.JButton btnEliminarGeneral;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JTextField campoTextoPorcentajeCompetitivo;
    private javax.swing.JTextField campoTextoPorcentajeCompetitivoB;
    private javax.swing.JTextField campoTextoPorcentajeEspecial;
    private javax.swing.JTextField campoTextoPorcentajeGeneral;
    private javax.swing.JTextField campoTextoPorcentajePrecompetitiva;
    private javax.swing.JTextField campoTextoPorcentajePreparativo;
    private javax.swing.JTextField campoTextoSemanasCompetitivo;
    private javax.swing.JTextField campoTextoSemanasCompetitivoB;
    private javax.swing.JTextField campoTextoSemanasEspecial;
    private javax.swing.JTextField campoTextoSemanasGeneral;
    private javax.swing.JTextField campoTextoSemanasPrecompetitiva;
    private javax.swing.JTextField campoTextoSemanasPreparativo;
    private javax.swing.JTextField campoTextoStatus;
    private javax.swing.JTextField campoTextoTotalSemanas;
    private javax.swing.JComboBox<String> comboBoxDeportes;
    private javax.swing.JComboBox<String> comboBoxEntrenadoresAuxiliares;
    private javax.swing.JComboBox<String> comboBoxJefesRamas;
    private javax.swing.JComboBox<String> comboBoxMetodologos;
    private javax.swing.JComboBox<Rama> comboBoxRamas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.github.lgooddatepicker.components.DatePicker pickerFin;
    private com.github.lgooddatepicker.components.DatePicker pickerInicio;
    private javax.swing.JScrollPane scrollPaneTablaCompetitiva;
    private javax.swing.JScrollPane scrollPaneTablaEspecial;
    private javax.swing.JScrollPane scrollPaneTablaGeneral;
    private javax.swing.JTable tablaMesociclosCompetitiva;
    private javax.swing.JTable tablaMesociclosEspecial;
    private javax.swing.JTable tablaMesociclosGeneral;
    // End of variables declaration//GEN-END:variables
}
