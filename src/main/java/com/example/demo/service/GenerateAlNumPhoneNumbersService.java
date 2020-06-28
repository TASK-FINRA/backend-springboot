package com.example.demo.service;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Service
public class GenerateAlNumPhoneNumbersService {

    private ArrayList<String> letterCombinationsUtil(ArrayList<Integer> numbers, int size, String[] numpad)
    {
        ArrayList<String> list = new ArrayList<>();

        Queue<String> q = new LinkedList<>();
        q.add("");

        while(!q.isEmpty())
        {
            String s = q.remove();
            if (s.length() != size){

                String val = numpad[numbers.get(s.length())];
                for (int i = 0; i < val.length(); i++)
                {
                    q.add(s + val.charAt(i));
                }
            }
            else
            {
                list.add(s);
            }
        }
        return list;
    }

    public List letterCombinations(String phoneNumber, int page, int size)
    {
        PagedListHolder resultPage = new PagedListHolder(getList(phoneNumber));

        resultPage.setPageSize(size);
        resultPage.setPage(page);

        return resultPage.getPageList();
    }

    public int getCount(String phoneNumber) {
        return getList(phoneNumber).size();
    }

    public List<String> getList(String phoneNumber){
        String pattern = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}|\\d{7}|\\d{3}-?\\d{4}";
        if(!phoneNumber.matches(pattern)) throw new IllegalArgumentException("Invalid Phone Number: Should be in this format 1234567890, 123-456-7890, (123)456-7890, (123)4567890, 1234567, 123-4567");
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i=0;i<phoneNumber.length();i++){
            if(Character.isDigit(phoneNumber.charAt(i))){
                numbers.add(Character.getNumericValue(phoneNumber.charAt(i)));
            }
        }

        String[] numpad = { "0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ" };

        return letterCombinationsUtil(numbers, numbers.size(), numpad);
    }
}
