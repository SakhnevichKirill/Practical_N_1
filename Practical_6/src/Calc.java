import java.util.ArrayList;

public class Calc {
    private String record;
    private char[] signs;
    private boolean flag;
    private double result;
    private final double e = 2.7;
    
    private String first = "";
    private String second = "";
    private String operand = "";


    Calc(){

    }

    Calc(String record){
        this.record = record;
        flag = tryCalc(record);
    }

    private boolean tryCalc(String record){
        for (int i = 0; i<(record.length()); i++){
            if ((record.charAt(i) >= '0' && record.charAt(i) <= '9') || record.charAt(i) == 'e' || record.charAt(i) == '.') {
                if (record.charAt(i) == 'e'){
                    if (!operand.equals("") && !second.equals("")) {
                        second = String.valueOf(Double.parseDouble(second) * e);
                    }
                    else if (!operand.equals(""))
                        second = second + e;
                    else {
                        first = first + e;
                    }
                }
                else{
                    if (!operand.equals("")) {
                        second = second + record.charAt(i);
                    } else {
                        first = first + record.charAt(i);
                    }
                }
//            display.setText(first + operand + second);
            }
            else if (record.charAt(i) == 'C') {
                first = operand = second = "";

//            display.setText(first + operand + second);
            }
            else {
                if (operand.equals("") || second.equals(""))
                    if (first.isEmpty()) {
                        first = String.valueOf(record.charAt(i));
                    } else if (record.charAt(i) == '%'){
                        result = (Double.parseDouble(first)/100);
                        if ((i+1)<(record.length()))
                            if ((record.charAt(i+1) >= '0' && record.charAt(i+1) <= '9') && (record.charAt(i+1) == 'e'))
                                operand = "x";
                    }
                    else {
                        operand = String.valueOf(record.charAt(i));
                    }
                else {
                    if(!switchOperand()){
                        second = first = operand =  "";
                        result = 0;
                        return false;
                    }
                    first = Double.toString(result);
                    second = operand =  "";
                    i--;
                }

            }
        }

        if (operand.equals("") || second.equals("")) return true;
        else {
            if(!switchOperand()){
                second = first = operand =  "";
                result = 0;
                return false;
            }
            first = Double.toString(result);
            second = operand =  "";
        }
        return true;
    }

    private boolean switchOperand (){
        result = switch (operand) {
            case "+" -> (Double.parseDouble(first) + Double.parseDouble(second));
            case "-" -> (Double.parseDouble(first) - Double.parseDouble(second));
            case "/" -> (Double.parseDouble(first) / Double.parseDouble(second));
            case "x" -> (Double.parseDouble(first) * Double.parseDouble(second));
            case "*" -> (Double.parseDouble(first) * Double.parseDouble(second));
            default -> 1.79769e+308;
        };
        if (result == 1.79769e+308)
            return false;
        return true;
    }

    public void setRecord(String record){
        this.record = record;
    }

    public boolean getFlag(){
        return flag;
    }

    public String getRecord(){
        return record;
    }

    public String getResult(){
        if (!flag)
            return "Ошибка! Неизвестный символ.";
        else
            return "= " + result;
    }

}


//       record.indexOf()
//        for  char record = 0;
//        (int i = 0; i<record.length(); i++) {
//            temp.trim();
//            if (Character.isDigit(signs[i]))
//                temp += signs[i];
//            else if (signs[i] == 'e')
//                temp += e;
//            else if (signs[i] == '.')
//                temp += '.';
//            else if (isSign(i)){
//                if (record != 0){
//                    if (record == '+')
//                        result += Double.parseDouble(temp);
//                    else if (record == '-')
//                        result -= Double.parseDouble(temp);
//                    else if (record == '/')
//                        result /= Double.parseDouble(temp);
//                    else if (record == '*')
//                        result *= Double.parseDouble(temp);
//                    else if (record == '%')
//                        result *= Double.parseDouble(temp);
//                    else if (Character.isLetter(record)){
//                        result = 0;
//                        return false;
//                    }
//                    temp = " ";
//                    record = 0;
//                }
//                else
//                    record = signs[i];
//            }
//        }


//
//    if (signs[i] == '+')
//    result += Double.parseDouble(temp);
//                else if (signs[i] == '-')
//    result -= Double.parseDouble(temp);
//                else if (signs[i] == '/')
//    result /= Double.parseDouble(temp);
//                else if (signs[i] == '*')
//    result *= Double.parseDouble(temp);
//                else if (signs[i] == '%')
//    result *= Double.parseDouble(temp);
//                else if (Character.isLetter(signs[i])){
//        result = 0;
//        return false;
//    }
//    temp = null;

