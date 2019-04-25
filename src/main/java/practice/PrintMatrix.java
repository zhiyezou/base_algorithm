package practice;

public class PrintMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        //System.out.println(matrix[0].length);
        int x1 = 0;
        int y1 = 0;
        int x2 = matrix.length - 1;
        int y2 = matrix[0].length - 1;

        //printMatrix(matrix);
        //rotate(matrix);
        //System.out.println("=========");
        //printMatrix(matrix);
        zigPrint(matrix);
    }

    public static void rotateEdge(int[][] arr, int x1, int y1, int x2, int y2) {
        int times = y2 - y1;
        //int tmp = 0;

        for (int i = 0; i < times; i++) {
            int tmp = arr[x1][y1 + i];
            arr[x1][y1 + i] = arr[x2 - i][y1];
            arr[x2 - i][y1] = arr[x2][y2 - i];
            arr[x2][y2 - i] = arr[x1 + i][y2];
            arr[x1 + i][y2] = tmp;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR < dR) {
            rotateEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    public static void zigPrint(int[][] arr) {
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;
        int xend = arr.length - 1;
        int yend = arr[0].length - 1;

        boolean flag = false;
        while (y1 < yend + 1 && x2 < xend + 1) {
            zprint(arr, x1, y1++, x2++, y2, flag);

            flag = !flag;
        }

        if (y1 == yend) {
            zprint(arr, x1++, y1, x2++, y2, flag);
            flag = !flag;
        }

        if (x2 == xend) {
            zprint(arr, x1, y1++, x2, y2--, flag);
            flag = !flag;
        }

        if (y1 == yend && x2 == xend) {
            zprint(arr, x1, y1++, x2, y2--, flag);
            flag = !flag;
        }
    }

    public static void zprint(int[][] arr, int x1, int y1, int x2, int y2, boolean flag) {
        if (flag) {
            while (x1 < x2 + 1) {
                System.out.println(arr[x1++][y1--]);
            }

        } else {
            while (x2 > -1) {
                System.out.println(arr[x2--][y2++]);
            }
        }
    }
}
