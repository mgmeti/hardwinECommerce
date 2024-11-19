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
@RequestMapping("${api.prefix}/carts")
public class CartController {
    private final ICartService cartService;

    @GetMapping("/{cartId}/cart")
    public ResponseEntity<ApiResponse> getCart(@PathVariable Long cartId){
        try{
            Cart cart = cartService.getCart(cartId);
            return ResponseEntity.ok(new ApiResponse("Success", cart));
        }catch (ResourceNotFoundException rnfe){
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(rnfe.getMessage(), null));
        }
    }

    @GetMapping("/{cartId}/cart/amount")
    public ResponseEntity<ApiResponse> getTotalAmount(@PathVariable Long cartId){
        try{
            BigDecimal totalAmount = cartService.getTotalPrice(cartId);
            return ResponseEntity.ok(new ApiResponse("Success", totalAmount));
        }catch (ResourceNotFoundException rnfe){
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(rnfe.getMessage(), null));
        }
    }

    @DeleteMapping("/{cartId}/cart")
    public ResponseEntity<ApiResponse> clearCart(@PathVariable Long cartId){
        try{
            cartService.clearCart(cartId);
            return ResponseEntity.ok(new ApiResponse("Clear cart success", null));
        }catch (ResourceNotFoundException rnfe){
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(rnfe.getMessage(), null));
        }
    }
}
