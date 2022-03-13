package com.company;

import com.company.users.Customer;
import com.company.users.IRealStore;
import com.company.users.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Implementation of a Database -
 * This DB will handle information using the file system
 * @implNote uses memory for now...
 * */
public class FileDB implements IDatabase{
    // Singleton class
    private FileDB(){}  // others can't create new DB
    private static class DatabaseHolder{
        public static final IDatabase db = new FileDB();
    }
    public static IDatabase getDatabase(){
        return DatabaseHolder.db;
    }
    // initial values should be gathered from Files, for now - memory
    private List<Customer> users = new ArrayList<>(){
        {
            add(new Customer("shai", "123", new Location(0, 0)));
            add(new Customer("or", "456", new Location(5, 0)));
            add(new Customer("gilad", "789", new Location(5, 5)));
        }
    };

    @Override
    public User checkUserExists(String name, String pass) {
        // need to really check if user exist (customer and store) and return that user if it does.
        // if it's not, return null.
        return new User();
//        int index = 0;
//        String name = user.getUserName();
//        // usernames with same name is not allowed for now
//        for(int i = 0; i < users.size(); i++){
//            if(users.get(i).getUserName().equals(name)){
//                index = i;
//                break;
//            }
//        }
//        return passwords.get(index).equals(pass);
    }

    @Override
    public void addUser(User user, String password) {
        return ;
//        users.add(user);
//        passwords.add(password);
    }

    @Override
    public List<IRealStore> getStores() {
        return null;
    }

    @Override
    public int addOrder(IOrder order) {
        // save given order in the db and return it's id.
        return 0;
    }


}
