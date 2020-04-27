package com.example.monopoly;

import com.example.monopoly.models.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan("com.example.monopoly")
@PropertySource("application.properties")
public class SpringConfiguration {
    @Bean
    public List<Player> playerList(){
List<Player>playerList = new ArrayList<>();
playerList.add(new Player(1, "user1"));
playerList.add(new Player(2, "user2"));
playerList.add(new Player(3, "user3"));
playerList.add(new Player(4, "user4"));
playerList.add(new Player(5, "user5"));
return playerList;
    }

    @Bean
    public List<Square> squareList(){
        List<Square> squareList=new ArrayList<>();
        squareList.add(new GoSquare("Go Square"));
        squareList.add(new GoToJailSquare("Go to jail square"));
        squareList.add(new HouseSquare("house square",200));
        squareList.add(new JailSquare("Jail square"));
        squareList.add(new VacationSquare("Vacation square"));

        return squareList;
    }

}
