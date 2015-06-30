/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.vgorcinschi.springfirst.contextconfig.BuildingConfig;
import com.vgorcinschi.springfirst.model.Building;
import com.vgorcinschi.springfirst.model.Stories.Storey;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 *
 * @author vgorcinschi
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={BuildingConfig.class})
public class BuildingTest {
    
    @Rule
    public final StandardOutputStreamLog log = 
            new StandardOutputStreamLog();
    
    @Autowired
    @Qualifier("ground")
    private Building building;
    
    @Autowired
    @Qualifier("circle")
    private Storey storey;
    
    @Test
    public void storeyShouldNotBeNull(){
        assertNotNull(storey);
    }
    
    @Test
    public void getShape(){        
        assertEquals("Circle", building.getFirst().getOffice().getShape());
    }
}
