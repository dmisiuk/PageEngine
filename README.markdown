#Help for dump base:
##PostgreSQL
## dump
###From command line:
	pg_dump -Utestuser -h localhost pageengine > pageengine.sql

where pageengin - your database, pageengine.sql - file of sql statement, testuser - username.

#restore
###From command line:
	psql -Utestuser -h localhost pageengine < pageengine.sql
	
	

##MySQL
## dump
###From command line:
	mysqldump -utestuser -p pageengine  > pageengine.sql

where pageengin - your database, pageengine.sql - file of sql statement, testuser - username.

#restore
###From command line:
	mysql -utesuser -p pageengine < pageengine.sql