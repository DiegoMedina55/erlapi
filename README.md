Api REST for the programing language course 2020-2

### Setting up intelliJ IDEA
This project uses the ANTLR 4 dependency in maven so there's no need to **manually import** ANTLR runtime file.  

The only thing to do is configure the ANTLR plugin to generate code

1. Open ANTLR4 plugging settings  
![Imgur](https://i.imgur.com/zxSOvkb.png)
  
2. Put this  
![Imgur](https://i.imgur.com/TJflg2Q.png)

3. That's it!

###  Heroku Deployment

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

