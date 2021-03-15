# QA CRUD Project

This README will serve as documentation for my CRUD project. 

# C11Crypto

## Pages relating to this project

* Jira board (I believe this is inaccessible without my credentials, so I have provided an image of my sprint and a user story below) 
* ## ![image](https://user-images.githubusercontent.com/10779091/111126331-7e7bc400-856a-11eb-84c9-3926ff61e5b3.png)
* ![image](https://user-images.githubusercontent.com/10779091/111128301-a3713680-856c-11eb-9f8f-b28a2a0b215d.png)

* [Front end github repository](https://github.com/joshua-hs/C11CryptoFrontEnd)

## Project and application overview, with initial thoughts

This project is designed to encapsulate many aspects of software engineering, including full stack development, testing, github integration and project management.

My initial idea was to create a mock stock trading platform. Unfortunately, I soon ran into many issues. For example, many of the free APIs I tried were unable to provide real-time share prices from the London Stock Exchange, which meant that prices would only update once per day sometime after 4:30pm. In addition, some APIs were severely outdated. One API I tried hadn't updated the share price of BAE Systems since November 2020. I then had the idea of using American shares from the NYSE or NASDAQ as many free APIs provide real-time data for these, but the problem here was that these exchanges do not open until 2:30pm GMT, meaning that if I presented my project before then, the prices also wouldn't update. This led me to switch my approach and instead decide on creating a mock cryptocurrency exchange, as the crypto markets never sleep. 

As said above, C11Crypto is a mock cryptocurrency exchange, where you can "purchase" Bitcoin as well as a variety of altcoins. Each user begins with $1,000,000 of capital and can trade as they please. This being a very simple project, margin/leverage trading is not supported. 

The "C11" at the start of the title stands for Cohort 11. 


## Tech stack

This project uses the traditional trio of HTML/CSS/JS for the front end, Java paired with Spring for the back end, and a local H2 console for the database. The front end utilizes bootstrap and a small amount of jQuery.

tldr: H2 Database <---> Java/Spring <---> HTML/CSS/JS

I also used github to store my codebase. I will include a visual representation of my branches/commits for my back end repository below.

![image](https://user-images.githubusercontent.com/10779091/111132425-3dd37900-8571-11eb-8ecc-444677e49094.png)

Screenshot of main UI below. Crypto markets are in a downtrend, it seems:

![image](https://user-images.githubusercontent.com/10779091/111129011-80935200-856d-11eb-8adb-5a83dcf21f2c.png)

Here is a screenshot of a user purchasing some EOS tokens (a digital currency, similar to Bitcoin):

![image](https://user-images.githubusercontent.com/10779091/111131358-17f9a480-8570-11eb-9e40-f72c34bc3a14.png)

This is what a GET request response retrieving all open positions looks like:

![image](https://user-images.githubusercontent.com/10779091/111133774-cd2d5c00-8572-11eb-8efe-0b63e4bec55f.png)




## Testing

Admittedly, I struggled somewhat with testing. My integration tests were done using MockMVC, and my unit tests with Mockito. Whilst my integration tests all passed, I was unable to debug my unit tests regarding my update methods, and these tests unfortunately did not pass. Evidence of this is shown below. 

integration tests all passing:

![image](https://user-images.githubusercontent.com/10779091/111129812-6e65e380-856e-11eb-9e48-0eb2ca49e1f8.png)
![image](https://user-images.githubusercontent.com/10779091/111129886-8178b380-856e-11eb-81f3-83a048da66d1.png)

unit tests all passing bar update methods:

![image](https://user-images.githubusercontent.com/10779091/111130336-019f1900-856f-11eb-8f06-0cfc0aeba6ec.png)
![image](https://user-images.githubusercontent.com/10779091/111130365-0c59ae00-856f-11eb-88f2-4af96200f1f7.png)

In addition to these, I also used the Selenium framework to simulate a user interacting with my front end, and whilst this proved somewhat successful, I did find it to be a little temperamental. Sometimes the code would run smoothly and Selenium would execute everything flawlessly, but other times it would struggle to find elements within my webpage. 

Overall, testing is an area I could've (and should've) done much better.
