package com.crisilto.productapp;

public class Product {
    private String status;
    private String message;
    private String data;

    public Product(){}

    public Product(String status, String message, String data){
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    @Override
    public String toString(){
        return "Product: [status=" + status + ", message=" + message + ", data=" + data + "]";
    }
}
