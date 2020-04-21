package org.sid.com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FallBackRestController {

    @GetMapping("/restCountriesFallBack")
    public Map<String, String> restCountriesFallBack(){
        Map<String, String> map=new HashMap<>();
        map.put("message", "Default Rest Countries FallBack Service");
        map.put("countries", "Senegal, Maroc");
        return map;
    }

    @GetMapping("/muslimsalatFallBack")
    public Map<String, String> muslimsalatFallBack(){
        Map<String, String> map = new HashMap<>();
        map.put("message", "Default Muslim FallBack Service");
        map.put("Fajr", "05:45");
        map.put("Suba", "06:00");

        return map;
    }
}
