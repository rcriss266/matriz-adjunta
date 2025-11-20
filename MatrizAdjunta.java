import java.util.Scanner;

public class MatrizAdjunta {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double[][] m = new double[3][3];

        
        System.out.println("Ingresa los 9 valores de la matriz:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("m[" + i + "][" + j + "]: ");
                m[i][j] = sc.nextDouble();
            }
        }

        
        double[][] adj = adjunta3x3(m);

        
        System.out.println("\nMatriz Adjunta:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%8.2f", adj[i][j]);
            }
            System.out.println();
        }
    }

   
    public static double[][] adjunta3x3(double[][] m) {
        double[][] adj = new double[3][3];

        adj[0][0] =  (m[1][1] * m[2][2] - m[1][2] * m[2][1]);
        adj[0][1] = -(m[1][0] * m[2][2] - m[1][2] * m[2][0]);
        adj[0][2] =  (m[1][0] * m[2][1] - m[1][1] * m[2][0]);

        adj[1][0] = -(m[0][1] * m[2][2] - m[0][2] * m[2][1]);
        adj[1][1] =  (m[0][0] * m[2][2] - m[0][2] * m[2][0]);
        adj[1][2] = -(m[0][0] * m[2][1] - m[0][1] * m[2][0]);

        adj[2][0] =  (m[0][1] * m[1][2] - m[0][2] * m[1][1]);
        adj[2][1] = -(m[0][0] * m[1][2] - m[0][2] * m[1][0]);
        adj[2][2] =  (m[0][0] * m[1][1] - m[0][1] * m[1][0]);

        return adj;
    }
}
