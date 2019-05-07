package by.bntu.fitr.povt;

import by.bntu.fitr.povt.model.ModelTest;
import by.bntu.fitr.povt.model.Player;
import by.bntu.fitr.povt.model.User;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.config.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
    }
}
