package com.vgorcinschi.springfirst.contextconfig;

/**
 * Created by V_GORCIN on 6/30/2015.
 */

import com.vgorcinschi.springfirst.model.Building;
import com.vgorcinschi.springfirst.model.CircularOffice;
import com.vgorcinschi.springfirst.model.SquareOffice;
import com.vgorcinschi.springfirst.model.Stories.FirstFloor;
import com.vgorcinschi.springfirst.model.Stories.GroundFloor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.vgorcinschi.springfirst.model.Office;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Profile("twoFloors")
public class TwoStoriesBuildingConfig {

    @Bean
    public List<Office> getCircularOffices(){
        List<Office> ofs = new ArrayList<>();
        ofs.add(new CircularOffice(001));
        ofs.add(new CircularOffice(002));
        ofs.add(new CircularOffice(003));
        return ofs;
    }

    @Bean
    public GroundFloor groundFloor(){
        return new GroundFloor(getCircularOffices());
    }

    @Bean
    public List<Office> getSquareOffices(){
        List<Office> ofs = new ArrayList<>();
        ofs.add(new SquareOffice(101));
        ofs.add(new SquareOffice(102));
        ofs.add(new SquareOffice(103));
        return ofs;
    }

    @Bean
    public FirstFloor firstFloor(){
        return new FirstFloor(getSquareOffices());
    }

    @Bean
    public Building smallerBuilding(){
        return new Building(groundFloor(),firstFloor());
    }
}
