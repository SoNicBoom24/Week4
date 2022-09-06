package com.example.week4;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;

@Route(value = "kidtang")
public class CashierView extends VerticalLayout {
    private TextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8;
    private Button btn;

    public CashierView(){
        tf1 = new TextField("เงินทอน");
        tf2 = new TextField();
        tf3 = new TextField();
        tf4 = new TextField();
        tf5 = new TextField();
        tf6 = new TextField();
        tf7 = new TextField();
        tf8 = new TextField();
        btn = new Button("คิดเงินทอน");

        tf1.setPrefixComponent(new Div(new Text("$")));
        tf2.setPrefixComponent(new Div(new Text("$1000:")));
        tf3.setPrefixComponent(new Div(new Text("$500:")));
        tf4.setPrefixComponent(new Div(new Text("$100:")));
        tf5.setPrefixComponent(new Div(new Text("$20:")));
        tf6.setPrefixComponent(new Div(new Text("$10:")));
        tf7.setPrefixComponent(new Div(new Text("$5:")));
        tf8.setPrefixComponent(new Div(new Text("$1:")));

        add(tf1, btn, tf2, tf3, tf4, tf5, tf6, tf7, tf8);

        btn.addClickListener(event -> {
            String money = tf1.getValue();
            Change result = WebClient
                    .create()
                    .get()
                    .uri("http://localhost:8080/getChange/"+money)
                    .retrieve()
                    .bodyToMono(Change.class)
                    .block();
            tf2.setValue(result.getB1000()+"");
            tf3.setValue(result.getB500()+"");
            tf4.setValue(result.getB100()+"");
            tf5.setValue(result.getB20()+"");
            tf6.setValue(result.getB10()+"");
            tf7.setValue(result.getB5()+"");
            tf8.setValue(result.getB1()+"");
        });
    }
}
