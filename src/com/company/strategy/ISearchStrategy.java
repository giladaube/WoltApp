package com.company.strategy;

import com.company.users.RealStore;

public interface ISearchStrategy {
    boolean compare(RealStore store1, RealStore store2);
}
