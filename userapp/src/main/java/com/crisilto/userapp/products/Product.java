package com.crisilto.userapp.products;

public class Product {
    private String status, message, data;
    public Product(){}

    public Product(String status, String message, String data){
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getData() {
        return data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString(){
        return "Product: [status=" + status + ", message=" + message + ", data=" + data + "]";
    }
}
