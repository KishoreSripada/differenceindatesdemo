# Application
REST Service End-point to compute date difference in days for any two dates
PROBLEM: Calculate the difference between two dates.

Description:
. Create an application that can read in pairs of dates in the following format -
		DD MM YYYY, DD MM YYYY
. Validate the input data, and compute the difference between the two dates in days.
. Output of the application should be of the form -
		DD MM YYYY, DD MM YYYY, difference
. Where the first date is the earliest, 
  the second date is the latest and the difference is the number of days.
. Input can be from a file, or from standard input
. Provide test data to exercise the application.
. Add the overview of the selected solution as comments.
. Expose the above functionality as a REST API

Notes:
. The solution should not make use of the Java libraries for date manipulation 
(for example Date, Calendar classes).
. The application can limit calculation on an input range of dates from 1900 to 2010

NOTES
1. Error message will be displayed for any erroneous input parameters (Ex. passing 1 query param, 
passing in wrong pattern, having out of range days/month/year values) 
2. This solution to the date difference problem is the basic implementation.
3. Unit Testing - Mockito has been implemented.
4. "test data" deliverable - AllTestSuites class to be run with coverage to run all the tests for the application
5. Assuming that the required date format "DD MM YYYY" implies that a leading zero is required for days/months less
than 10.
6. Leap years are not considered for this basic implementation and no. of days in a year 
is considered as 365

Prerequisites
1. Install Java 8
2. Install Maven
3. Install Git

INSTRUCTIONS to clone repo, build and run:

    To Clone the date-difference-demo repository, 
    run "git clone https://github.com/KishoreSripada/differenceindatesdemo.git"

    To build the application, run all tests, and build the project
    IntelliJ Idea -> Run the below command as Maven Goal
    "mvn clean install" in the root directory.

    To run the SpringBoot Server, 
    java -jar target/datedemo-0.0.1-SNAPSHOT.jar
        
    To test the application, please use any of the popular Rest Clients:
    1. PostMan (Chrome)
    2. Soap UI
    
    Hit the GET request for the below URL - 
    http://localhost:8080/DateService/DifferenceInDates?startDate=13 05 2009&endDate=23 05 2009
    Query Parameters (startDate, endDate) in the pattern DD MM YYYY

    Some Sample input/output:
    1)Input: 
    http://localhost:8080/DateService/DifferenceInDates?startDate=13 05 2009&endDate=23 05 2009
    Output: [
                "13 05 2009",
                "23 05 2009",
                10
            ]

    2)Input: http://localhost:8080/DateService/DifferenceInDates?startDate=13 05 2008&endDate=23 05 2009
     Output :
     [
         "13 05 2008",
         "23 05 2009",
         375
     ]
     
    3)Input: http://localhost:8080/DateService/DifferenceInDates?startDate=13 05 2008
    {
        "timestamp": 1512581656260,
        "status": 400,
        "error": "Bad Request",
        "exception": "org.springframework.web.bind.MissingServletRequestParameterException",
        "message": "Required String parameter 'endDate' is not present",
        "path": "/DateService/DifferenceInDates"
    }
    
    4) Input: http://localhost:8080/DateService/DifferenceInDates?startDate=13/05/2008&endDate=23 05 2009
    Output:
    [
        "Expected to be of form 'DD MM YYYY', found '13/05/2008'"
    ]
     
    5)Input: http://localhost:8080/DateService/DifferenceInDates?startDate=33 05 2008&endDate=23 05 2009
      Output: 
      [
           "Day can only contain values between 1 and 31 found value:33"
      ]
