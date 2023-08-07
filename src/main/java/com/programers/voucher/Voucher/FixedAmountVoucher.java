package com.programers.voucher.Voucher;

import java.util.UUID;

public class FixedAmountVoucher extends Voucher{
    public FixedAmountVoucher(UUID uuid, long amount) {
        super(uuid, amount);
    }

    @Override
    public long calDiscount(long origin) {
        return origin - getAmount();
    }

    @Override
    public String getType() {
        return "Fixed";
    }
}
