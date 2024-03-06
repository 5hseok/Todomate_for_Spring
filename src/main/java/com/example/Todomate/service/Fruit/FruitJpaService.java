package com.example.Todomate.service.Fruit;

import com.example.Todomate.domain.Fruit.Fruit;
import com.example.Todomate.domain.Fruit.FruitRepository;
import com.example.Todomate.dto.fruit.request.FruitRequest;
import com.example.Todomate.dto.fruit.response.FruitListResponse;
import com.example.Todomate.dto.fruit.response.FruitResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class FruitJpaService{
    private final FruitRepository fruitRepository;

    public FruitJpaService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public void saveFruit(FruitRequest request){
        fruitRepository.save(
                new Fruit(request.getName(), request.getWarehousingDate(), request.getPrice())
        );
    }

    public FruitResponse getFruit(String name){
        //name이 일치하는 것들 중 sell 유무에 따른 가격의 합
        List<Fruit> fruitList = fruitRepository.findAllByName(name);

        if(fruitList.isEmpty()) {
            throw new IllegalArgumentException();
        }

        AtomicLong sellPrice = new AtomicLong();
        AtomicLong notSellPrice = new AtomicLong();

        fruitList.stream().forEach(fruit -> {
            if(fruit.isSell()){
                sellPrice.addAndGet(fruit.getPrice());
            }
            else{
                notSellPrice.addAndGet(fruit.getPrice());
            }
        });

        return new FruitResponse(sellPrice.get(), notSellPrice.get());
    }

    public void putFruit(long id){
        Fruit fruit = fruitRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        fruit.setSell(true);
        fruitRepository.save(fruit);
    }

    public long countFruit(String name){
         long count = fruitRepository.countByName(name);
         return count;
    }

    public List<FruitListResponse> countNotSellFruit(String option, long price){
        List<Fruit> fruitList;

        if (option.equals("GTE")){
            fruitList = fruitRepository.findAllByPriceGreaterThanEqual(price);
        } else if (option == "LTE") {
            fruitList = fruitRepository.findAllByPriceLessThanEqual(price);
        }
        else{
            throw new IllegalArgumentException("잘못된 쿼리입니다.");
        }

        return fruitList.stream()
                .map(fruit -> new FruitListResponse(fruit))
                .collect(Collectors.toList());
    }
}
