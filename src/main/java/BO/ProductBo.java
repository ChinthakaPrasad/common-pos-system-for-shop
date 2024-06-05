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
                dto.getSellingUnitPrice(),
                dto.getBuyingUnitPrice(),
                dto.getSupplier(),
                dto.getUnitType(),
                dto.getRemarks()));

    }

    @Override
    public boolean update(ProductDto dto) {
        Product oldProduct = productDao.getProduct(dto.getProductName());
        Product newProduct = new Product(dto.getProductName(),
                dto.getSellingUnitPrice(),
                dto.getBuyingUnitPrice(),
                dto.getSupplier(),
                dto.getUnitType(),
                dto.getRemarks());

        return productDao.updateProduct(newProduct, oldProduct.getProductId());
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
                    p.getSellingUnitPrice(),
                    p.getBuyingUnitPrice(),
                    p.getSupplier(),
                    p.getUnitType(),
                    p.getRemarks()));
        }
        return dtoList;
    }

    public Product getProduct(int id){
        return productDao.getProduct(id);
    }
}
