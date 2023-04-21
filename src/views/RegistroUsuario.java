package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import controllers.ReservasController;
import controllers.UsuarioController;
import model.entities.FormaPagamento;
import model.entities.HashPassword;
import model.entities.Reservas;
import model.entities.Usuario;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.text.Format;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Toolkit;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.beans.PropertyChangeEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.DropMode;


@SuppressWarnings("serial")
public class RegistroUsuario extends JFrame {

	private JPanel contentPane;
	public static JTextField txtLogin;
	public static JTextField txtSenha;
	int xMouse, yMouse;
	private JLabel labelExit;
	private JLabel labelAtras;
	
	private UsuarioController usuarioController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroUsuario frame = new RegistroUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws SQLException 
	 */
	public RegistroUsuario() throws SQLException, IOException {
		super("Reserva");
		usuarioController = new UsuarioController();
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistroUsuario.class.getResource("/imagenes/aH-40px.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 560);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		

		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 910, 560);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(SystemColor.textHighlight);
		separator_1_1.setBounds(66, 247, 289, 11);
		separator_1_1.setBackground(SystemColor.textHighlight);
		panel.add(separator_1_1);
		
		JLabel lblCheckOut = new JLabel("LOGIN");
		lblCheckOut.setForeground(SystemColor.textInactiveText);
		lblCheckOut.setBounds(66, 187, 187, 14);
		lblCheckOut.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblCheckOut);
		
		txtLogin = new JTextField();
		txtLogin.setBackground(SystemColor.text);
		txtLogin.setHorizontalAlignment(SwingConstants.LEFT);
		txtLogin.setForeground(Color.BLACK);
		txtLogin.setBounds(66, 212, 289, 33);
		txtLogin.setFont(new Font("Roboto Black", Font.BOLD, 17));
		txtLogin.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel.add(txtLogin);
		txtLogin.setColumns(10);
		
		txtSenha = new JTextField();
		txtSenha.setBackground(SystemColor.text);
		txtSenha.setHorizontalAlignment(SwingConstants.LEFT);
		txtSenha.setForeground(Color.BLACK);
		txtSenha.setBounds(66, 294, 289, 33);
		txtSenha.setFont(new Font("Roboto Black", Font.BOLD, 17));
		txtSenha.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel.add(txtSenha);
		txtSenha.setColumns(10);
		
		JLabel lblValor = new JLabel("SENHA");
		lblValor.setForeground(SystemColor.textInactiveText);
		lblValor.setBounds(66, 269, 196, 14);
		lblValor.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblValor);
		
		JLabel lblTitulo = new JLabel("CADASTRO DE USUARIO");
		lblTitulo.setBounds(105, 60, 221, 42);
		lblTitulo.setForeground(new Color(12, 138, 199));
		lblTitulo.setFont(new Font("Roboto", Font.BOLD, 20));
		panel.add(lblTitulo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(428, 0, 482, 560);
		panel_1.setBackground(new Color(12, 138, 199));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuPrincipal principal = new MenuPrincipal();
				principal.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnexit.setBackground(new Color(12, 138, 199));
			     labelExit.setForeground(Color.white);
			}
		});
		
		JLabel logo = new JLabel("");
		logo.setBounds(167, 195, 150, 161);
		panel_1.add(logo);
		logo.setIcon(new ImageIcon(RegistroUsuario.class.getResource("/imagenes/aH-150px.png")));
		btnexit.setLayout(null);
		btnexit.setBackground(new Color(12, 138, 199));
		btnexit.setBounds(429, 0, 53, 36);
		panel_1.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setForeground(Color.WHITE);
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		JPanel header = new JPanel();
		header.setBounds(0, 0, 910, 36);
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			     
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		panel.add(header);
		
		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuPrincipal meunuPrincipal = new MenuPrincipal();
				meunuPrincipal.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(Color.white);
			     labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(SystemColor.textHighlight);
		separator_1.setBounds(66, 328, 289, 2);
		separator_1.setBackground(SystemColor.textHighlight);
		panel.add(separator_1);
		
		JPanel btnCadastrar = new JPanel();
		btnCadastrar.setLayout(null);
		btnCadastrar.setBackground(SystemColor.textHighlight);
		btnCadastrar.setBounds(66, 370, 289, 35);
		panel.add(btnCadastrar);
		btnCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCadastrar.setBackground(new Color(0, 156, 223));
			}
		
			@Override
			public void mouseExited(MouseEvent e) {
				btnCadastrar.setBackground(SystemColor.textHighlight);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				String hashSenha;
				try {
					String login = txtLogin.getText();
					String senha = txtSenha.getText();
					hashSenha = new HashPassword().criptoPassword(senha);
					
					Usuario usuario = new Usuario(login, hashSenha);
					
					usuarioController.salvar(usuario);
					
					JOptionPane.showMessageDialog(null, "Usuário criado!");
					
					Login loginView = new Login();
					loginView.setVisible(true);
					dispose();
					
				} catch (NoSuchAlgorithmException | SQLException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JLabel lblSeguinte = new JLabel("CADASTRAR");
		lblSeguinte.setBounds(0, 0, 289, 35);
		btnCadastrar.add(lblSeguinte);
		lblSeguinte.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeguinte.setForeground(Color.WHITE);
		lblSeguinte.setFont(new Font("Roboto", Font.PLAIN, 18));
	}
	
	private void salvarReserva() throws SQLException, IOException {
		int uuu = 0;
	}

	//Código que permite movimentar a janela pela tela seguindo a posição de "x" e "y"	
	 private void headerMousePressed(java.awt.event.MouseEvent evt) {
	        xMouse = evt.getX();
	        yMouse = evt.getY();
	    }

	    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
	        int x = evt.getXOnScreen();
	        int y = evt.getYOnScreen();
	        this.setLocation(x - xMouse, y - yMouse);
}
}
