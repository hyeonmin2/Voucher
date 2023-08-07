package com.programers.voucher.Controller;

import com.programers.voucher.Voucher.Voucher;

import java.util.List;

public interface VoucherRepository {
    Voucher save(Voucher voucher);
    List<Voucher> findAll();
}
