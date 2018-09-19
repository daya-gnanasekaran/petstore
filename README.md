# petstore
petstoreapp

# EntryPoint
 
java -jar Petstore.jar -file <filepath> [-name <value>] [-type <value>] [-gender <value>] [-zipcode <value>]
  
Main class : com.mypetstore.PetStore

# To Handle Adoption scenario
1. After displaying the search result, prompt user whether they like to adopt a pet
2. If yes, get the petd id they want to adopt.
2. Ask user details to determine eligibility to adopt. [Need business input to determine eligbility]
4. If user is eligible, then calculate adoption fees.[Need business input to calculate adoption fees] 
5. Confirm, whether they accpet the terms and collect the fees
6. Generate adoption record, store it and give the user a copy. [Assuming we will have a persistent store for the records]

# Testing
The code base has the unit tests and integration tests. They can be executed part of the CI process.

# Tools
Version control systems makes has lot of advantages to list a few it make collabration easier,maintains versions verisions of the artifacts and act as a journal of our changes and provides the ability go back to switch to older versions if needed.

There may be pain points while adopting to the process and dealing with conflicts. The adavantages we get with these systems overcomes these pain points.
 



