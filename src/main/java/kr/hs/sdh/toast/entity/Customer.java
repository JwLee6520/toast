package kr.hs.sdh.toast.entity;

public class Customer {
    private final String c_id;
    private final String c_password;
    private final String c_name;
    private final String c_identity;
    private final String c_email;
    private final String c_contact;
    private final String c_address;
    public Customer(
            String id,
            String password,
            String name,
            String identity,
            String email,
            String contact,
            String address
    ){
        this.c_id = id;
        this.c_password = password;
        this.c_name = name;
        this.c_identity = identity;
        this.c_email = email;
        this.c_contact = contact;
        this.c_address = address;
    }

    public String getId() {
        return c_id;
    }

    public String getPassword() {
        return c_password;
    }

    public String getName() {
        return c_name;
    }

    public String getIdentity() {
        return c_identity;
    }

    public String getEmail() {
        return c_email;
    }

    public String getContact() {
        return c_contact;
    }

    public String getAddress() {
        return c_address;
    }
}

