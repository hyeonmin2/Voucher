package com.programers.voucher.IO;

import com.programers.voucher.Voucher.Voucher;

import java.util.List;

public interface Output {
    void voucherList(List<Voucher> voucherList);

    void message(String message);

    void menu();

    void terminate();
}
