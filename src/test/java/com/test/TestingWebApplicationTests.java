package com.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.test.service.MovieTestServiceImpl;

//@RunWith(SpringRunner.class)
@RunWith(Suite.class)
@Suite.SuiteClasses({ MovieTestServiceImpl.class})
public class TestingWebApplicationTests {

}