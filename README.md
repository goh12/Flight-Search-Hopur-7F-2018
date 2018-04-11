# FlightSearch
Driver fyrir postgres.

https://jdbc.postgresql.org/download.html
Í Netbeans:
1. Hægri klikk á libraries
2. Add library
3. Create (nafn jdbc)
4. setja jar sem var dl 
5. include-a


## Setup
1. Vera með postgres.
2. Búa til user: fsdev, password: fsdev123
3. Klóna FauxFlightDatabase https://github.com/frg17/fauxflightdb
4. Klóna FlightSearch https://github.com/goh12/Flight-Search-Hopur-7F-2018 (Það þarf að vera með JDBC).
5. Keyra ffdbpackes.py í FauxFlightDatabase
6. Keyra random_flight_generator.py í  FauxFlightDatabase
7. Keyra FlightSearch (Hér þarf að vera búið að ná í JDBC og hafa sem library í verkefni).
