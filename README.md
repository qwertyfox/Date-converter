# DateConverter
Simple Java based console application to convert dates from AD to BS and BS to AD. <br>
Unlike the Gregorian calendar, Bikram Sambhat calendar does not follow strict rules and patterns. <br> 
I needed an accurate converter, so I created this application mostly to convert BS dates to AD dates manually and quickly, since the available solutions were online and converting multiple dates was tedious. <br>

## Description:
- Console based Java application. <br>
- Recognises only dd/MM/yyyy format date for both cases. <br>
- Current BS data set only includes dates from 2050 till 2084. This can easily be changed through configurations. <br>
- There is no error handling. <br>

## Code and logic:
- The BS years are stored inside the [data](https://github.com/qwertyfox/Date-converter/tree/master/data) following (year, number of days in Baishak, number of days in Jestha and so on... )<br>
- This data is read by CalanderInitilizer and internal maps and lists are created. <br>
- The beginning of the data set, i.e. (2050, 31...) is connected with 13/04/1993 because the BS calendar date 01/01/2050 aligns with it. <br>
- Being the project that I did as I figured out the logic, the logic are written in [logic](https://github.com/qwertyfox/Date-converter/tree/master/src/main/java/com/qwertyfox/logic) package. <br>
- 
