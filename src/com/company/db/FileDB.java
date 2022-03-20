package com.company.db;

import com.company.IOrder;
import com.company.Item;
import com.company.UserType;
import com.company.gsonAdapter.InterfaceAdapter;
import com.company.strategy.ISearchStrategy;
import com.company.strategy.PaymentMethod;
import com.company.users.ARealStore;
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
    private FileDB(){
        gson = new GsonBuilder()
                .registerTypeAdapter(PaymentMethod.class, new InterfaceAdapter<PaymentMethod>())
                .setPrettyPrinting().create();
        initCustomers(customersFile);
        initStores(storesFile);
    }  // others can't create new DB
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
        for(ARealStore s : getStores()){
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
            List<ARealStore> stores = getStores();
            stores.add((ARealStore) user);
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
    public ARealStore getStore(ISearchStrategy comparator) {
        // returns best store according to comparator picked by user
        List<ARealStore> stores =  getStores();
        assert stores.size() != 0;
        ARealStore bestStore = stores.get(0);
        for (int i = 0; i < stores.size() - 1; i++) {
            ARealStore curStore = stores.get(i);
            if(!comparator.compare(bestStore, curStore))
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

    public List<ARealStore> getStores() {
        ARealStore[] stores = getUsers(ARealStore[].class, storesFile);
        assert stores != null;
        return new ArrayList<>(Arrays.asList(stores));
    }

    private void initCustomers(String fileName){
        List<Customer> customers = new ArrayList<>();
        // can't use the short List create + add since gson is having troubles..
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

        ARealStore burgerStore = new ARealStore("burger","123","The little burger shop", "Frank Sinatra - 0523333333", burgerStoreItems, 3.9);
        ARealStore pizzaStore = new ARealStore("pizza","123", "Domino's Pizza", "Ozzy Osbourne - 0526666666", pizzaStoreItems, 5.0);
        ARealStore sushiStore = new ARealStore("sushi","123", "Japan in a dish", "Margaret Heafield Hamilton - 052999999", sushiStoreItems, 4.2);
        List<ARealStore> stores = new ArrayList<>();
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
