public class NegativeSQRTInputException extends RuntimeException{
    public NegativeSQRTInputException(String massage){
        super(massage);
    }
    public NegativeSQRTInputException(String massage, Exception cause){
        super(massage,cause);
    }
}
