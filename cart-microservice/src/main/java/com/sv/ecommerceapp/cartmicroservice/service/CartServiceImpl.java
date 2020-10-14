package com.sv.ecommerceapp.cartmicroservice.service;

import com.sv.ecommerceapp.cartmicroservice.model.Cart;
import com.sv.ecommerceapp.cartmicroservice.model.Item;
import com.sv.ecommerceapp.cartmicroservice.proxy.CatalogueProxy;
import com.sv.ecommerceapp.cartmicroservice.repository.CartRepository;
import com.sv.ecommerceapp.cartmicroservice.utilities.CartUtilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {


    @Autowired
    CartRepository cartRepository;

    @Autowired
    CatalogueProxy catalogueProxy;


	/*
	 * @Override public Cart createCart(Long productId) { Cart cart = new Cart();
	 * 
	 * //This method needs to be implemented in catalogue side - NOT YET IMPLEMENTED
	 * - or else use getOneProductById and iterate through each id Item item =
	 * catalogueProxy.getOneProductById(productId);
	 * 
	 * cart.setItems(item);
	 * 
	 * //Implement generateTotalAmountForCart method
	 * cart.setTotalAmount(generateTotalAmountForCart(item));
	 * 
	 * return cartRepository.save(cart); }
	 * 
	 * private int generateTotalAmountForCart(Item item) {
	 * 
	 * //Need to implement this method
	 * 
	 * return 0; }
	 * 
	 * @Override public void deleteCart(Long cartId) {
	 * cartRepository.deleteById(cartId); }
	 * 
	 * 
	 * 
	 */
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void addItemToCart(Long cartId, Long productId, Integer quantity) {
        Item item = catalogueProxy.getOneProductById(productId);
        Cart cart = new Cart(quantity,item, CartUtilities.getSubTotalForItem(item,quantity));
        cartRepository.addItemToCart(cartId, item);
    }

    @Override
    public List<Object> getCart(Long cartId) {
        return (List<Object>)cartRepository.getCart(cartId, Item.class);
    }

	/*
	 * @Override public void changeItemQuantity(String cartId, Long productId,
	 * Integer quantity) { List<Item> cart = (List) cartRepository.getCart(cartId,
	 * Item.class); for(Cart c : cart){ if((c.get).equals(productId)){
	 * cartRepository.deleteItemFromCart(cartId, item); item.setQuantity(quantity);
	 * item.s(CartUtilities.getSubTotalForItem(item,quantity));
	 * cartRepository.addItemToCart(cartId, item); } } }
	 */

    @Override 
    public void changeItemQuantity(Long cartId, Long productId,
    		  Integer quantity) {
    	if(cartRepository.existsById(productId))
    	{
    		Cart cart = cartRepository.getOne(productId);
    		int quantityUpdated = cart.getQuantity()+quantity;
    		cart.setQuantity(quantityUpdated);
    	}
    	cartRepository.addItemToCart(cartId, cart);
    	
    }
    @Override
    public void deleteItemFromCart(Long cartId, Long productId) {
        List<Item> items = (List) cartRepository.getCart(cartId, Item.class);
        for(Item item : items){
            if((item.getId()).equals(productId)){
            	cartRepository.deleteItemFromCart(cartId, item);
            }
        }
    }

    @Override
    public boolean checkIfItemIsExist(Long cartId, Long productId) {
        List<Item> cart = (List) cartRedisRepository.getCart(cartId, Item.class);
        for(Item item : cart){
            if((item.getProduct().getId()).equals(productId)){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Item> getAllItemsFromCart(Long cartId) {
        List<Item> items = (List)cartRedisRepository.getCart(cartId, Item.class);
        return items;
    }

    @Override
    public void deleteCart(Long cartId) {
        cartRedisRepository.deleteCart(cartId);
    }
}
