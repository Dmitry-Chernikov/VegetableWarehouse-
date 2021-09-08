package ru.dmitry.VegetableWarehouse.service;

import lombok.AllArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.converter.UnitsMapper;
import ru.dmitry.VegetableWarehouse.dto.GoodsDto;
import ru.dmitry.VegetableWarehouse.dto.UnitsDto;
import ru.dmitry.VegetableWarehouse.model.Goods;
import ru.dmitry.VegetableWarehouse.model.Units;
import ru.dmitry.VegetableWarehouse.repo.UnitsRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class UnitsService {

    private final UnitsRepository unitsRepository;

    //Read id
    public Units findById(Long id){
        return unitsRepository.findById(id).orElse(null);
    }
    //Read All
    public List<Units> findAll(){
        return unitsRepository.findAll();
    }
    //Save one unit
    public Units save(Units units){
        return unitsRepository.save(units) ;
    }
    //Delete unit on id
    public void deleteBuId(Long id){
        try{
            unitsRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }
}
