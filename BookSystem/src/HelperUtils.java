public class HelperUtils {
    public static Boolean isNull(Integer intToCkeck){
        return  intToCkeck==null;
    }

    public static Boolean isNull(String strToCkeck){
        return  strToCkeck==null;
    }

    public static Boolean checkIfStrIsBlankOrEmpty(String strToCkeck){
        return  strToCkeck.isEmpty() || strToCkeck.isBlank();
    }
}
