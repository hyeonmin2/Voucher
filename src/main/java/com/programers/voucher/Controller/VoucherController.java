package com.programers.voucher.Controller;

import com.programers.voucher.UUID.UUIDGenerator;
import com.programers.voucher.Voucher.FixedAmountVoucher;
import com.programers.voucher.Voucher.PercentDiscountVoucher;
import com.programers.voucher.Voucher.Voucher;
import com.programers.voucher.Voucher.VoucherType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class VoucherController{
    private final UUIDGenerator uuidGenerator;
    private final VoucherService service;

    @Autowired
    public VoucherController(UUIDGenerator uuidGenerator, VoucherService service) {
        this.uuidGenerator = uuidGenerator;
        this.service = service;
    }
    public List<Voucher> getVoucherList() {
        return service.getVoucherList();
    }

    public Voucher createVoucher(VoucherType type, long amount) {
        switch (type) {
            case fix -> {
                FixedAmountVoucher fixedAmountVoucher = new FixedAmountVoucher(uuidGenerator.generateUUID(), amount);
                return service.saveVoucher(fixedAmountVoucher);
            }
            case percent -> {
                PercentDiscountVoucher percentDiscountVoucher = new PercentDiscountVoucher(uuidGenerator.generateUUID(), amount);
                return service.saveVoucher(percentDiscountVoucher);
            }
            default -> throw new IllegalArgumentException("Unknown Type");
        }
    }
}
