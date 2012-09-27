TODO LIST
=========

1. Authentication/Authorization (remember me? logic / session expiration). JsessionID cookie should have a defined expiration.

2. Implement data visualization scheme, for tc_consumption, tc_truck, tc_audit. (see wire frame)

3. Add forms to:

  a) enter a consumption. (Date - add to DataBase, Consumption Liters)

  b) enter a truck (Brand, Plate)


4. Add buttons to:

  a) delete a consumption row.

  d) delete a truck row. 


4. Add Admin Role. Admin: User + Delete Truck/Consumption

5. Handle & Response Exceptions like:

Caused by: org.postgresql.util.PSQLException: ERROR: duplicate key value violates unique constraint "unique_tc_truck_plate"
  Detail: Key (plate)=(5) already exists.
                        
