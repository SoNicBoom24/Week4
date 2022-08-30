package com.example.week4;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.*;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;

@Route(value = "cal.py")
public class MathView extends VerticalLayout {
    private TextField n1, n2, n3;
    private Button btnPlus, btnMinus, btnMul, btnDiv, btnMod, btnMax;

    public MathView(){
        n1 = new TextField("Number 1");
        n2 = new TextField("Number 2");
        n3 = new TextField("Answer");
        btnPlus = new Button("+");
        btnMinus = new Button("-");
        btnMul = new Button("x");
        btnDiv = new Button("/");
        btnMod = new Button("Mod");
        btnMax = new Button("Max");
        HorizontalLayout h1 = new HorizontalLayout();
        h1.add(btnPlus, btnMinus, btnMul, btnDiv, btnMod, btnMax);
        add(n1, n2, h1, n3);

        btnPlus.addClickListener(event ->{
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());
            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/plus/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
                    n3.setValue(out);
        });

        btnMinus.addClickListener(event ->{
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());
            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/minus/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            n3.setValue(out);
        });

        btnDiv.addClickListener(event ->{
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());
            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/divide/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            n3.setValue(out);
        });

        btnMul.addClickListener(event ->{
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());
            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/multi/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            n3.setValue(out);
        });

        btnMod.addClickListener(event ->{
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());
            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/mod/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            n3.setValue(out);
        });
    }
}
