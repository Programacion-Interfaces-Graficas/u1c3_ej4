package u1c3_ej4;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ejemplo4 {
	//Crear un arreglo de ciudades
	private String [] ciudades= {"Quito","Guayaquil","Cuenca","Ambato"
								,"Riobamba","Esmeraldas","Loja","Manta"
								,"Otavalo","Ibarra","Tulcan","Puyo"};

	private JFrame ventana;
	private JLabel etiqueta;
	private JScrollPane scroll;
	//Declarar la clase generica JList
	private JList<String> lista;
	public ejemplo4() {
		//Crear un nuevo contenedor JFrame
		ventana=new JFrame("Ejemplo 3");
		//Especificar FlowLayout como administrador de dise;o
		ventana.getContentPane().setLayout(new FlowLayout());
		//Asignar el tamaño inicial de la ventana
		ventana.setSize(400,150);
		//Terminar el programa cuando el usuario cierre la ventana
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Crear la etiqueta 
		etiqueta=new JLabel("Seleccione una Ciudad");
		//Crear el componente JList cargando los datos de arreglo
		lista=new JList<String>(ciudades);
		//Agregar el modo de seleccion 
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//Agregar a la List a un Scroll panel
		scroll=new JScrollPane(lista);
		//Establecer el tamaño del panel de desplazamiento.
		scroll.setPreferredSize(new Dimension(120, 90)); 
		//Agregar la seleccionn del Listener para el JList
		lista.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				// Obtener el index de cada item seleccionado
				int index=lista.getSelectedIndex();
				//Mostrar en la etiqueta el item selecionado
				if(index!=-1) {
					etiqueta.setText("Ciudad selecionada:"+ciudades[index]);
				}else {
					etiqueta.setText("Aun no ha selecionado");
				}
				
			}
			
		});
		//Agregar los componentes en el contenedor
		ventana.add(scroll);
		ventana.add(etiqueta);
		//Mostrar la ventana
		ventana.setVisible(true);

		
	}
	public static void main(String[] args) {
		//Crea la ventana en el subproceso de entrega de eventos
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ejemplo4();
			}
			
		});

	}
	

}
