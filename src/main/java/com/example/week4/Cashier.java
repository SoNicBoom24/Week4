package com.example.week4;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cashier {
    @RequestMapping(value = "/getChange/{money}", method = RequestMethod.GET)
    public Change getChange(@PathVariable("money") int money){
        int b1000 = 0, b500 = 0, b100 = 0, b20 = 0, b10 = 0, b5 = 0, b1 = 0;
        b1000 = money/1000;
        money = money % 1000;
        b500 = money/500;
        money = money % 500;
        b100 = money/100;
        money = money % 100;
        b20 = money/20;
        money = money % 20;
        b10 = money/10;
        money = money % 10;
        b5 = money/5;
        money = money % 5;
        b1 = money;

        return new Change(b1000, b500, b100, b20, b10, b5, b1);
    }
}
