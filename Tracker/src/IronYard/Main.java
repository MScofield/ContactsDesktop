package IronYard;

import jodd.json.JsonSerializer;

import spark.ModelAndView;
import spark.Session;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.io.FileWriter;
import java.util.ArrayList;
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import jodd.json.JsonSerializer;
import java.net.URL;


public class Main {

    public static HashMap<String, User> users = new HashMap<>();

    public static void main(String[] args) {

        Spark.init();
        Spark.get(
                "/",
                ((request, response) -> {
                    HashMap hashToSession = new HashMap();
                    Session session = request.session();
                    String userName = session.attribute("userName");
                    User user = users.get(userName);

                    if(user == null) {
                        return new ModelAndView(hashToSession, "login.html");
                    }else{
                        hashToSession.put("user", user);
                        hashToSession.put("address", "1000 tryingtoohard ave");
                        return new ModelAndView(hashToSession, "home.html");
                    }


                }),
                new MustacheTemplateEngine()
            );//end of SparkGet

        Spark.post(
                "/login",
                ((request, response) -> {
                    String name = request.queryParams("loginName");
                    User user = users.get(name);
                    if(user == null){
                        user = new User(name);
                        users.put(name, user);
                    }

                    Session session = request.session();
                    session.attribute("userName" , name);

                    response.redirect("/");
                    return "";
                })
        );

        Spark.post(
                "/logout",
                ((request, response) -> {
                    Session session = request.session();
                    session.invalidate();
                    response.redirect("/");
                    return "";
                })
        );

    }//end of MainMethod

}//end of MainClass
