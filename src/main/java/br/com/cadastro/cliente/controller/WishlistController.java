package br.com.cadastro.cliente.controller;

import br.com.cadastro.cliente.domain.StatusResponse;
import br.com.cadastro.cliente.domain.Wishlist;
import br.com.cadastro.cliente.repository.WishlistRepository;
import br.com.cadastro.cliente.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("wishlist")
@CrossOrigin("*")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @PostMapping("create")
    public ResponseEntity<StatusResponse> createWishlist(@RequestBody Wishlist wishlist) {
        StatusResponse statusResponse = wishlistService.createWishlist(wishlist);
        return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.OK);
    }
}
