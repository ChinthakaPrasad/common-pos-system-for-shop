package BO;

import dao.ProductDao;
import dto.ProductDto;
import entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductBo implements SuperBo<ProductDto>{
    private ProductDao productDao = new ProductDao();

    @Override
    public boolean save(ProductDto dto) {
        return productDao.saveProduct(new Product(dto.getProductName(),
                dto.getUnitPrice(),
                dto.getUnitType(),
                dto.getRemarks()));

    }

    @Override
    public boolean update(ProductDto dto) {

        return productDao.updateProduct(new Product(dto.getProductName(),
                dto.getUnitPrice(),
                dto.getUnitType(),
                dto.getRemarks()));
    }

    @Override
    public boolean delete(ProductDto dto) {

        return productDao.deleteProduct(dto.getProductId());
    }

    @Override
    public List<ProductDto> all() {

        List<Product> list = productDao.getAll();
        List<ProductDto> dtoList = new ArrayList<>();

        for(Product p : list){
            dtoList.add(new ProductDto(p.getProductId(),
                    p.getProductName(),
                    p.getUnitPrice(),
                    p.getUnitType(),
                    p.getRemarks()));
        }
        return dtoList;
    }
}
