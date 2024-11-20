package com.hardwin.ecommerce.controller;

import com.hardwin.ecommerce.entity.Cart;
import com.hardwin.ecommerce.exception.ResourceNotFoundException;
import com.hardwin.ecommerce.response.ApiResponse;
import com.hardwin.ecommerce.service.ICartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}")
public class CartController {
    private final ICartService cartService;

    @GetMapping("/cart/{cartId}")
    public ResponseEntity<ApiResponse> getCart(@PathVariable Long cartId){
            Cart cart = cartService.getCart(cartId);
            return ResponseEntity.ok(new ApiResponse("Success", cart));

    }

    @GetMapping("/cart/{cartId}/amount")
    public ResponseEntity<ApiResponse> getTotalAmount(@PathVariable Long cartId){
            BigDecimal totalAmount = cartService.getTotalPrice(cartId);
            return ResponseEntity.ok(new ApiResponse("Success", totalAmount));
    }

    @DeleteMapping("/cart/{cartId}")
    public ResponseEntity<ApiResponse> clearCart(@PathVariable Long cartId){
            cartService.clearCart(cartId);
            return ResponseEntity.ok(new ApiResponse("Clear cart success", null));
    }
}
