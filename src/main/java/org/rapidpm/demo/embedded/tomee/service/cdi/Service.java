package org.rapidpm.demo.embedded.tomee.service.cdi;

import java.time.LocalDateTime;

/**
 * Created by sven on 26.05.15.
 */
public class Service {

public String doWork(){ return LocalDateTime.now().toString();}

}
