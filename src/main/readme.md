How to Run Application :

1. Open as maven project in Intellj or any other IDE
2. Run Main.java class main method
3. Experiment with TollService methods to create toll/booth/process vehicle/purchase pass etc



Problem Statement :

Toll Management Application

We want to build an application which helps a toll company in managing different tolls across India.

1. There is a toll company having tolls across the country, with each toll having multiple toll booths.
2. Tolls have 3 kinds of toll pass
   a. Single Pass (one time use)
   b. Return pass (valid for current trip and one return trip within 24 hours)
   c. 7 day pass (unlimited passages in either direction for 7 days for that toll)
3. There are two kinds of vehicles - Two Wheeler and a 4 wheeler with different charges for above mentioned kinds of toll passes.

Assume that:

1. Tolls and Toll Booths are already registered in the system. APIs to register them are not needed.
2. Vehicle can be identified by its registration number.
3. Payment is handled offline. You only need to keep track of the sales.

Demonstrate:

1. Given a vehicle registration number and toll,
   a. If the vehicle has a valid pass, show the existing toll pass and let the vehicle go through.
   b. If there is no active pass, display charges for 3 different passes and allow the vehicle to choose one.
2. Build leaderboard of toll booth by number of vehicles processed and toll charges collected.

Evaluation Criteria:
1. Code walkthrough to showcase structure and modelling.
2. A demonstration of the functional requirements stated above.

For the demonstration, you can choose any of - CLI, API, Unit tests or a runner class.

Additional Notes:

1. You may use any programming language.
2. Database is optional.We don't recommend setting up a db, it takes a lot of time.In memory stores or flat files are acceptable for storing data.
3. You may access documentation and any other resources as needed.
