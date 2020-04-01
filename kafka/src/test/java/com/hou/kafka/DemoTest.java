package com.hou.kafka;

import org.junit.Test;

public class DemoTest {

    @Test
    public void test01(){
        final byte[] bytes1 = "name".getBytes();
        byte x[] = {-0x01, -0x01, -0x02, -0x71, -0x2b,-0x5f, -0x30};
        System.out.println(charAt(x, 2));

    }

    public static char charAt(byte[] value, int index) {
        index <<= 1;
        if (index < 0 || index >= value.length) {
            throw new StringIndexOutOfBoundsException(index);
        }
        /**
         * value[index] & 0xff  :  结果为int,即byte -> int
         * 16进制数 0xff 二进制就是11111111 ,高位都为0
         * 因为&操作中，超过0xff的部分，全部都会变成0，而对于0xff以内的数据，
         * 它不会影响原来的值,取其最低8位,即一个字节的值,此操作也能保证负数补码不变
         */
        System.out.println(value[index]);
        final int i = value[index] & 0xff;
        System.out.println(i);
        return (char)i;
    }
}
