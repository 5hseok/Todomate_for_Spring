package com.example.Todomate.controller.calculator;

import com.example.Todomate.dto.calculator.CalculatorAddRequest;
import com.example.Todomate.dto.calculator.CalculatorMultiRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {
    @GetMapping("/add")
    public int addTwoNumbers(CalculatorAddRequest request){
        return request.getNumber1() + request.getNumber2();
    }

    @PostMapping("/multiply")
    public int mulTwoNumbers(@RequestBody CalculatorMultiRequest request){
        return request.getNumber1() * request.getNumber2();
    }
}
