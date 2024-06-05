package BO;

import dao.SupplierDao;
import dto.SupplierDto;
import entity.Supplier;

import java.util.ArrayList;
import java.util.List;

public class SupplierBo implements SuperBo<SupplierDto>{

    SupplierDao supplierDao = new SupplierDao();
    @Override
    public boolean save(SupplierDto dto) {
         return supplierDao.saveSupplier(new Supplier(dto.getSupplierName(),
                dto.getSupplierPhone(),
                dto.getSupplierAddress(),
                dto.getSupplierEmail(),
                dto.getRemarks()));

    }

    @Override
    public boolean update(SupplierDto dto) {
        Supplier oldSupplier = supplierDao.getSupplier(dto.getSupplierName());
        Supplier newSupplier = new Supplier(dto.getSupplierName(),
                dto.getSupplierPhone(),
                dto.getSupplierAddress(),
                dto.getSupplierEmail(),
                dto.getRemarks());

        return supplierDao.updateSupplier(newSupplier, oldSupplier.getSupplierId());
    }

    @Override
    public boolean delete(SupplierDto dto) {
        return supplierDao.deleteSupplier(dto.getSupplierId());
    }

    @Override
    public List<SupplierDto> all() {
        List<Supplier> list = supplierDao.getAll();
        List<SupplierDto> dtoList = new ArrayList<>();
        for(Supplier s: list){
            dtoList.add(new SupplierDto(s.getSupplierId(),
                    s.getSupplierName(),
                    s.getPhoneNumber(),
                    s.getAddress(),
                    s.getEmail(),
                    s.getRemarks()));
        }
        return dtoList;
    }
}
