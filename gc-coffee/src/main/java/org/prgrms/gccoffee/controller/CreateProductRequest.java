package org.prgrms.gccoffee.controller;

import org.prgrms.gccoffee.model.Category;

public record CreateProductRequest(
    String productName, Category category, long price, String description
) {
}
