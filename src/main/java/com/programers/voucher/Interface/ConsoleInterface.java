package com.programers.voucher.Interface;

import com.programers.voucher.IO.Console;
import com.programers.voucher.IO.Input;
import com.programers.voucher.IO.Output;
import com.programers.voucher.Voucher.Voucher;
import com.programers.voucher.Controller.VoucherController;
import com.programers.voucher.Voucher.VoucherType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsoleInterface implements Runnable {
    private Output output;
    private Input input;
    private VoucherController controller;

    @Autowired
    public ConsoleInterface(Console console, VoucherController controller) {
        this.output = console;
        this.input = console;
        this.controller = controller;
    }

    public void run() {
        while (true) {
            try {
                output.menu();
                Menu sel = input.sel();
                switch (sel) {
                    case exit:
                        output.terminate();
                        return;
                    case list:
                        List<Voucher> voucherList = controller.getVoucherList();
                        output.voucherList(voucherList);
                        break;
                    case create:
                        VoucherType type = input.voucherType();
                        long amount = input.voucherAmount();
                        controller.createVoucher(type, amount);
                        output.message("Success!!");
                        break;
                    default:
                        throw new IllegalArgumentException("Cannot execute sel");
                }
            } catch (IllegalArgumentException exception) {
                output.message(exception.getMessage());
            }
        }
    }
}
