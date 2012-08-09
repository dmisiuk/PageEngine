Help for dump base:
[PostgreSQL]
From command line:
# [dump]
# pg_dump -Utestuser -h localhost pageengine > pageengine.sql

## where pageengin - your database
## pageengine.sql - file of sql statement
## testuser - username

#[restore]

# psql -Utestuser -h localhost pageengine < pageengine.sql