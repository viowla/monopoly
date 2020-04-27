package com.example.monopoly;

import java.util.Optional;

public class UserApp {
    private static Dao userDao;

    public static void main(String[]args) {
        userDao = new UserDao();

        Player user1 = getUser(0);
        System.out.println(user1);
        userDao.update(user1, new String[]{"Jake", "[email protected]"});

        Player user2 = getUser(1);
        userDao.delete(user2);
        userDao.save(new Player(1, "Julia"));

        userDao.getAll().forEach(player -> System.out.println(player.getName()));
    }

    private static Player getUser(long id) {
        Optional<Player> user = userDao.get(id);

        return user.orElseGet(
                () -> new Player(1, "no-existing user"));
    }
}
