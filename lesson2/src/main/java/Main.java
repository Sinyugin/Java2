public class Main {

    public static int size = 4;

    public static void main(String[] args) {
        try {
        String[][] myArray = new String[size][size];

            myArray[0][0] = "1";
            myArray[0][1] = "2";
            myArray[0][2] = "3";
            myArray[0][3] = "4";
            myArray[1][0] = "5";
            myArray[1][1] = "6";
            myArray[1][2] = "7";
            myArray[1][3] = "8";
            myArray[2][0] = "9";
            myArray[2][1] = "10";
            myArray[2][2] = "11";
            myArray[2][3] = "12";
            myArray[3][0] = "fghy"; //другой формат данных
            myArray[3][1] = "14";
            myArray[3][2] = "15";
            myArray[3][3] = "16";
            myArray[7][5] = "17"; //лишний элемент массива для проверки исключения

            checkArray(myArray);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Превышен размер массива");
            throw new MyArraySizeException();


        } catch (MyArrayDataException e) {
            MyArrayDataException myArrayDataException = new MyArrayDataException();
            myArrayDataException.message();
            e.printStackTrace();
        }
    }

    public static int checkArray(String[][] myArray) throws MyArrayDataException {

        int summa = 0;
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                    try {
                        summa = summa + Integer.parseInt(myArray[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException();
                    }
            }
        }

        System.out.println("Сумма всех элементов равна " + summa);
        return (summa);
    }
}
