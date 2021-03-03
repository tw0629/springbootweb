package com.tian.aop;

import org.springframework.stereotype.Service;

/**
 * @author David Tian
 * @desc
 * @since 2020-03-21 12:55
 */
@Service("calculator")
public class Calculator implements Arithmetic{

    @Override
    public int add(int var1, int var2) {
        return var1 + var2;
    }

    @Override
    public int sub(int var1, int var2) {
        return var1 - var2;
    }

    @Override
    public int mul(int var1, int var2) {
        return var1 * var2;
    }

    @Override
    public int div(int var1, int var2) {
        return var1 / var2;
    }
}
