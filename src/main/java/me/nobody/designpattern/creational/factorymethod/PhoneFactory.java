package me.nobody.designpattern.creational.factorymethod;

public interface PhoneFactory {

    default Phone orderPhone(String name, String email) {
        validate(name, email);
        prepareFor(name);
        me.nobody.designpattern.creational.factorymethod.Phone phone = createPhone();
        sendEmailTo(email, phone);
        return phone;
    }

    private void validate(String name, String email) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("phone name cannot be blank");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("email cannot be blank");
        }
    }

    private void prepareFor(String name) {
        System.out.println(name + " ready.");
    }

    Phone createPhone();

    void sendEmailTo(String email, Phone phone);
}
