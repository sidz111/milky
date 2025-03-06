package com.milky.service.impl;

import com.milky.entity.Milk;
import com.milky.repository.MilkRepository;
import com.milky.service.MilkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MilkServiceImpl implements MilkService {

    @Autowired
    private MilkRepository milkRepository;

    @Override
    public Milk saveMilk(Milk milk) {
        return milkRepository.save(milk);
    }

    @Override
    public List<Milk> getAllMilk() {
        return milkRepository.findAll();
    }

    @Override
    public Milk getMilkById(Integer id) {
        return milkRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteMilk(Integer id) {
        milkRepository.deleteById(id);
    }
}
