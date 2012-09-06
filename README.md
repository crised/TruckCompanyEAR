TruckCompanyEAR
=========

** Never push without synchronizing first **
** We should upload only useful sources **

Idea:

Make a sample web app (not real) to adapt it to small businesses needs. 

This ficticious web app / service (client & server side clearly separated) consist of:

10 truck small company that needs to keep track of the diesel consumptin of each truck. 

Therefore there are 4 PostgreSQL tables:

- tc_user: users/password table
- tc_truck: truck description
- tc_consumption: consumption of each truck, related to tc_truck
- tc_role: roles for users, related to tc_user

Always keep this folder structure:


1. Client Side: JS/Jquery. It should not be within the Eclipse Project.

2. TruckCompanyWEB: Only Sources of Web Project. No Eclipse configuration. 

3. TruckCompanyEJB: Only Sources of EJB Project. No Eclipse configuration.

4. PostgreSQL: Configuration of the DB.

5. Jboss AS7 Config

