/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.thien.mathutil.core;

import static com.thien.mathutil.core.MathUtil.getFactorial;
// import static là dành riêng cho những hàm static
// gọi hàm mà bỏ qua tên class
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author User
 */
public class MathUtilTest {
    
    // chơi DDT, tách data ra khỏi câu lệnh kiểm thử, tham số hóa data này
    // vào trong câu lệnh kiểm thử
    
    // chuẩn bị bộ data
    public static Object[][] initData(){
        return new Integer[][] {
            {1, 1},
            {2, 2},  
            {4, 24},
            {5, 120},
            {6, 120}           
        };
    }
    
    @ParameterizedTest
    @MethodSource(value = "initData")  // tên hàm cung cấp data, ngầm định thứ tự
    // của các phần tử mảng, map vào tham số hàm.
    public void testGetFactorialGiveRightArgReturnsWellUsingDDT(int input, long expected){
        assertEquals(expected, getFactorial(input));
    }
    
    @Test
    public void testGetFactorialGiveRightArgReturnsWell(){
        assertEquals(24, getFactorial(4));
    }
    
    // Bắt ngoại lệ khi đưa data cà chớn!!!
    // Test(expected = tên ngoại lệ.class) JUnit4 thôi, JUnit5 ko xài vậy!!!
    // test hàm nhập cà chớn!!!
    @Test
    public void testGetFactorialGiveWrongArgThrowException(){
        // xài biểu thức Lambda
        // hàm nhận tham số thứ 2 là 1 cái object/có code implement cái
        // functional interface tên là Executable - có 1 hàm duy nhất mà ko code
        // tên là execute()
        // C1
//        Executable exObject = new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                getFactorial(-5);
//            }
//        };

          //Executable exObject = () -> {getFactorial(-5);};
          // Viết gọn hơn nữa
          Executable exObject = () -> getFactorial(-5);
                  
        //assertThrows(IllegalArgumentException.class, exObject);
        assertThrows(IllegalArgumentException.class, () -> getFactorial(-5));
        
        
    }
}
