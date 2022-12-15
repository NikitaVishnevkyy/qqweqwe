import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner ad = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        String vir = ad.nextLine();
        char znac;
        String[] data;
        if (vir.contains(" + ")) {
            data = vir.split(" \\+ ");
            znac = '+';
        } else if (vir.contains(" - ")) {
            data = vir.split(" - ");
            znac = '-';
        } else if (vir.contains(" * ")) {
            data = vir.split(" \\* ");
            znac = '*';
        } else if (vir.contains(" / ")) {
            data = vir.split(" / ");
            znac = '/';
        }else{
            throw new Exception("throws Exception");
        }
        if(data[0].length() > 10 || data[1].length() > 10) throw new Exception("throws Exception");
        if (znac == '*' || znac == '/') {
            if (data[1].contains("\"")) throw new Exception("throws Exception");
        }
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace("\"", "");
        }

        if (znac == '+') {
            String result = data[0] + data[1];
            if(isLongString(result)){
                result = result.substring(0, 40)+"...";
            }
            System.out.println("\""+result+"\"");
        } else if (znac == '*') {
            int multiplier = Integer.parseInt(data[1]);
            if(multiplier<1 || multiplier > 10) throw new Exception("throws Exception");
            String result = "";
            for (int i = 0; i < multiplier; i++) {
                result+=data[0];
            }
            if(isLongString(result)){
                result = result.substring(0, 40)+"...";
            }
            System.out.println("\""+result+"\"");
        } else if (znac == '-') {
            int index = data[0].indexOf(data[1]);
            if(index == -1){
                System.out.println("\""+data[0]+"\"");
            }else{
                String result = data[0].substring(0, index);
                result+=data[0].substring(index+data[1].length());
                if(isLongString(result)){
                    result = result.substring(0, 40)+"...";
                }
                System.out.println("\""+result+"\"");
            }
        }else{
            int divider = Integer.parseInt(data[1]);
            if(divider<1 || divider > 10) throw new Exception("throws Exception");
            int newLen = data[0].length()/divider;
            String result = data[0].substring(0,newLen);
            if(isLongString(result)){
                result = result.substring(0, 40)+"...";
            }
            System.out.println("\""+result+"\"");
        }


    }
    static boolean isLongString(String val){
        return val.length() > 40;
    }

}

