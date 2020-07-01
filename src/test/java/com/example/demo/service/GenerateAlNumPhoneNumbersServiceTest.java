package com.example.demo.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class GenerateAlNumPhoneNumbersServiceTest {

    @Spy
    GenerateAlNumPhoneNumbersService generateAlNumPhoneNumbersService;

    @Before
    public void setUp() {
    }

    @Test
    public void letterCombinations() {
        List pageList = generateAlNumPhoneNumbersService.letterCombinations("1234567890",0,10);
        assertEquals(10,pageList.size());
    }

    @Test
    public void getCount() {
        int count = generateAlNumPhoneNumbersService.getCount("1234567890");
        assertNotEquals(0,count);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getCountException() {
        generateAlNumPhoneNumbersService.getCount("12345-678-90");
    }

    @Test
    public void getList() {
        List<String> list = generateAlNumPhoneNumbersService.getList("1234567890");
        assertNotNull(list);
    }
}