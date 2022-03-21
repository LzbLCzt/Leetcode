package Stream;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ByteStream {
    public static void main(String[] args) {
//        String str = new String("我是人");
        String str = new String("123");
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);    //字符 转为 字节（utf-8）
        System.out.println(Arrays.toString(bytes));
        String s = new String(bytes, StandardCharsets.UTF_8);   //字节数组 转为 字符
        System.out.println(s);

    }
}
