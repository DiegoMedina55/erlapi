:boom: Api REST for the final project of PL class 2020-2

This proyect was created using [spring initializr](https://start.spring.io/) according to [this guide](https://medium.com/swlh/build-deploy-a-rest-api-from-scratch-using-spring-boot-and-aws-ecs-eb369137a020)


### :gear: Setting up intelliJ IDEA
This project uses the ANTLR 4 dependency in maven so there's no need to **manually import** ANTLR runtime file.  

The only thing to do is configure the ANTLR plugin to generate code

1. Open ANTLR4 plugging settings  
![Imgur](https://i.imgur.com/zxSOvkb.png)
  
2. Copy exactly the following fields, use this image as a guide  
![Imgur](https://i.imgur.com/TJflg2Q.png)

   Copy and paste **these fields**
```
    output directory where all the output is generated | {base}\erlapi\src\main\java 
    namespace for generated code                       | com.myerlang.erlapi.gen   
```


3. That's it! :facepunch:

### :rocket: Heroku Continious Deployment (New version)

Everything on `master` will be deployed on the server. **Never** commit changes that you now won't work  
Commit developing changes on `develop`, remember never use `master` or I'll cut your balls :scissors: .

### :rocket: Heroku Deployment (Old version)

I followed this [heroku guide](https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku) 

First, login into heroku from the shell
```shell
$ heroku login
```

Second, commit your changes 
```shell
$ git add .
$ git commit -m "first commit"
```

Finally, push it to heroku
```shell
$ git push heroku master
```

To get the deployment url use
```shell
$ heroku open
```
To save you the trouble, here's the link :  https://immense-river-16385.herokuapp.com/

I also ran into some troubles installing CLI
1. needed to [delete node js file](https://stackoverflow.com/questions/32853495/heroku-cli-error)

Made with :purple_heart:
