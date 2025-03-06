package com.milky.service;

import com.milky.entity.Milk;
import java.util.List;

public interface MilkService {
    Milk saveMilk(Milk milk);
    List<Milk> getAllMilk();
    Milk getMilkById(Integer id);
    void deleteMilk(Integer id);
}
