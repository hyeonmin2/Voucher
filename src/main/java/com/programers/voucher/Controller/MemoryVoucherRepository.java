package com.programers.voucher.Controller;

import com.programers.voucher.Voucher.Voucher;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryVoucherRepository implements VoucherRepository {
    private final Map<UUID, Voucher> voucherRepository = new HashMap<>();
    @Override
    public Voucher save(Voucher voucher) {
        if (voucherRepository.containsKey(voucher.getUUID())) {
            throw new IllegalArgumentException(
                    "이미 존재하는 바우처의 uuid입니다. [uuid]: " + voucher.getUUID());
        }
        voucherRepository.put(voucher.getUUID(), voucher);
        return voucher;
    }
    @Override
    public List<Voucher> findAll() {
        return new ArrayList<>(voucherRepository.values());
    }
}
