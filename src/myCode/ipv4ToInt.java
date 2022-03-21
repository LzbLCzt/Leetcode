package myCode;

/**
(1)将string类型的ipv4转为一个int32；
 (2)将一个int转为二进制String
 */
public class ipv4ToInt {
    public static void main(String[] args) {
        int intt = ipvToInt("255.255.255.255");
        System.out.println(intt);

        System.out.println(intToBinary(123));

        System.out.println(intToIpv(-1));
    }

    //(1)将string类型的ipv4转为一个int32；
    public static int ipvToInt(String ip){
        String[] data = ip.split("\\.");
        int ans = 0;
        for(int i = 0; i < data.length; i++){
            int temp = Integer.parseInt(data[i]) << (8 * i);

            ans = ans | temp;
        }

        return ans;
    }

    // (2)将一个int转为二进制String
    public static String intToBinary(int num){
        return Integer.toBinaryString(num);
    }

    //（3）将int32转为String类型的ipv4
    public static String intToIpv(int num){
        String str = Integer.toBinaryString(num);
        String ans = "";

        for(int i = 0; i < 4; i++){
            String tempStr = str.substring(i * 8, (i+1) * 8);
            int tempInt = Integer.parseInt(tempStr,2);
            ans += tempInt + ".";
        }
        return ans.substring(0, ans.length() - 1);
    }
}
