package punto5;

public class metodo {
	
	public static double SumRootN(int root) {
        double result = 0;
        for (int i = 1; i < 10000000; i++) {
            result += Math.exp(Math.log(i) / root);
        }
        return result;
    }
	
}