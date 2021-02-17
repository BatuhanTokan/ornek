package com.ilacstok.eczane.Service;

import com.ilacstok.eczane.Domain.StokDO;
import com.ilacstok.eczane.Dto.StokDTO;

import java.util.List;

public interface StokService {
    StokDO createStok(StokDO stok);
    // CustomerDO updateCustomer(CustomerDO customer);
    StokDTO updateStok(StokDO stok);
    void deleteStok(Long StokId);
    StokDO getStok(Long StokId);
    StokDO getStok(String Stokname);
    List<StokDO> getAllStok();

}
