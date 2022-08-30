package com.example.week4;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathAPI {
    @RequestMapping(value = "/plus/{n1}/{n2}", method = RequestMethod.GET)
    public double myPlus(@PathVariable("n1") double n1, @PathVariable("n2") double n2) {
        return n1+n2;
    }

    @RequestMapping(value = "/minus/{n1}/{n2}", method = RequestMethod.GET)
    public double myMinus(@PathVariable("n1") double n1, @PathVariable("n2") double n2) {
        return n1-n2;
    }

    @RequestMapping(value = "/divide/{n1}/{n2}", method = RequestMethod.GET)
    public double myDivide(@PathVariable("n1") double n1, @PathVariable("n2") double n2) {
        return n1/n2;
    }

    @RequestMapping(value = "/multi/{n1}/{n2}", method = RequestMethod.GET)
    public double myMulti(@PathVariable("n1") double n1, @PathVariable("n2") double n2) {
        return n1*n2;
    }

    @RequestMapping(value = "/mod/{n1}/{n2}", method = RequestMethod.GET)
    public double myMod(@PathVariable("n1") double n1, @PathVariable("n2") double n2) {
        return n1%n2;
    }

    @RequestMapping(value = "/max", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public double myMax(@RequestBody MaxRequest eiei) {
        return Math.max(eiei.a, eiei.b);
    }


}
