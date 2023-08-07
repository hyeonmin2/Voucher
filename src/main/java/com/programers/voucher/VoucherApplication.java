package com.programers.voucher;

import com.programers.voucher.Interface.ConsoleInterface;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class VoucherApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(VoucherApplication.class, args);
        ConsoleInterface consoleInterface = context.getBean(ConsoleInterface.class);
        consoleInterface.run();
    }
}
