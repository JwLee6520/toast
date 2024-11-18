package kr.hs.sdh.toast.entity;

public class BankCustomer {
    private final String name;
    private final String identity;
    private final String email;
    private final String contact;
    private final String address;
    private final String b_uuid;

    public BankCustomer(
            String name,
            String identity,
            String email,
            String contact,
            String address,
            String b_uuid
    ){
        this.name = name;
        this.identity = identity;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.b_uuid = b_uuid;
    }
    public String getName() {
        return name;
    }

    public String getIdentity() {
        return identity;
    }

    public String getEmail() {
        return email;
    }

    public String getContact() {
        return contact;
    }

    public String getAddress() {
        return address;
    }

    public String getB_uuid() {
        return b_uuid;
    }


}
