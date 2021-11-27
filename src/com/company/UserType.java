package com.company;

public enum UserType {
        CUSTOMER (1, "customer"),
        SUPPLIER (2, "supplier");

        private int type;
        private String typeName;
        UserType(int i, String name) {
            type = i;
            typeName = name;
        }

        public int getType() { return type;}
        public String getTypeName() {return typeName;}
    }
