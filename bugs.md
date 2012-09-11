Bugs
=========

1. HTTP 408

When login directly to the entity via the proxy:
http://108.168.136.186/ajax/TruckCompanyWEB/rest/entities.tctruck

"Login time exceeded"

Is form auth really what we need?

2. JSON response / Datatables

[{"deleted":false,"deletedDate":null,"version":0,"brand":"Mack","plate":"111","id":1},{"deleted":false,"deletedDate":null,"version":0,"brand":"Scania","plate":"222","id":2},{"deleted":false,"deletedDate":null,"version":0,"brand":"Volvo","plate":"333","id":3}]

Should be like:

{   "results" : [{"deleted":false,"deletedDate":null,"version":0,"brand":"Mack","plate":"111","id":1},{"deleted":false,"deletedDate":null,"version":0,"brand":"Scania","plate":"222","id":2},{"deleted":false,"deletedDate":null,"version":0,"brand":"Volvo","plate":"333","id":3}] }

3. 


