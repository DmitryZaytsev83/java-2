package ru.dmitryzaytsev.lesson2;

public class MainClass {
    public static void main(String[] args) {
        String[][] arr = new String[][]{
                {"12", "34", "56"},
                {"13", "24", "q35", "46"},
                {"14", "25", "36", "47"},
                {"15", "26", "37", "i56"},
        };
        try {
            int result = sumArray(arr);
            System.out.println("Сумма всех элементов массива: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Неправильный размер массива");
        } catch (MyArrayDataException e) {
            System.out.println(e.toString());
        }
    }

    private static int sumArray(String[][] arr) {
        int sum = 0;
        if (arr.length != 4) throw new MyArraySizeException();
        for (String[] strings : arr) {
            if (strings.length != 4) throw new MyArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, arr[i][j]);
                }
            }
        }
        return sum;
    }
}

class MyArraySizeException extends RuntimeException {

}

class MyArrayDataException extends RuntimeException {
    int x;
    int y;
    String val;

    public MyArrayDataException(int x, int y, String val) {
        super("Неверный тип данных " + val + " в ячейке со строкой " + x + " и столбцом " + y);
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
