import java.util.Random;

public class Matrix {
    private Random random = new Random();
    public Matrix(int size) {
        this.SIZE = size;
        matrix = new int[SIZE][SIZE];
    }
    public void fill() { // Fill with random data
        for (int row = 0; row < SIZE; ++row) 
            for (int col = 0; col < SIZE; ++col) 
                matrix[row][col] = 1 + random.nextInt(20);
    }
    public int get(int row, int col) {return matrix[row][col];}
    public void set(int row, int col, int value) {matrix[row][col] = value;}
    public Matrix multiply(Matrix rhs) {
        Matrix result = new Matrix(SIZE);
        for (int row = 0; row < SIZE; row++) 
            for (int col = 0; col < SIZE; col++) 
                result.set(row, col, multiplyCell(rhs, row, col));
        return result;
    }
    private int multiplyCell(Matrix rhs, int row, int col) {
        int cell = 0;
        for (int i = 0; i < SIZE; i++)
            cell += matrix[row][i] * rhs.get(i, col);
        return cell;
    }        
    public int xor() { // Ensure all of the product is used
        int result = 0;
        for (int row = 0; row < SIZE; ++row) 
            for (int col = 0; col < SIZE; ++col) 
                result ^= matrix[row][col];
        return result;
    }

    private int[][] matrix;
    public final int SIZE;
}
