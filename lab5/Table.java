/**
 * Simple mockup for re-creating T1 from lab 5.
 */
public class Table {
    int columnCount;
    int rowCount;
    String[] rowHeader;
    int[][] rows;

    public Table(String[] columnTitles) {
        rowHeader = columnTitles;
        rowCount = 0;
        columnCount = columnTitles.length;
        rows = new int[10][2]; // For now, fix-sized arrays
    }

    public void addRow(int[] rowValues) {
        rows[rowCount] = rowValues;
        rowCount += 1;
    }

    public void printTable() {
        for (String title : rowHeader) {
            System.out.print(title + " ");
        }
        System.out.println();
        for (int[] row: rows) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String[] columnTitles = {"x", "y"};
        Table T1 = new Table(columnTitles);
        T1.addRow(new int[]{2, 5});
        T1.addRow(new int[]{8, 3});
        T1.addRow(new int[]{13, 7});
        T1.printTable();
    }
}
