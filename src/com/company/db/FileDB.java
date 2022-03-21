package com.company.db;

import com.company.orders.IOrder;
import com.company.orders.Item;
import com.company.users.UserType;
import com.company.gsonAdapter.InterfaceAdapter;
import com.company.strategy.ISearchStrategy;
import com.company.strategy.PaymentMethod;
import com.company.users.RealStore;
import com.company.users.Customer;
import com.company.users.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.exit;

/**
 * Concrete Implementation of a Database -
 * This DB will handle information using the file system
 * @implNote uses memory for now...
 * */
public class FileDB implements IDatabase{
    private final String customersFile = "src\\com\\company\\db\\Customers.json";
    private final String storesFile = "src\\com\\company\\db\\Stores.json";
    private Reader reader = null;
    private Writer writer = null;
    private Gson gson;  // outsource adapter
    // Singleton class
    private FileDB(){ // private CTOR, others can't create new DB
        gson = new GsonBuilder()
                .registerTypeAdapter(PaymentMethod.class, new InterfaceAdapter<PaymentMethod>())
                .setPrettyPrinting().create();
        initCustomers(customersFile);
        initStores(storesFile);
    }
    private static class DatabaseHolder{
        public static final IDatabase db = new FileDB();
    }
    public static IDatabase getDatabase(){
        return DatabaseHolder.db;
    }

    @Override
    public User checkUserExists(String name, String pass) {
        for(Customer c : getCustomers()){
            if(c.getUserName().equals(name) && c.getPassword().equals(pass))
                return c;
        }
        for(RealStore s : getStores()){
            if(s.getUserName().equals(name) && s.getPassword().equals(pass))
                return s;
        }
        return null;
    }

    @Override
    public void saveUser(User user) {
        if(user.getUserType() == UserType.CUSTOMER){
            List<Customer> cs = getCustomers();
            cs.add((Customer) user);
            save(cs, customersFile);
        }
        else{
            List<RealStore> stores = getStores();
            stores.add((RealStore) user);
            save(stores, storesFile);
        }
    }

    @Override
    public void deleteUser(User user){
        // not implemented..
    }

    @Override
    public int addOrder(IOrder order) {
        // save given order in the db and return it's id.
        return 0;
    }

    @Override
    public RealStore getBestStore(ISearchStrategy comparator) {
        // returns best store according to comparator picked by user
        List<RealStore> stores =  getStores();
        assert stores.size() != 0;
        RealStore bestStore = stores.get(0);
        for (RealStore curStore : stores) {
            if (!comparator.compare(bestStore, curStore))
                bestStore = curStore;
        }
        return bestStore;
    }

    public List<Customer> getCustomers(){
        Customer[] customers = getUsers(Customer[].class, customersFile);
        assert customers != null;
        return new ArrayList<>(Arrays.asList(customers));
    }

    private <T> T[] getUsers(Class<T[]> classOfT, String filename){
        try {
            reader = new FileReader(filename);

            T[] users = gson.fromJson(reader, classOfT);
            reader.close();
            return users;
        } catch (IOException e) {
            e.printStackTrace();
            exit(-1);  // in-case file doesn't exist we will terminate the program
            return null;
        }
    }

    public List<RealStore> getStores() {
        RealStore[] stores = getUsers(RealStore[].class, storesFile);
        assert stores != null;
        return new ArrayList<>(Arrays.asList(stores));
    }

    private void initCustomers(String fileName){
        List<Customer> customers = new ArrayList<>();
        Customer c1 = new Customer("shai", "123");
        Customer c2 = new Customer("or", "456");
        Customer c3 = new Customer("gilad", "789");
        customers.add(c1);
        customers.add(c2);
        customers.add(c3);
        save(customers, fileName);
    }

    private void initStores(String fileName){
        List<Item> burgerStoreItems = new ArrayList<>(){
            {
                add(new Item("Texas's choice", "200g burger", 60));
                add(new Item("Big One", "300g burger", 70));
                add(new Item("Vegan burger", "vegan burger", 50));
            }
        };
        List<Item> pizzaStoreItems = new ArrayList<>(){
            {
                add(new Item("Joey doesn't share food", "Personal pizza", 30));
                add(new Item("For you & me", "Medium size pizza", 50));
                add(new Item("Family size", "Extra Large pizza", 80));
            }
        };
        List<Item> sushiStoreItems = new ArrayList<>(){
            {
                add(new Item("Salmon roll", "Fresh Norwegian salmon", 70));
                add(new Item("Tuna roll", "Deepwater blue tuna", 80));
                add(new Item("Fish Salad", "A combination of various fish and vegetables", 100));
            }
        };

        RealStore burgerStore = new RealStore("burger","123","The little burger shop", "Frank Sinatra - 0523333333", burgerStoreItems, 3.9);
        RealStore pizzaStore = new RealStore("pizza","123", "Domino's Pizza", "Ozzy Osbourne - 0526666666", pizzaStoreItems, 5.0);
        RealStore sushiStore = new RealStore("sushi","123", "Japan in a dish", "Margaret Heafield Hamilton - 052999999", sushiStoreItems, 4.2);
        List<RealStore> stores = new ArrayList<>();
        stores.add(burgerStore);
        stores.add(pizzaStore);
        stores.add(sushiStore);
        save(stores, fileName);

    }

    private void save(Object obj, String path){
        try {
            writer = new FileWriter(path);
            gson.toJson(obj, writer);
            writer.flush(); //flush data to file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
