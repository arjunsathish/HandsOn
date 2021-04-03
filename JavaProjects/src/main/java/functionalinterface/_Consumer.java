package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {
        Customer  customer = new Customer("Maria","99999");
        greetCustomer(customer);
        // Functional Interface Consumer takes one argument and print results.
        greetCustomerConsumer.accept(customer);
        greetCustomerBiConsumer.accept(customer,true);
        greetCustomerBiConsumer.accept(customer,false);

    }

    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.customerName +
                    ", thanks for registering phone number " +
                    customer.customerPhoneNumber);

    static BiConsumer<Customer,Boolean> greetCustomerBiConsumer = (customer,showPhoneNumber) ->
            System.out.println("Hello " + customer.customerName +
                    ", thanks for registering phone number " +
                    (showPhoneNumber  ? customer.customerPhoneNumber : "*****"));


    static void greetCustomer(Customer customer){
        System.out.println("Hello " + customer.customerName +
                ", thanks for registering phone number " +
                     customer.customerPhoneNumber);
    }

    static class Customer {
        String customerName;
        String customerPhoneNumber;

        public Customer(String customerName,String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
