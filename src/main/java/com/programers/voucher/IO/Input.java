package com.programers.voucher.IO;

import com.programers.voucher.Interface.Menu;
import com.programers.voucher.Voucher.VoucherType;

public interface Input {

    Menu sel();

    VoucherType voucherType();

    long voucherAmount();
}
