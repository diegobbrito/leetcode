package com.leetcode.sorting;

import java.util.*;

public class CouponCodeValidator {

//    https://leetcode.com/problems/coupon-code-validator
//    Time Complexity O(n)
//    Space Complexity O(n)

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        Set<String> validBusiness = Set.of("electronics", "grocery", "pharmacy", "restaurant");
        List<String> electronics = new ArrayList<>(),
                grocery = new ArrayList<>(),
                pharmacy = new ArrayList<>(),
                restaurant = new ArrayList<>();

        for(int i = 0; i < code.length; i++){
            if(isActive[i]){
                if(validBusiness.contains(businessLine[i])){
                    if(isValidCoupon(code[i])){
                        if(businessLine[i].startsWith("e"))
                            electronics.add(code[i]);
                        else if(businessLine[i].startsWith("g"))
                            grocery.add(code[i]);
                        else if(businessLine[i].startsWith("p"))
                            pharmacy.add(code[i]);
                        else
                            restaurant.add(code[i]);
                    }
                }
            }
        }

        Collections.sort(electronics);
        Collections.sort(grocery);
        Collections.sort(pharmacy);
        Collections.sort(restaurant);

        List<String> result = new ArrayList<>();
        result.addAll(electronics);
        result.addAll(grocery);
        result.addAll(pharmacy);
        result.addAll(restaurant);
        return result;
    }

    private boolean isValidCoupon(String code){
        if(code.isEmpty())
            return false;
        for(char c : code.toCharArray()){
            if(!Character.isLetterOrDigit(c) || c != '_')
                return false;
        }

        return true;
    }
}
