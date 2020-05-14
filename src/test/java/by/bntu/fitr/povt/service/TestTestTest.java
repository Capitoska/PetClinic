package by.bntu.fitr.povt.service;


import by.bntu.fitr.povt.Main;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.naming.Context;

@Log4j2
@SpringBootTest(classes = Main.class)
@ExtendWith(SpringExtension.class)
public class TestTestTest {

    @Test
    public void personPageForDoctor(){
        SecurityContext securityContext = new SecurityContextImpl();
    }
}
