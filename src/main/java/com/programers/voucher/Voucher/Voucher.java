package com.programers.voucher.Voucher;

import java.util.UUID;

public abstract class Voucher {
    private final UUID uuid;
    private final long amount;
    public Voucher(UUID uuid, long amount) {
        this.uuid = uuid;
        this.amount = amount;
    }

    public UUID getUUID() {
        return uuid;
    }

    public long getAmount() {
        return amount;
    }

    public abstract long calDiscount(long origin);
    public abstract String getType();

}
