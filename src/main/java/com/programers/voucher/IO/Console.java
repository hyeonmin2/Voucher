package com.programers.voucher.IO;

import com.programers.voucher.Interface.Menu;
import com.programers.voucher.Voucher.Voucher;
import com.programers.voucher.Voucher.VoucherType;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

@Component
public class Console implements Input, Output {
    Scanner sc = new Scanner(System.in);

    @Override
    public Menu sel() {
        while (true) {
            System.out.print("sel : ");
            String sel = sc.nextLine();
            switch (sel) {
                case "list":
                case "List":
                case "LIST":
                    return Menu.list;
                case "Create":
                case "create":
                case "CREATE":
                    return Menu.create;
                case "exit":
                case "Exit":
                case "EXIT":
                    return Menu.exit;
                default:
                    System.out.println("Unknown sel (create / list / exit)");
            }
        }
    }

    @Override
    public VoucherType voucherType() {
        while (true) {
            System.out.print("type : ");
            String type = sc.nextLine();
            switch (type) {
                case "fix":
                case "Fix":
                case "FIX":
                    return VoucherType.fix;
                case "Percent":
                case "percent":
                case "PERCENT":
                    return VoucherType.percent;
                default:
                    System.out.println("Unknown Type (fix / percent)");
            }
        }
    }

    @Override
    public long voucherAmount() {
        System.out.print("Amount : ");
        long amount = sc.nextLong();
        sc.nextLine();
        return amount;
    }

    @Override
    public void voucherList(List<Voucher> voucherList) {
        if (voucherList.size() == 0) {
            System.out.println("EMPTY");
        }
        Iterator<Voucher> iter = voucherList.iterator();
        while (iter.hasNext()) {
            Voucher voucher = iter.next();
            System.out.println("UUID:" + voucher.getUUID() +
                    " Type:" + voucher.getType() +
                    " Amount:" + voucher.getAmount());
        }
    }

    @Override
    public void message(String message) {
        System.out.println(message);
    }

    @Override
    public void menu() {
        System.out.println();
        System.out.println("=== Voucher Program ===");
        System.out.println("Type exit to exit the program.");
        System.out.println("Type create to create a new voucher.");
        System.out.println("Type list to list all vouchers.");
        System.out.println();
    }

    @Override
    public void terminate() {
        System.out.println("System terminate");
    }
}
