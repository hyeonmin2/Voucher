package com.programers.voucher.Voucher;

import java.util.UUID;

public class PercentDiscountVoucher extends Voucher {
    public PercentDiscountVoucher(UUID uuid, long amount) {
        super(uuid, amount);
    }

    @Override
    public long calDiscount(long origin) {
        return origin * getAmount() / 100;
    }

    @Override
    public String getType() {
        return "Percent";
    }
}
