package com.example.dictionary;

import java.io.*;
import java.util.HashMap;

public class DictionarySaver {
    private HashMap<String,String> dictionaryList;
    DictionarySaver(){
        dictionaryList=new HashMap<>();
    }
    HashMap<String,String> getDictionaryList(){
        return dictionaryList; //the hashmap created is priivatte so using getter the hashmap is accessed by the other classes
    }
    //seraialization is to add the new words and create database
    void serializeHashMap() throws IOException { //IOException or try catch method is added to handle the unneccesary exceptions
        FileOutputStream fos=new FileOutputStream("dictionaryData");
        ObjectOutputStream oos=new ObjectOutputStream(fos);//output the list of string

        oos.writeObject(dictionaryList); //note down the new word inputted
        oos.close();//closing the files which are open
        fos.close();
        /* TRY AND CATCH METHOD OF EXCEPTION HANDLING
        try{
            FileOutputStream fos=new FileOutputStream("dictionaryData");
            ObjectOutputStream oos=new ObjectOutputStream(fos);

            oos.writeObject(dictionaryList);
            oos.close();
            fos.close();
            }
        catch(IOException ioe){
            ioe.printStackTrace();
            }
         */
    }
    //deseraialization is to access the database and getting the data
    void deserializeHashMap() throws IOException, ClassNotFoundException {

        FileInputStream file=new FileInputStream("DictionaryData");
        ObjectInputStream ois=new ObjectInputStream(file);//input the list of string

        dictionaryList =(HashMap<String, String>)ois.readObject();
    }
}
