package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import project.service.ClickCountService;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ClickCountController {
    private ClickCountService clickCountService;

    @Autowired
    public ClickCountController(ClickCountService clickCountService) {
        this.clickCountService = clickCountService;
    }

    @GetMapping("/click-counter")
    public String showPage() {
        return "page.html";
    }

    @GetMapping("/click-counter/value")
    public ResponseEntity<?> getValue() {
        Map<String, Integer> model = new HashMap<>();
        model.put("value", clickCountService.loadClicksCount());
        return ResponseEntity.ok(model);
    }

    @PostMapping("/click-counter/update")
    public ResponseEntity<?> updateValue() {
        clickCountService.updateClicksCount();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
