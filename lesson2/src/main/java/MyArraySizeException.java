public class MyArraySizeException extends ArrayIndexOutOfBoundsException{

    public MyArraySizeException() {

    }
    void message (){
        System.out.println("Превышен размер массива.");
    }
}
