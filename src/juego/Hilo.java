package juego;

import javax.swing.JOptionPane;

public class Hilo extends Thread {
	private VentanaPrincipal ventana;
	private boolean running;
	private boolean saltando, subiendo, bajando;
	private int pasos;
	private int pasosCambioSprite;

	public Hilo(VentanaPrincipal frame) {
		this.ventana = frame;
		running = true;
		this.start();
		saltando = false;
		subiendo = false;
		bajando = false;
		pasos = 0;
		pasosCambioSprite = 0;
	}

	public void run() {
		while (running) {
			ventana.actualizarPuntos();
			ventana.moverCactus();
			ventana.moverAlcantarilla();
			ventana.moverFondo();
			ventana.moverFondo2();
			ventana.movernube();
			ventana.movernube2();
			ventana.moverFondo4();
			if (saltando) {
				pasos++;
				if (pasos > 9) { // estado suspendido
					subiendo = false;
				}
				if (pasos > 15) { // transicion de suspendido a bajando
					bajando = true;
				}
				if (pasos > 24) {// transicion de bajando a inicial

					bajando = false;
					saltando = false;
					pasos = 0;
				}
				if (subiendo) { // estado subiendo
					ventana.subirDinosaurio();
				}
				if (bajando) {
					ventana.bajarDinosaurio();
				}
			}
			pasosCambioSprite++;
			if (pasosCambioSprite % 3 == 0) {
				ventana.cambiarSpriteDinosaurio();
				pasosCambioSprite = 0;
			}
			if (ventana.colision()) {
				JOptionPane.showMessageDialog(null, "\n  Te ha Pillado Koopa!! \n  Has conseguido.. \n  TOTAL: 00" + ventana.getPuntos() + " puntos.\n\n");
				this.parar();
				ventana.estadoInicial();
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void parar() {
		running = false;
	}
	public void iniciarSalto() {
		if (!saltando) {
			saltando = true;
			subiendo = true;
		}
	}
}