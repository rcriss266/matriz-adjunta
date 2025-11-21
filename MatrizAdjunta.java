import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MatrizAdjunta {

    public static void main(String[] args) {
        double[][] m = new double[3][3];

        try {
            Scanner sc = new Scanner(new File("matriz.txt"));

            // Lee los numeros del archivo
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (sc.hasNextDouble()) {
                        m[i][j] = sc.nextDouble();
                    } else {
                        System.out.println("El archivo no tiene suficientes números.");
                        return;
                    }
                }
            }
            sc.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        // Calcula
        double[][] adj = adjunta3x3(m);

        // Imprime la matriz original
        System.out.println("Matriz original:");
        imprimirMatriz(m);

        // Imprime la adjunta
        System.out.println("\nMatriz adjunta:");
        imprimirMatriz(adj);
    }

    // Función para calcular la  adjunta
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

    // imprime la   matriz
    public static void imprimirMatriz(double[][] matriz) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%8.2f", matriz[i][j]);
            }
            System.out.println();
        }
    }
}

