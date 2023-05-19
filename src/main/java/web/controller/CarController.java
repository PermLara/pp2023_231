package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarServiceImp;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarServiceImp carService;

    @GetMapping(value = "/cars")
    public String listCar(@RequestParam String count, ModelMap model) {
        Integer number = Integer.parseInt(count);
        List<Car> listCar = carService.listCar(number);
        model.addAttribute("listCar", listCar);
        return "cars";
    }
}
