package com.cg.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.cg.entity.Cart;
import com.cg.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {

	@Autowired
	CartService service;

	public CartController(CartService service) {
		this.service = service;
	}

	@PostMapping("/{cartId}")
	public Cart addProduct(@PathVariable Long cartId, @RequestBody Long pid) {

		return service.addProduct(cartId, pid);
	}

	@GetMapping("/{id}")
	public Map<String, Object> getCart(@PathVariable Long id) {
		return service.getCart(id);
	}
}
