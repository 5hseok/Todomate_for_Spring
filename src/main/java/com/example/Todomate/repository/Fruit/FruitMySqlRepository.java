package com.example.Todomate.repository.Fruit;

import com.example.Todomate.dto.fruit.request.FruitRequest;
import com.example.Todomate.dto.fruit.response.FruitResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@Repository
public class FruitMySqlRepository implements FruitRepository{
    private final JdbcTemplate jdbcTemplate;

    public FruitMySqlRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveFruit(FruitRequest fruitRequest) {
        String sql = "INSERT INTO warehouse (name, warehousingDate, price) VALUES (?,?,?)";
        jdbcTemplate.update(sql, fruitRequest.getName(),fruitRequest.getWarehousingDate(), fruitRequest.getPrice());

    }

    @Override
    public FruitResponse getFruit(String name) {
        String sql = "SELECT sell, SUM(price) AS TotalPrice FROM warehouse WHERE name = ? GROUP BY sell;";
        AtomicLong sellPrice = new AtomicLong();
        AtomicLong notSellPrice = new AtomicLong();

        List<Object> results = jdbcTemplate.query(sql, (rs, rowNum)->{
            boolean sell = rs.getBoolean("sell");
            if (rs.wasNull()){
                System.out.println("error");
                throw new IllegalArgumentException();
            }
            else if (sell){
                sellPrice.addAndGet(rs.getLong("TotalPrice"));
            }
            else{
                notSellPrice.addAndGet(rs.getLong("TotalPrice"));
            }
            return null;
        },name);
        if (results.isEmpty()) {
            throw new IllegalArgumentException("해당하는 이름의 과일이 없습니다.");
        }
        return new FruitResponse(sellPrice.get(), notSellPrice.get());
    }

    @Override
    public void putFruit(long id) {
        String sql = "UPDATE warehouse SET sell = true WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public boolean isNotFruitExist(long id) {
        String readSql = "SELECT * FROM warehouse WHERE id = ?";
        return jdbcTemplate.query(readSql, (rs, rowNum)-> 0, id).isEmpty();
    }
}
