package com.vladislav.univermag.convertors;

import com.vladislav.univermag.dto.ProductDto;
import com.vladislav.univermag.entity.Customer;
import com.vladislav.univermag.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ConvertProductToProductDto extends Convertor <Product, ProductDto> {


    @Override
    public ProductDto convert(Product product) {
      return new Builder()
               .itemName(product.getItemName())
              .yearOfManufacture(product.getYearOfManufacture())
              .quantityInStock(product.getQuantity())
              .build();
    }


    public ProductDto convertUpdate(Product product) {
        return new Builder()
                .id(product.getId())
                .itemName(product.getItemName())
                .yearOfManufacture(product.getYearOfManufacture())
                .quantityInStock(product.getQuantity())
                .build();
    }



    public static class Builder {
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

        public ProductDto build() {
            ProductDto productDto = new ProductDto();
            productDto.setId(this.id);
            productDto.setItemName(this.itemName);
            productDto.setManufacturer(this.manufacturer);
            productDto.setYearOfManufacture(this.yearOfManufacture);
            productDto.setQuantityInStock(this.quantityInStock);
            return productDto;

            // TODO: продумать где будут храниться данные о количестве и наличии товара
        }
    }
}