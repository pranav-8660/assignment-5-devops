package com.pranavv51.dummy_app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DummyTableService {

    Logger logger =  LoggerFactory.getLogger(DummyTableService.class);

    public List<String> getTableOfChoice(int tableOf){

        logger.info("Received a request for tables of "+tableOf);

        List<String> tablesOfGivenNoTill10 = new ArrayList<>();
        for(int i=1;i<=10;i++){
            int product = i*tableOf;
            String tableTuple = tableOf+" x "+i+" = "+product;
            tablesOfGivenNoTill10.add(tableTuple);
        }

        return tablesOfGivenNoTill10;
    }
}
