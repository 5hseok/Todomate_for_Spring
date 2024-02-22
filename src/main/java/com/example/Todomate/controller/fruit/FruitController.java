package com.example.Todomate.controller.fruit;

import com.example.Todomate.dto.fruit.request.FruitRequest;
import com.example.Todomate.dto.fruit.request.FruitUpdateRequest;
import com.example.Todomate.dto.fruit.response.FruitResponse;
import com.example.Todomate.dto.fruit.response.SellInfoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.Todomate.domain.Fruit.Fruit;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;
import java.util.List;

@RestController
public class FruitController {
    private final JdbcTemplate jdbcTemplate;
    public FruitController(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/api/v1/fruit")
    public ResponseEntity<Void> saveFruit(@RequestBody FruitRequest request){
        if (request.getName() == null || request.getWarehousingDate() == null || request.getPrice() == null) {
            return ResponseEntity.badRequest().build();
        }
        String sql = "INSERT INTO warehouse (name, warehousingDate, price) VALUES (?,?,?)";
        jdbcTemplate.update(sql, request.getName(),request.getWarehousingDate(), request.getPrice());
        return ResponseEntity.ok().build();
    }

    @PutMapping("api/v1/fruit")
    public void putFruit(@RequestBody FruitUpdateRequest request){
        String readSql = "SELECT * FROM warehouse WHERE id = ?";
        boolean isFruitNotExist = jdbcTemplate.query(readSql, (rs, rowNum)-> 0, request.getId()).isEmpty();
        if(isFruitNotExist){
            throw new IllegalArgumentException();
        }
        String sql = "UPDATE warehouse SET sell = true WHERE id = ?";
        jdbcTemplate.update(sql, request.getId());
    }

//    @GetMapping("api/v1/fruit/stat")
//    public FruitResponse getFruitTotalPrice(@RequestParam String name){
//        long sellPrice=0;
//        long notSellPrice=0;
//        String sql = "SELECT * FROM warehouse WHERE name = ?";
//        List<Fruit> fruits = jdbcTemplate.query(sql, (rs, rowNum) -> {
//            long price = rs.getLong("price");
//            boolean sell = rs.getBoolean("sell");
//            return new Fruit(price, sell);
//        }, name);
//
//        for (Fruit fruit : fruits){
//            if ( fruit.isSell() ){
//                sellPrice += fruit.getPrice();
//            }
//            else{
//                notSellPrice += fruit.getPrice();
//            }
//        }
//        return new FruitResponse(sellPrice, notSellPrice);
//
//    }
    @GetMapping("api/v1/fruit/stat")
    public FruitResponse getFruitTotalPrice(@RequestParam String name){
        String sql = "SELECT sell, SUM(price) AS TotalPrice FROM warehouse WHERE name = ? GROUP BY sell;";
        AtomicLong sellPrice = new AtomicLong();
        AtomicLong notSellPrice = new AtomicLong();

        jdbcTemplate.query(sql, (rs,rowNum)->{
            boolean sell = rs.getBoolean("sell");
            if (rs.wasNull() ||!sell){
                notSellPrice.addAndGet(rs.getLong("TotalPrice"));
            }
            else{
                sellPrice.addAndGet(rs.getLong("TotalPrice"));
            }

            return null;
        },name);
        return new FruitResponse(sellPrice.get(), notSellPrice.get());

    }

}

