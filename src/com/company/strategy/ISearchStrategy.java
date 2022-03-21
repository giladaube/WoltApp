package com.company.strategy;

import com.company.users.ARealStore;

public interface ISearchStrategy {
    boolean compare(ARealStore store1, ARealStore store2);
}
