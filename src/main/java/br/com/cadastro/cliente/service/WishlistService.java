package br.com.cadastro.cliente.service;

import br.com.cadastro.cliente.domain.StatusResponse;
import br.com.cadastro.cliente.domain.Wishlist;
import br.com.cadastro.cliente.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    public StatusResponse createWishlist(Wishlist wishlist) {
        if (wishlist.getCurso().getId() == null) {
            return new StatusResponse("Curso não pode ser null", "erro");
        }
        wishlistRepository.save(wishlist);
        return new StatusResponse("Wishlist criada com sucesso", "sucesso");
    }
}
