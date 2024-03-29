package com.ohgiraffers.springdata.menu.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CategoryDTO {

    private int categoryCode;
    private String categoryName;
    private Integer refCategoryCode;
}
