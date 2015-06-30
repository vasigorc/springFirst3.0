/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.springfirst.model.Stories;

import com.vgorcinschi.springfirst.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author vgorcinschi
 */
@Component
@Qualifier("first")
public class FirstFloor implements Storey{
    private Office office;

    @Autowired
    public FirstFloor(
            @Qualifier("square") Office office) {
        this.office = office;
    }

    @Override
    public Office getOffice() {
        return office;
    }
}
