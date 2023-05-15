### Software Testing Project
## Art Ó Liatháin, Darragh Grealish and Karl Gilmartin


## Metrics
![Coverage](.github/badges/jacoco.svg)  Code Coverage

![Branches](.github/badges/branches.svg) Branch Coverage

![Strength](.github/CICDScripts/Images/Current_Image.svg) Test Strength via mutation Testing  (Red, Amber and Green)

## How to Run
Clone gitHub repo on to local machine( only tested with Mac and Windows). Open project in an Android Studio/ IntelliJ enviorment and emulate the application on a real or virtual device to view and interact with KAD Room Booking System App. Use an Pixel 3a API 33 using Temurium for the best UI experience, to get the api working though, you will need to get your Holiday Api Key from https://holidayapi.com (it's free) since I can't just share mine online and put it into local.properties on the KadWebsite file level and add the lines </br>
sdk.dir= your\\path\\to\\sdk  </br>
 
HOLIDAY_API_KEY = "your-api-key" </br>

## Overview Of Project
This project was completed with the intention of having a full working application which can allow various users access to our room booking portal. The app was developed and completed using TDD(Test Driven Development). Our android app was also tested using unit testing, UI/UX, Coverage, Mutation tests to ensure a high quaility and maintainable application. For the devlopment process we used an agile methodology loosely, I say loosely because the things we took from the methodolgy was the scrum framework idea of standups, this would be where we planned out the days work and decided who would do what, this was also where we mentioned any problems or bugs. We found in such a small group bug reporting felt like too much hassle and it was better to just directly say it to the other people on a project of such a scale. 

## Cool things we did</br></br>
Mutation Testing </br></br>
FireBase</br></br>
CICD Pipeline </br></br>
UI Testing</br></br>
Mutation badge </br></br>
Learned App Development</br></br>
Paramaterised Testing </br></br>
API and mocking </br></br>
SonarCloud </br></br>


## Testing and Contribution
**Activites** <br />
BookingConfirmationActivity - Darragh<br />
MainActivity  - Karl <br />
RoomBookingPageActivity - Darragh <br />
RoomSelectionActivity - Darragh <br />
FirebaseLogic - Karl <br />

**Logic** <br />
AuthLogic - Karl <br />
DateTimeLogic - Art <br />

**Unit Tests** <br />
DateTimeTest - Art <br />
MainActivityTest - Karl <br /> 

**UI Testing** <br />
BookingConfirmationUITest - Darragh<br /> 
EspressoTest - Karl <br /> 
AccesibilityTest - Karl <br />
RoomBookingUITest - Darragh <br />
RoomSelectionUITest - Darragh <br />

**QA Things**
Fixing code smells - Darragh </br></br>


**CICD** <br />
Mutation Testing - Art <br />
coverage Testing - Art <br />
Gradle Dependencies - Art <br />
Total - 100% Art






