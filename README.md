# Celero Commerce Android Code Challenge

In this README, I will go over what I was able to accomplish for this coding challenge and what issues I ran into. 

[Link to Video Demo](https://res.cloudinary.com/deflyzun6/video/upload/v1601263240/celeroapp/celeroproject_ohoc2z.mp4)

The video demo shows the basic functionality of the app. There are also screenshots below.

# What I accomplished

I prioritized building an app that functioned in ideal conditions (that being a constant internet connection), so I started by focusing on the core functionality of the app;
this meant prioritizing the features that would be absolutely necessary if I had to use the app tomorrow. Since there wasn't enough time 
to implement everything that was asked, I went ahead and built the best product I could with the time given. 

The two most important pieces I was able to implement were Retrofit and SQLite. I prioritized these as they seemed to be the most essential parts of the
core functionality of the app, and I had never used them before, so I wanted to learn and implement them before I did anything else. 

*  I had never used Retrofit prior, so I spent a few hours getting through the learning curve. I was able to 
successfully retrieve JSON data from the API and use it to populate the ListView in the app.
*  Once I got Retrofit working properly, I moved on to getting the SQLite database up and running.
*  The SQLite database took the most time since I don't have much experience with SQL; I had to do a ton of research.
*  By Sunday, I was able to write data to the local SQLite database but struggled with data retrieval.
*  My goal with the SQLite database was to intercept the incoming JSON data and store it in the SQLite database
and then have the ListView pull from the local SQLite database.
*  I included in-code comments in the area where I couldn't get the read from database working. Check ListViewAdapter.java for that.
*  For UI design I went with something straightforward and easy to use, I felt that good UI design would be essential regardless.
*  I used the customer pictures as a placeholder, originally I wanted to use the service issue pictures but I didn't have
time to go back and fix the JSON parsing issue that was causing the links to those pictures to not be received properly.

<img src="https://res.cloudinary.com/deflyzun6/image/upload/v1601260118/celeroapp/Screenshot_1601260092_jeimja.png" alt="Screenshot 1" width="300"/> <img src="https://res.cloudinary.com/deflyzun6/image/upload/v1601260118/celeroapp/Screenshot_1601260098_y9y1wo.png" alt="Screenshot 2" width="300"/>


I added a Google maps button that took the provided GPS coordinates from the API and put them into Google Maps (As seen in the Demo). I also made
it so the text can be highlighted so customer numbers can be quickly called, or addresses quickly copied; this is because I noticed that the provided coordinates
were the same for multiple customers, so I wanted to make a back-up solution. 

You can also tap on the profile picture of the customer and the address automatically gets copied to your phone's clipboard. Might have been design overkill. 

Here are the screenshots.

<img src="https://res.cloudinary.com/deflyzun6/image/upload/v1601260417/celeroapp/Screenshot_1601260358_j8xp6x.png" alt="Screenshot 3" width="300"/> <img src="https://res.cloudinary.com/deflyzun6/image/upload/v1601260419/celeroapp/Screenshot_1601260371_jshbdm.png" alt="Screenshot 4" width="300"/>

Overall, I learned a lot from this project, specifically about how to use SQLite and Retrofit. I also learned the proper 
architecture for receiving and parsing JSON data in Android, as well as SQLite basics that I could build from in future projects. I 
wasn't aware of Retrofit before this, so it was fun learning how to implement that. I also got a better sense of how to use 
a ListView, which will come in handy later for sure. At the very least, I'm coming out knowing a lot more than I did going in. 

