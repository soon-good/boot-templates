package io.study.tdd.weblayer.employee;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Controller // 또는 @RestController
public class EmployeeController {

    @GetMapping("/employees")
    public @ResponseBody List<Employee> getEmployees(){
        List<Employee> employees = Arrays.asList(
                new Employee(1L, "지드래곤"),
                new Employee(2L, "태양"),
                new Employee(3L, "황의조")
        );

        return employees;
    }

    @GetMapping("/employee/servertime")
    public String getServerTime(Model model){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        String strDate = now.format(formatter);
        model.addAttribute("serverTime", strDate);

        return "employee/servertime";
    }
}
