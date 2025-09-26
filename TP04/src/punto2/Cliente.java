package punto2;

public class Cliente {
	private int id_cliente;
	private Panaderia panaderia;
	
	public Cliente(int id_cliente, Panaderia panaderia) {
		this.id_cliente = id_cliente;
		this.panaderia = panaderia;
	}
		
	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

//////////////////////////////////////////////////////////////////
	public void run() {
		panaderia.camprar(id_cliente);
		panaderia.salir(id_cliente);
	}
}