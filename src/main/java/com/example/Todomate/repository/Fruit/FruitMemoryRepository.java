package com.example.Todomate.repository.Fruit;

import com.example.Todomate.domain.Fruit.Fruit;
import com.example.Todomate.dto.fruit.request.FruitRequest;
import com.example.Todomate.dto.fruit.response.FruitResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class FruitMemoryRepository implements FruitRepository{
    private List<Fruit> fruitList;
    private long id = 1;
    public FruitMemoryRepository(List<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    @Override
    public void saveFruit(FruitRequest fruitRequest) {
        Fruit fruit = new Fruit(id++, fruitRequest.getName(), fruitRequest.getWarehousingDate(), fruitRequest.getPrice());
        fruitList.add(fruit);
    }

    @Override
    public FruitResponse getFruit(String name){
        long sellPrice = 0, notSellPrice = 0;
        boolean checkNoFruit = false;
        for (Fruit fruit : fruitList){
            if ( fruit.getName().equals(name) ){
                if ( fruit.isSell() ){
                    sellPrice += fruit.getPrice();
                }
                else{
                    notSellPrice += fruit.getPrice();
                }
                checkNoFruit = true;
            }
        }
        if (!checkNoFruit){
            throw new IllegalArgumentException("해당하는 이름의 과일이 없습니다.");
        }
        return new FruitResponse(sellPrice, notSellPrice);
    }
    @Override
    public void putFruit(long id) {
        for ( Fruit fruit : fruitList ){
            if (fruit.getId() == id){
                fruit.setSell(true);
            }
        }
    }

    @Override
    public boolean isNotFruitExist(long id) {
        for(Fruit fruit : fruitList){
            if ( fruit.getId() == id ){
                return false;
            }
        }
        return true;
    }

    @Override
    public long findAllByPriceGreaterThanEqual(long price) {
        return 0;
    }
}
