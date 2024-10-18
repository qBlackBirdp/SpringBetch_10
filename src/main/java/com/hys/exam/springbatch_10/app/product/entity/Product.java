package com.hys.exam.springbatch_10.app.product.entity;

import com.hys.exam.springbatch_10.app.base.entity.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Product extends BaseEntity {
    private String name;
    private int salePrice;
    private int price;
    private int wholesalePrice;
    private String makerShopName;

    @Builder.Default
    @OneToMany(mappedBy = "product", cascade = ALL, orphanRemoval = true)
    private List<ProductOption> productOptions = new ArrayList<>();

    public void addOption(ProductOption option) {
        option.setProduct(this);
        option.setPrice(getPrice());
        option.setWholesalePrice(getWholesalePrice());
        option.setSalePrice(getSalePrice());

        productOptions.add(option);
    }
}