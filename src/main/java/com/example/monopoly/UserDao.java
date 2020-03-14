package com.example.monopoly;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UserDao implements Dao<Player> {

    private List<Player> users = new ArrayList<>();

    public UserDao() {
        users.add(new Player(1, "John"));
        users.add(new Player(2, "Susan"));
    }

    @Override
    public Optional<Player> get(long id) {
        return Optional.ofNullable(users.get((int) id));
    }

    @Override
    public List<Player> getAll() {
        return users;
    }

    @Override
    public void save(Player user) {
        users.add(user);
    }

    @Override
    public void update(Player user, String[]params) {
        user.setName(Objects.requireNonNull(
                params[1], "Name cannot be null"));
        user.setId(Objects.hash(1));
        users.add(user);
    }

    @Override
    public void delete(Player user) {
        users.remove(user);
    }
}
