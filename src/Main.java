import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Main extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBoxArbol;
	private JButton btnEliminarArbol;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 269);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblArboles = new JLabel("ARBOLES");
		lblArboles.setFont(new Font("Calibri", Font.BOLD, 24));
		lblArboles.setHorizontalAlignment(SwingConstants.CENTER);
		
		comboBoxArbol = new JComboBox();
		comboBoxArbol.setFont(new Font("Calibri", Font.PLAIN, 11));
		
		JButton btnInsertarArbol = new JButton("Insertar Arbol");
		btnInsertarArbol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirFormularioArbol();
			}
		});
		
		btnEliminarArbol = new JButton("Eliminar Arbol");
		btnEliminarArbol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = comboBoxArbol.getSelectedIndex();
				eliminar(index);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(160)
					.addComponent(lblArboles, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
					.addGap(150))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(127, Short.MAX_VALUE)
					.addComponent(comboBoxArbol, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
					.addGap(116))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(113)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEliminarArbol, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnInsertarArbol, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE))
					.addGap(102))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblArboles, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(comboBoxArbol, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(48)
					.addComponent(btnEliminarArbol, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnInsertarArbol, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(27))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void abrirFormularioArbol() {
		FormularioArbol hija = new FormularioArbol(this, "Formulario" ,true);
		hija.setVisible(true);
	}

	public void aniadir(Arbol arbol){
		this.comboBoxArbol.addItem(arbol.getNombre() + " - " + arbol.getZona() + " - " + arbol.getAltura());
	}
	
	public void eliminar(int i){
		this.comboBoxArbol.removeItemAt(i);
	}
}
