package com.zsgs.InterviewPanelManagement.jsonconversion;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class ConvertJson {
    private static ConvertJson convertJson;
    private ConvertJson(){

    }
public static ConvertJson getConvertJson(){
        if(convertJson==null){
            convertJson=new ConvertJson();

        }
        return convertJson;
}
    public <T> void serialize(T t,String path){
        Gson gson=new Gson();
        String json=gson.toJson(t);

        try(PrintWriter write =new PrintWriter(path)){
            write.println(json);
        }
        catch (Exception e){
            System.out.println("Error : "+e.getMessage());
        }
    }
    public <T> T deserialize(Class<T> t,String path){
        Gson gson=new Gson();
        try(BufferedReader reader=new BufferedReader(new FileReader(path))){
            StringBuilder jsonBuilder=new StringBuilder();
            String line;
            while((line =reader.readLine())!=null){
                jsonBuilder.append(line);
            }
            String json=jsonBuilder.toString();
            return gson.fromJson(json,t);
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
    public <T> T deserialize(TypeToken<T> t, String path){
        Gson gson=new Gson();
        try(BufferedReader reader =new BufferedReader(new FileReader(path))){
            StringBuilder jsonBuilder=new StringBuilder();
            String line;
            while ((line=reader.readLine())!=null){
                jsonBuilder.append(line);
            }
            String json=jsonBuilder.toString();
            return gson.fromJson(json,t.getType());
        }
        catch (Exception e){
            System.out.println("Error : "+e.getMessage());
            return null;
        }
    }

}
