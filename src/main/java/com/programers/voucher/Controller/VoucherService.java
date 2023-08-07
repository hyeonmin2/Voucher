package com.programers.voucher.Controller;

import com.programers.voucher.Voucher.Voucher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoucherService {
    private final MemoryVoucherRepository memoryVoucherRepository;

    @Autowired
    public VoucherService(MemoryVoucherRepository memoryVoucherRepository) {
        this.memoryVoucherRepository = memoryVoucherRepository;
    }

    public Voucher saveVoucher(Voucher voucher) {
        return memoryVoucherRepository.save(voucher);
    }

    public List<Voucher> getVoucherList() {
        return memoryVoucherRepository.findAll();
    }
}
