package com.example.Todomate.dto.calculator;

public class CalculatorMultiRequest {
    private int number1;
    private int number2;
// POST 요청을 받을 때 컨트롤러에서 @RequestBody를 사용하는데, 이때는 생성자를 만들지 않아도 된다.
    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }
}
