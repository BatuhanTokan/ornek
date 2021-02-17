package com.ilacstok.eczane.Service;

import com.ilacstok.eczane.Domain.StokDO;
import com.ilacstok.eczane.Dto.StokDTO;
import com.ilacstok.eczane.Repository.StokRepoSitory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StokServiceImpl implements StokService {
    @Autowired
    private StokRepoSitory StokRepository;

    @Override
    public StokDO createStok(StokDO stok) {
        return StokRepository.save(stok);
    }



    @Override
    public StokDTO updateStok(StokDO stok) {
        long StokId = stok.getId();
        Optional<StokDO> currentStok = StokRepository.findById(StokId);
        if (currentStok.isPresent()) {
            currentStok.get().setTur(stok.getTur());
            currentStok.get().setAd(stok.getAd());
            currentStok.get().setKamaci(stok.getKamaci());
            currentStok.get().setDoz(stok.getDoz());
            currentStok.get().setAdet(stok.getAdet());
            currentStok.get().setFirma(stok.getFirma());



            StokRepository.save(currentStok.get());

            StokDTO stokDTO = new ModelMapper().map(currentStok.get(), StokDTO.class);


            return stokDTO;
        }
        return null;
    }

    @Override
    public void deleteStok(Long stokId) {
        Optional<StokDO> currentCustomer = StokRepository.findById(stokId);
        if (currentCustomer.isPresent()) {
            StokRepository.deleteById(stokId);
        }
    }

    @Override
    public StokDO getStok(Long stokId) {
        Optional<StokDO> currentStok = StokRepository.findById(stokId);
        if (currentStok.isPresent()) {
            return currentStok.get();
        }
        return null;
    }

    @Override
    public List<StokDO> getAllStok() {
        return StokRepository.findAll();
    }

    @Override
    public StokDO getStok(String StokName) {
        Optional<StokDO> currentStok = StokRepository.findByName(StokName);
        if (currentStok.isPresent()) {
            return currentStok.get();
        }
        return null;
    }
}
