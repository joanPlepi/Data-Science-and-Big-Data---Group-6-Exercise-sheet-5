# Group 6 - Exercise sheet 5

This are our solutions to sheet 5.
Group members:
* Enkeleza Elezi
* Ardit Meti
* Joan Plepi
* Xhulja Shahini

The code of exercises 2,3,4,5 it's in the src folder.
*P.S. Download and extract the input file:last-fm-sample1000000.tsv to resources folder.*

## Task 1) Horizontal Scalability

//Todo

## Task 2) Implement a Spark Program “UserClicks”

Code at:
```
src/main/java/de/fraunhofer/iais/kd/bda/spark/UserClicks.java
```
* **How many listening events has the artist “Mark Knopfler”?**
- *Answer*: 
```
(Mark Knopfler & Emmylou Harris,10)
(Mark Knopfler,117)
(Mark Knopfler & Eric Clapton,1)
(Mark Knopfler & Chet Atkins,1)
```
Only Mark Knopfler has **117**. In total (ft other artists): **189**

## Task 3) Implement a class UserSet

Code at:
```
src/main/java/de/fraunhofer/iais/kd/bda/spark/UserSet.java
```

## Task 4) Implement a Spark Program “UserSet”

Code at:
```
src/main/java/de/fraunhofer/iais/kd/bda/spark/UserSetApp.java
```
* **What is the userset of “Mark Knopfler”?**
- *Answer*: 
```
(Mark Knopfler & Emmylou Harris,[user_000532, user_000500, user_000705, user_000914, user_000162, user_000680, user_000691])
(Mark Knopfler,[user_000218, user_000934, user_000313, user_000577, user_000017, user_000655, user_000011, user_000530, user_000095, user_000691, user_000490, user_000705, user_000906, user_000426, user_000349, user_000603, user_000702, user_000427, user_000407, user_000269, user_000423, user_000666, user_000348, user_000986, user_000002, user_000861, user_000260, user_000261, user_000937])
(Mark Knopfler & Eric Clapton,[user_000836])
(Mark Knopfler & Chet Atkins,[user_000918])
```
Usersets with ft other artists shown above too.

## Task 5) Implement a Spark Program “CloseToMark” 

Code at:
```
src/main/java/de/fraunhofer/iais/kd/bda/spark/CloseToMark.java
```
* **Result**
```
(Jeff Beck,0.813953488372093)
(Zz Top,0.8082191780821918)
(Wishbone Ash,0.8378378378378378)
(Stevie Ray Vaughan And Double Trouble,0.84)
(Gary Moore,0.8085106382978724)
(Mark Knopfler,0.0)
(Camel,0.8409090909090909)
(Grand Funk Railroad,0.8055555555555556)
(Rainbow,0.847457627118644)
(Buena Vista Social Club,0.8461538461538461)
(B.B. King,0.8)
(Tesla,0.8378378378378378)
(Muddy Waters,0.8245614035087719)
```

## Task 6) Presentation of solution
Presentation at root of repository: group6.pptx
