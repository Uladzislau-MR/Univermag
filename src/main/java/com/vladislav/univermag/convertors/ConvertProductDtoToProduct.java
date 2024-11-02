package com.vladislav.univermag.convertors;

import com.vladislav.univermag.dto.ProductDto;
import com.vladislav.univermag.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ConvertProductDtoToProduct extends Convertor<ProductDto, Product> {
    @Override
    public Product convert(ProductDto productDto) {
        return new Builder()
                .id(productDto.getId())
                .itemName(productDto.getItemName())
                .manufacturer(productDto.getManufacturer())
                .yearOfManufacture(productDto.getYearOfManufacture())
                .quantityInStock(productDto.getQuantityInStock())
                .build();
          }

    public class Builder {
        private int id;
        private String itemName;
        private String manufacturer;
        private int yearOfManufacture;
        private int quantityInStock;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder itemName(String itemName) {
            this.itemName = itemName;
            return this;
        }

        public Builder manufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        public Builder yearOfManufacture(int yearOfManufacture) {
            this.yearOfManufacture = yearOfManufacture;
            return this;
        }

        public Builder quantityInStock(int quantityInStock) {
            this.quantityInStock = quantityInStock;
            return this;
        }

        public Product build() {
            Product product = new Product();
            product.setId(this.id);
            product.setItemName(this.itemName);
            product.setManufacturer(this.manufacturer);
            product.setYearOfManufacture(this.yearOfManufacture);
            product.setQuantity(this.quantityInStock);
            return product;
        }
    }

}
