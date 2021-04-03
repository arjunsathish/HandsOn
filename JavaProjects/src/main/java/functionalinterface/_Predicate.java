package functionalinterface;

import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {
        System.out.println(isPhoneNumberValid("07752626266"));
        System.out.println(isPhoneNumberValid("09752626266"));
        System.out.println(isPhoneNumberValidPredicate.test("07752626266"));
        System.out.println(isPhoneNumberValidPredicate.test("09752626266"));
        System.out.println(isPhoneNumberValidPredicate.test("09752626266"));

        System.out.println("Is Phone number valid and contains 3 "+
                isPhoneNumberValidPredicate.and(containsNumber3)
                        .test("07752626266"));
        System.out.println("Is Phone number valid or contains 3 "+
                isPhoneNumberValidPredicate.or(containsNumber3)
                        .test("0875"));

    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    static Predicate<String> containsNumber3 = phoneNumber ->
            phoneNumber.contains("5");
}
