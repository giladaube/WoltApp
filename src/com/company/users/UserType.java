package com.company.users;

public enum UserType {
        CUSTOMER (1, "customer"),
        STORE (2, "store");

        private int type;
        private String typeName;
        UserType(int i, String name) {
            type = i;
            typeName = name;
        }

        public int getType() { return type;}
        public String getTypeName() {return typeName;}
    }
