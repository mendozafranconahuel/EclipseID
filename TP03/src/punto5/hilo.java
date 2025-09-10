package punto5;

public class hilo extends Thread {
	private int root;

	public hilo(int root) {
		this.root = root;
	}

	public void run() {
		double resultado = metodo.SumRootN(root);
        System.out.println("root = " + root + " => resultado = " + resultado);
		
	}

}