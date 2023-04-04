package com.groceryApplication.exceptions;

public class WishlistNotExistsException extends RuntimeException{
	public WishlistNotExistsException(String msg) {
        super(msg);
    }

}
