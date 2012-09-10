DB Relationships
=========
5 Tables, 4 Relationships

Tables:
tc_user: pkey id_user

tc_truck: pkey id_truck

tc_consumption: pkey id_consumption, fkey ctruck_id

tc_role: pkey tc_user, fkey tc_user 

tc_audit: pkey id, fkey consumptionid, fkey user_id 

Relationships:

(table_name column_name <-> column_name table_name )

@OnetoOne

tc_user id_user <-> tc_user tc_role

@OnetoMany
tc_user id_user <-> user_id tc_audit

tc_truck id_truck <-> ctruck_id tc_consumption

tc_consumption id_consumption <-> consumption_id tc_consumption




