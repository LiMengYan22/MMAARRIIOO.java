package juego;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class VentanaPrincipal extends JFrame {
	private JLabel lblLogo;
	private JLabel lblFondo;
	private JLabel lblFondo2;
	private JLabel lblFondo3;
	private JLabel lblFondo4;
	private JPanel contentPane;
	private JLabel lblDinosaurio;
	private JLabel lblCactus;
	private JLabel lblnube;
	private JLabel lblnube2;
	private JLabel lblAlcantarilla;
	private static Hilo hilo;
	private JLabel lblPuntos;
	private int puntos;
	private int sprite;
	private ArrayList spritesDinosaurio = new ArrayList<>();
	private ArrayList spritesEnemigo = new ArrayList<>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
					hilo = new Hilo(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaPrincipal() {
		setTitle("SUPER MARIO BROS");
		puntos = 0;
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_SPACE) {
					hilo.iniciarSalto();
				}
			}
		});
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 1000, 280);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		// contentPane.setBackground(Color.GRAY);
		this.setContentPane(contentPane);

		
		lblAlcantarilla = new JLabel();
		lblAlcantarilla.setIcon(new ImageIcon(this.getClass().getResource("/img/Alcantarilla.png")));
		lblAlcantarilla.setBounds(0, 192, 60, 60);
		contentPane.add(lblAlcantarilla);
		
		
		sprite = 0;
		spritesDinosaurio.add(new ImageIcon(this.getClass().getResource("/img/luigui1G.png")));
		spritesDinosaurio.add(new ImageIcon(this.getClass().getResource("/img/luigui2G.png")));
		lblDinosaurio = new JLabel();
		lblDinosaurio.setIcon(new ImageIcon(this.getClass().getResource("/img/luigui1G.png")));
		lblDinosaurio.setBounds(130, 160, 53, 59);
		contentPane.add(lblDinosaurio);

		spritesEnemigo.add(new ImageIcon(this.getClass().getResource("/img/koopa1.png")));
		spritesEnemigo.add(new ImageIcon(this.getClass().getResource("/img/koopa2.png")));
		lblCactus = new JLabel();
		lblCactus.setIcon(new ImageIcon(this.getClass().getResource("/img/koopa1.png")));
		lblCactus.setBounds(861, 160, 53, 59);
		contentPane.add(lblCactus);
		
	
		
		lblnube = new JLabel();
		lblnube.setIcon(new ImageIcon(this.getClass().getResource("/img/nube.png")));
		lblnube.setBounds(90, 50, 60, 60);
		contentPane.add(lblnube);
		
		
		lblnube2 = new JLabel();
		lblnube2.setIcon(new ImageIcon(this.getClass().getResource("/img/nube.png")));
		lblnube2.setBounds(90, 70, 60, 60);
		contentPane.add(lblnube2);
		
		
		
			lblLogo = new JLabel();
		lblLogo.setIcon(new ImageIcon(this.getClass().getResource("/img/Logo.png")));
		lblLogo.setBounds(10, 5, 100, 100);
		contentPane.add(lblLogo); 

		lblPuntos = new JLabel("0");
		lblPuntos.setBounds(550, 95, 100, 40);
		contentPane.add(lblPuntos);
		
		
	
		

		lblFondo = new JLabel();
		lblFondo.setIcon(new ImageIcon(this.getClass().getResource("/img/fondo.png")));
		lblFondo.setBounds(0, 0, 1000, 270);
		contentPane.add(lblFondo);
		
		lblFondo4 = new JLabel();
		lblFondo4.setIcon(new ImageIcon(this.getClass().getResource("/img/fondoTRANS.png")));
		lblFondo4.setBounds(0, 0, 1000, 270);
		contentPane.add(lblFondo4);
			
		
		lblFondo2 = new JLabel();
		lblFondo2.setIcon(new ImageIcon(this.getClass().getResource("/img/fondo2.png")));
		lblFondo2.setBounds(0, 0, 2000, 270);
		contentPane.add(lblFondo2);
		
		lblFondo3 = new JLabel();
		lblFondo3.setIcon(new ImageIcon(this.getClass().getResource("/img/fondo2.png")));
		lblFondo3.setBounds(0, 0, 1000, 270);
		contentPane.add(lblFondo3);
	
		
		
		

		ImageIcon ii = new ImageIcon(this.getClass().getResource("/img/logicon.png"));
		Image image = ii.getImage();
		this.setIconImage(image);
	}

	public void moverCactus() {
		lblCactus.setLocation(lblCactus.getX() - 11, lblCactus.getY());
		if (lblCactus.getX() + lblCactus.getWidth() < 0) {
			lblCactus.setLocation(1000, lblCactus.getY());
		}
	}
	public void moverAlcantarilla() {
		lblAlcantarilla.setLocation(lblAlcantarilla.getX() - 6, lblAlcantarilla.getY());
		if (lblAlcantarilla.getX() + lblAlcantarilla.getWidth() < 0) {
			lblAlcantarilla.setLocation(1000, lblAlcantarilla.getY());
		}
	}
	public void moverFondo() {
		lblFondo.setLocation(lblFondo.getX() - 4, lblFondo.getY());
		if (lblFondo.getX() + lblFondo.getWidth() < 0) {
			lblFondo.setLocation(1000, lblFondo.getY());
		}
	}
	public void moverFondo2() {
		lblFondo2.setLocation(lblFondo2.getX() - 2, lblFondo2.getY());
		if (lblFondo2.getX() + lblFondo2.getWidth() < 0) {
			lblFondo2.setLocation(1000, lblFondo2.getY());
		}
	}
	public void moverFondo4() {
		lblFondo4.setLocation(lblFondo4.getX() - 1, lblFondo4.getY());
		if (lblFondo4.getX() + lblFondo4.getWidth() < 0) {
			lblFondo4.setLocation(1000, lblFondo4.getY());
		}
	}
	
	public void movernube() {
		lblnube.setLocation(lblnube.getX() - 4, lblnube.getY());
		if (lblnube.getX() + lblnube.getWidth() < 0) {
			lblnube.setLocation(1000, lblnube.getY());
		}
	}
	
	public void movernube2() {
		lblnube2.setLocation(lblnube2.getX() - 1, lblnube2.getY());
		if (lblnube2.getX() + lblnube2.getWidth() < 0) {
			lblnube2.setLocation(1000, lblnube2.getY());
		}
	}
	
	
	

	public void subirDinosaurio() {
		lblDinosaurio.setLocation(lblDinosaurio.getX(), lblDinosaurio.getY() - 13);
	}

	public void bajarDinosaurio() {
		lblDinosaurio.setLocation(lblDinosaurio.getX(), lblDinosaurio.getY() + 13);
	}

	public boolean colision() {
		if (lblCactus.getX() < lblDinosaurio.getX() + lblDinosaurio.getWidth()
				&& lblDinosaurio.getX() < lblCactus.getX() + lblCactus.getWidth()
				&& lblDinosaurio.getY() + lblDinosaurio.getHeight() > lblCactus.getY()) {		
			return true;					
		}
		return false;
	}

	public void estadoInicial() {
		lblDinosaurio.setLocation(130, 160);
		lblCactus.setLocation(861, 160);
		//lblFondo.setLocation(1000, 250);
		puntos = 0;
		hilo = new Hilo(this);
	}

	public void cambiarSpriteDinosaurio() {
		sprite++;
		sprite = sprite % 2;
		lblDinosaurio.setIcon((Icon) spritesDinosaurio.get(sprite));
		lblCactus.setIcon((Icon) spritesEnemigo.get(sprite));
	}

	public void actualizarPuntos() {
		puntos++;
		lblPuntos.setText("Puntos: 00" + puntos + "");
		lblPuntos.setLocation(120, 25);
		lblPuntos.setSize(190, 55);
		lblPuntos.setFont(new Font("Consolas", Font.BOLD, 18));
	}

	public int getPuntos() {
		return puntos;
	}
}