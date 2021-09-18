package com.fantasy.dao;


public class Customer {
    private Integer cust_id;
    private String cust_name;
    private String cust_profession;
    private String cust_phone;
    private String email;

    @Override
    public String toString() {
        return "Customer.xml{" +
                "cust_id=" + cust_id +
                ", cust_name='" + cust_name + '\'' +
                ", cust_profession='" + cust_profession + '\'' +
                ", cust_phone='" + cust_phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
